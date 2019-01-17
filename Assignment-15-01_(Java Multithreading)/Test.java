import java.util.*;
import java.util.concurrent.*;

class Test {

    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> t = new LinkedBlockingQueue<Integer>(3);
        try {

            t.put(1);
            t.put(2);
            t.put(7);
            t.remove(2);
            System.out.println("hello world");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}