package org.accolite.java.EmployeeManagement.Controller;
import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.accolite.java.EmployeeManagement.DTO.EmployeeDTO;
import org.accolite.java.EmployeeManagement.Service.EmployeeService;

@Path("employee")
public class EmployeeController {

	static EmployeeService service = new EmployeeService(); 
	
	// index
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<EmployeeDTO> get() {
		return service.get();
    }
	
	
	// show
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeDTO get(@PathParam("id") int id) {
		return service.get(id);
	}
	
	// create
	@POST
//	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({"application/xml", "application/json"})
	public boolean insert(EmployeeDTO e) {
		return service.insert(e);
	}
	
	// update
	@POST
	@Path("update/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({"application/xml", "application/json"})
	public boolean update(@PathParam("id") int id, EmployeeDTO e) {
		return service.update(e);
	}
	
	// delete
	@GET
	@Path("delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(@PathParam("id") int id) {
		service.delete(id);
		return "deleted";
	}
	
	
	
	
	
	
}
