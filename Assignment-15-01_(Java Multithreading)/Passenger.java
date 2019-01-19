import java.util.*;
import java.text.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Passenger implements Runnable {
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private int id;
    private Location destination;

    private PassengerState state = PassengerState.WAITING_IN_QUEUE;
    private LinkedBlockingQueue<Taxi> stands;
    private LinkedBlockingQueue<Passenger> pq;

    public Passenger(int id, Location destination, LinkedBlockingQueue<Taxi> stands,
            LinkedBlockingQueue<Passenger> pq) {
        this.id = id;
        this.destination = destination;
        this.stands = stands;
        this.pq = pq;
    }

    public int getId() {
        return this.id;
    }

    public Location getDestination() {
        return this.destination;
    }

    @Override
    public String toString() {
        return "Passenger<" + this.id + "> -> (" + this.destination + ")";
    }

    @Override
    public void run() {
        while (this.state == PassengerState.WAITING_IN_QUEUE) {
            try {
                if (pq.peek() == this) {
                    for (Taxi t : stands) {
                        if (t.getDestination() == null) {
                            t.setDestination(this.destination);
                            t.occupySeat(pq.take());
                            this.state = PassengerState.SITTING_IN_TAXI;
                            System.out.println(
                                    dateFormat.format(new Date()) + " : " + this + " moved from queue to " + t); // log
                            break;
                        } else if (t.getDestination() == this.destination && t.waitingForPassengers()
                                && t.getOccupiedSeats().size() < Taxi.TAXI_SIZE) {
                            t.occupySeat(pq.take());
                            this.state = PassengerState.SITTING_IN_TAXI;
                            System.out.println(
                                    dateFormat.format(new Date()) + " : " + this + " moved from queue to " + t); // log
                            break;
                        }
                    }
                } else {
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    enum PassengerState {
        WAITING_IN_QUEUE, SITTING_IN_TAXI
    }
}