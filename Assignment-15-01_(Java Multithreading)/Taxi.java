import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Taxi implements Runnable {
    public static final int TAXI_SIZE = 4;
    public static final int DRIVER_OBSERVATION_DELAY = 100; // milliseconds
    public static final int MAX_STAND_WAIT_TIME = 30000; // milliseconds

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
                        System.out.println("TaxiStand : " + stands.toString());
                    } else {
                        Thread.sleep(100);
                    }
                }
                if (this.state == TaxiState.WAITING_FOR_PASSENGERS) {
                    this.standWaitTime += 100;
                    if (this.standWaitTime > MAX_STAND_WAIT_TIME) {
                        this.state = TaxiState.READY_TO_DEPART;
                        stands.remove(this);
                        System.out.println(this.toString() + " is leaving the stand");
                    } else {
                        Thread.sleep(100);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    enum TaxiState {
        WAITING_IN_QUEUE, WAITING_FOR_PASSENGERS, READY_TO_DEPART;
    }
}