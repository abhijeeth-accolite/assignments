import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class TaxiStand {
    public static final int TAXI_STAND_SIZE = 5;
    public static LinkedBlockingQueue<Taxi> stands = new LinkedBlockingQueue<>(TAXI_STAND_SIZE);

    public static void main(String args[]) {

        LinkedBlockingQueue<Passenger> pq = new LinkedBlockingQueue<Passenger>();
        LinkedBlockingQueue<Taxi> tq = new LinkedBlockingQueue<Taxi>();

        PassengerGenerator pg = new PassengerGenerator(pq);
        TaxiGenerator tg = new TaxiGenerator(tq, stands);

        new Thread(pg).start();
        new Thread(tg).start();
    }
}