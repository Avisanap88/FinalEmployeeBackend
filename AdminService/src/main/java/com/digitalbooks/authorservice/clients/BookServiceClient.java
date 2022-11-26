package com.digitalbooks.authorservice.clients;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.digitalbooks.authorservice.model.BookEntity;
import com.digitalbooks.authorservice.model.Employee;
import feign.Headers;


@FeignClient(name="employee-service",url="http://localhost:9090")
public interface BookServiceClient {
	
	@PostMapping("/api/v1/digitalbooks/books/createbook")
	@Headers("Content-Type: application/json")
	BookEntity SaveBook(BookEntity book);
	
	@PutMapping("/api/v1/digitalbooks/books/update")
    @Headers("Content-Type: application/json")
	BookEntity updateBook(BookEntity book);
	
	//get all employees
	@GetMapping("/api/v1/employees")
	@Headers("Content-Type: application/json")
	List<Employee> getAllEmployees();
	
	//create employee
	@PostMapping("/api/v1/employees")
	@Headers({"Content-Type: application/json","Accept: application/json"})
	Employee createEmployee(Employee employee);
	
	// get employee by id rest api
	@GetMapping("/api/v1/employees/{id}")
	@Headers({"Content-Type: application/json","Accept: application/json"})
	Employee getEmployeeById(@PathVariable Long id);
	
	
	//update employee by id rest api
	@PutMapping("/api/v1/employees/{id}")
	@Headers({"Content-Type: application/json","Accept: application/json"})
	Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee);
	
	
	//delete employee by id
	@DeleteMapping("/api/v1/employees/{id}")
	@Headers({"Content-Type: application/json","Accept: application/json"})
	Map<String, Boolean> deleteEmployee(@PathVariable Long id);
	
	
	
	

}



