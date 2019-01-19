import java.util.*;
import java.text.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class TaxiStand {
    static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public static final int TAXI_STAND_SIZE = 5;
    public static LinkedBlockingQueue<Taxi> stands = new LinkedBlockingQueue<>(TAXI_STAND_SIZE);

    public static void main(String args[]) {

        LinkedBlockingQueue<Passenger> pq = new LinkedBlockingQueue<Passenger>();
        LinkedBlockingQueue<Taxi> tq = new LinkedBlockingQueue<Taxi>();

        PassengerGenerator pg = new PassengerGenerator(pq, stands);
        TaxiGenerator tg = new TaxiGenerator(tq, stands);

        new Thread(pg).start();
        System.out.println(dateFormat.format(new Date()) + " : Started passenger generator!");
        new Thread(tg).start();
        System.out.println(dateFormat.format(new Date()) + " : Started taxi generator!");
    }
}