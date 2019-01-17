import java.util.*;

public class PersonInfo implements PersonService {

    private static Map<Integer, Person> people = new HashMap<Integer, Person>();

    @Override
    public boolean addPerson(Person p) {
        if (people.get(p.getId()) != null)
            return false;
        people.put(p.getId(), p);
        return true;
    }

    @Override
    public boolean deletePerson(int id) {
        if (people.get(id) == null)
            return false;
        people.remove(id);
        return true;
    }

    @Override
    public Person getPerson(int id) {
        return people.get(id);
    }

    @Override
    public Person[] getAllPeople() {
        Set<Integer> ids = people.keySet();
        Person[] p = new Person[ids.size()];
        int i = 0;
        for (Integer id : ids) {
            p[i] = people.get(id);
            i++;
        }
        return p;
    }

}