import java.util.*;
import java.util.stream.Collectors;

class Office {
    public static void main(String args[]){

        Company company = new Company();

        //create 100 employees
        while(company.employees.size()<10){
            company.addEmployee(new Employee());
        }

        System.out.println("\nEmployees sorted according to age (default - comparable)");
        for(Employee e : company.employees)
            System.out.println(e);
        
        
        // fireEmployee is static for Manager class
        System.out.println("\nFiring all employees with age < 30");
        List<Employee>  underAgedEmployees = company.employees.stream().filter(e -> e.age < 30).collect(Collectors.toList());
        for(Employee e : underAgedEmployees) {
            System.out.println(e.name + " has been fired!");
            Manager.fireEmployee(company, e);
        }  
            

        System.out.println("\nEmployees sorted according to id (using comparator)");
        TreeSet<Employee> idSortedSet = new TreeSet<>(new Comparator<Employee>(){
            @Override
            public int compare(Employee a, Employee b){
                return a.id - b.id;
            }
        });
        idSortedSet.addAll(company.employees);
        for(Employee e : idSortedSet){
            System.out.println(e);
        }

        System.out.println("\nEmployees sorted according to name (using comparator)");
        TreeSet<Employee> nameSortedSet = new TreeSet<>(new Comparator<Employee>(){
            @Override
            public int compare(Employee a, Employee b){
                return a.name.compareTo(b.name);
            }
        });
        nameSortedSet.addAll(company.employees);
        for(Employee e : nameSortedSet)
            System.out.println(e);
    }
}   