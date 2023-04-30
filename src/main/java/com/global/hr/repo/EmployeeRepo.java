package com.global.hr.repo;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.entities.Employee;


@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
	
	List<Employee>findByName(String name);
	List<Employee>findByNameStartingWith(String name);
	List<Employee>findByNameContaining(String name);
	List<Employee>findByNameContainingAndSalaryGreaterThanEqual(String name,int salary);

	@Query("SELECT id,name,salary FROM employee WHERE name LIKE :empName AND salary >= :empSalary")
	List<Employee>customQuery (@Param("empName") String name, @Param("empSalary") int salary);

	@Query("UPDATE employee SET salary=:empSalary WHERE id=:empId ")
	@Modifying
	int customUpdate (@Param("empId") int id, @Param("empSalary") int salary);


}
