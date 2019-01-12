import java.util.*;

class Manager extends Employee{
    private Set<Employee> managingTeam;

    // create new manager from details
    Manager(String name, int id, int age){
        super(name, id, age);
        managingTeam = new TreeSet<Employee>();    
    }

    // promoting existing employee to manager (overloading previous constructor)
    Manager(Employee e){
        super(e.name, e.id, e.age);
        managingTeam = new TreeSet<Employee>();
    }

    // managing team is private. manipulation is done using public functions
    public void addEmployeeToManagingTeam(Employee e){
        managingTeam.add(e);
    }

    public void removeEmployeeFromManagingTeam(Employee e){
        managingTeam.remove(e);
    }

    // allows any manager to fire any employee from the company
    static void fireEmployee(Company c, Employee e){
        c.employees.remove(e);
    }
}