import java.util.*;
import java.text.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaxiGenerator implements Runnable {
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    public static final int MIN_DELAY = 4000;
    public static final int MAX_DELAY = 8000;
    public static final int MIN_TAXI_ID = 10000;
    public static final int MAX_TAXI_ID = 99999;

    private LinkedBlockingQueue<Taxi> tq;
    private LinkedBlockingQueue<Taxi> stands;

    public TaxiGenerator(LinkedBlockingQueue<Taxi> tq, LinkedBlockingQueue<Taxi> stands) {
        this.tq = tq;
        this.stands = stands;
    }

    public void run() {
        while (true) {
            try {
                int tid = (int) ((Math.random() * ((MAX_TAXI_ID - MIN_TAXI_ID) + 1)) + MIN_TAXI_ID);
                int delay = (int) ((Math.random() * ((MAX_DELAY - MIN_DELAY) + 1)) + MIN_DELAY);
                Taxi newTaxi = new Taxi(tid, stands, tq);
                tq.put(newTaxi);
                new Thread(newTaxi).start();
                System.out.println(dateFormat.format(new Date()) + " : " + newTaxi + " joined the TAXI QUEUE"); // log
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}