import java.util.*;
import java.text.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Taxi implements Runnable {
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public static final int TAXI_SIZE = 4;
    public static final int DRIVER_OBSERVATION_DELAY = 100; // milliseconds
    public static final int MAX_STAND_WAIT_TIME = 45000; // milliseconds

    private int id;
    private Location destination;
    private ConcurrentHashMap<Integer, Passenger> occupiedSeats = new ConcurrentHashMap<Integer, Passenger>(TAXI_SIZE);

    private TaxiState state = TaxiState.WAITING_IN_QUEUE;
    private LinkedBlockingQueue<Taxi> stands;
    private LinkedBlockingQueue<Taxi> tq;
    private int standWaitTime = 0;

    public Taxi(int id, LinkedBlockingQueue<Taxi> stands, LinkedBlockingQueue<Taxi> tq) {
        this.id = id;
        this.stands = stands;
        this.tq = tq;
    }

    public Location getDestination() {
        return this.destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public void occupySeat(Passenger p) {
        occupiedSeats.put(p.getId(), p);
    }

    public ConcurrentHashMap getOccupiedSeats() {
        return this.occupiedSeats;
    }

    public TaxiState getState() {
        return this.state;
    }

    public boolean waitingForPassengers() {
        return this.state == TaxiState.WAITING_FOR_PASSENGERS;
    }

    @Override
    public String toString() {
        String str = "TAXI<" + this.id + "> -> (" + this.destination + ")";
        return str;
    }

    @Override
    public void run() {

        while (this.state != TaxiState.READY_TO_DEPART) {
            try {
                if (this.state == TaxiState.WAITING_IN_QUEUE) {
                    if (tq.peek() == this && stands.size() < TaxiStand.TAXI_STAND_SIZE) {
                        stands.put(tq.take());
                        this.state = TaxiState.WAITING_FOR_PASSENGERS;
                        System.out.println(dateFormat.format(new Date()) + " : " + this + " moved from queue to stand"); // log
                    } else {
                        Thread.sleep(DRIVER_OBSERVATION_DELAY);
                    }
                }
                if (this.state == TaxiState.WAITING_FOR_PASSENGERS) {
                    this.standWaitTime += 100;
                    if (this.standWaitTime > MAX_STAND_WAIT_TIME || occupiedSeats.size() == TAXI_SIZE) {
                        this.state = TaxiState.READY_TO_DEPART;
                        stands.remove(this);
                        System.out.println(dateFormat.format(new Date()) + " : " + this + " left the taxi stand with "
                                + this.occupiedSeats.size() + " passengers"); // log
                    } else {
                        Thread.sleep(DRIVER_OBSERVATION_DELAY);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public enum TaxiState {
        WAITING_IN_QUEUE, WAITING_FOR_PASSENGERS, READY_TO_DEPART;
    }
}