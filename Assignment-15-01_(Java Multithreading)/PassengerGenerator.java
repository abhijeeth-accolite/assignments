import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PassengerGenerator implements Runnable {

    public static final int MIN_DELAY = 3000;
    public static final int MAX_DELAY = 6000;
    public static final int MIN_PASSENGER_ID = 100000;
    public static final int MAX_PASSENGER_ID = 999999;

    private LinkedBlockingQueue<Passenger> pq;

    public PassengerGenerator(LinkedBlockingQueue<Passenger> pq) {
        this.pq = pq;
    }

    public void run() {
        while (true) {
            try {
                int pid = (int) ((Math.random() * ((MAX_PASSENGER_ID - MIN_PASSENGER_ID) + 1)) + MIN_PASSENGER_ID);
                int dest = (int) (Math.random() * Location.values().length);
                int delay = (int) ((Math.random() * ((MAX_DELAY - MIN_DELAY) + 1)) + MIN_DELAY);
                pq.put(new Passenger(pid, Location.values()[dest]));
                // System.out.println("Passenger Queue : " + pq.toString());
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}