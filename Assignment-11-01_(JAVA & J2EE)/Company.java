import java.util.*;

class Company implements RandomLoader{ 
    String name;
    Address address;
    Set<Employee> employees;

    Company(){
        randomlyLoadData();
        this.employees = new TreeSet<>();
    }

    Company(String name, Address address) {
        this.name = name;
        this.address = address;
        this.employees = new TreeSet<>();
    }

    public void addEmployee(Employee e){
        this.employees.add(e);
    }

    @Override
    public void randomlyLoadData() {
        Random rand = new Random();
        this.name = "COMPANY_" + Integer.toString((int)(rand.nextFloat()*1000));;
        this.address = new Address();
    }
}