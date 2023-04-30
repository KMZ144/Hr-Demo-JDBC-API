package com.global.hr.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.hr.entities.Employee;
import com.global.hr.repo.EmployeeRepo;
import com.global.hr.service.EmployeService;

import jakarta.websocket.server.PathParam;

@Controller
@ResponseBody
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeService empService;

	@RequestMapping(path = "/count", method = RequestMethod.GET)
	public long countEmp() {
		return empService.countEmp();
	}

	@GetMapping("/{id}")
	public Optional<Employee> getEmpById(@PathVariable Long id) {
		return empService.getEmpById(id);
	}

	@GetMapping("")
	public Iterable<Employee> getAll() {
		return empService.getAll();
	}

	@GetMapping("/filter/{name}")
	List<Employee> findByName(@PathVariable String name) {
		return empService.findByNameContaining(name);
	}

	@GetMapping("/filter")
	List<Employee> findByAndSalary(@RequestParam String name, @RequestParam int salary) {
		return empService.customQuery(name, salary);
	}

	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody Employee emp) {
		return ResponseEntity.status(301).body(empService.insert(emp));
	}

	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody Employee emp) {
		return ResponseEntity.status(304).body(empService.update(emp));
	}
	@PutMapping("/custom")
	public ResponseEntity<?> customUpdate(@RequestParam int id,@RequestParam int salary) {
		return ResponseEntity.status(308).body(empService.customUpdate(id,salary));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		empService.delete(id);
	}

	public void testJackson() throws JsonMappingException, JsonProcessingException {

		String jsonString = "{\r\n" + "\r\n" + "\"id\":4,\r\n" + "    \"name\":\"test updated\",\r\n"
				+ "    \"salary\":200\r\n" + "}";

		ObjectMapper mapper = new ObjectMapper();
		Employee emp = mapper.readValue(jsonString, Employee.class);
		jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
	}

}
