import java.util.*;

class Employee implements Comparable<Employee>, RandomLoader {
    String name;
    int id;
    int age;

    Employee(){
        randomlyLoadData();
    }

    Employee(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public void randomlyLoadData() {
        Random rand = new Random();
        this.id = (int)(rand.nextFloat()*1000);
        this.age = (int)(rand.nextFloat()*100);
        this.name = "ENAME_" + Integer.toString((int)(rand.nextFloat()*1000));
    }

    @Override
    public String toString(){
        return "Employee "+name+" - ID<"+id+"> is "+age+" years old";
    }

    @Override
    public boolean equals(Object o){
        Employee e = ((Employee)o);
        return (e.id == this.id); 
    }

    @Override
    public int compareTo(Employee e){
        return e.age-this.age;
    }
}