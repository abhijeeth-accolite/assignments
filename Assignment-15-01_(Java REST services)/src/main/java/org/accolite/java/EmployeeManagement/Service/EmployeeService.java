package org.accolite.java.EmployeeManagement.Service;
import java.util.*;
import org.accolite.java.EmployeeManagement.DTO.EmployeeDTO;


public class EmployeeService {
	
	static HashMap<Integer, EmployeeDTO> employees = new HashMap<>();
	
	public EmployeeService() {
		employees.put(1, new EmployeeDTO("foo", 25, 1));
		employees.put(2, new EmployeeDTO("bar", 47, 2));
		employees.put(3, new EmployeeDTO("alex", 32, 3));
	}
	
//	show all
	public Set<EmployeeDTO> get(){
		Set<EmployeeDTO> employeeSet = new HashSet<EmployeeDTO>();
		employeeSet.addAll(employees.values());
		return employeeSet;
	}
	
//	show 1
	public EmployeeDTO get(int eid){
		return employees.get(eid);
	}
	
//	create
	public boolean insert(EmployeeDTO e) {
		employees.put(e.getId(), e);
		return true;
	}
	
//	delete
	public boolean delete(int eid) {
		employees.remove(eid);
		return true;
	}
	
//	update
	public boolean update(EmployeeDTO e) {
		EmployeeDTO empToUpdate = employees.get(e.getId());
		empToUpdate.setAge(e.getAge());
		empToUpdate.setName(e.getName());
		return true;
	}
}

