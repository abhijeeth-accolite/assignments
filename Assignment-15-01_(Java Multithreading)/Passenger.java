import java.util.*;

public class Passenger {
    private int id;
    private Location destination;

    public Passenger(int id, Location destination) {
        this.id = id;
        this.destination = destination;
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
}