package com.global.hr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.global.hr.entities.Employee;
import com.global.hr.repo.EmployeeRepo;

@Service
public class EmployeService {

	@Autowired
	private EmployeeRepo empRepo;

	public List<Employee> findByName(String name) {
		return empRepo.findByName(name);
	};

	public List<Employee> findByNameStartingWith(String name) {
		return empRepo.findByNameStartingWith(name);
	};
	
	public int customUpdate(int id,int salary) {
		return empRepo.customUpdate(id, salary);
	}

	public List<Employee> findByNameContaining(String name) {
		return empRepo.findByNameContaining(name);
	};

	public List<Employee> findByNameContainingAndSalaryGreaterThanEqual(String name, int salary) {
		return findByNameContainingAndSalaryGreaterThanEqual(name, salary);
	};

	public List<Employee> customQuery(String name, int salary) {
		return empRepo.customQuery(name, salary);
	};

	public long countEmp() {
		return empRepo.count();
	};

	public Optional<Employee> getEmpById(Long id) {
		return empRepo.findById(id);
	}

	public Iterable<Employee> getAll() {
		return empRepo.findAll();
	}

	public List<Employee> findByName2(String name) {
		return empRepo.findByNameContaining(name);
	}

	public List<Employee> findByAndSalary(@RequestParam String name, @RequestParam int salary) {
		return empRepo.customQuery(name, salary);
	}

	public Employee insert(Employee emp) {
		return empRepo.save(emp);
	}

	public Employee update(Employee emp) {
		return empRepo.save(emp);
	}

	public void delete(long id) {
		empRepo.deleteById(id);
	}

}
