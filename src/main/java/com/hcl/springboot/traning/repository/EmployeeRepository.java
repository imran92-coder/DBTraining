package com.hcl.springboot.traning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.springboot.traning.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEmployeeNameAndPassword(String employeeName, String password);

	List<Employee> findByEmployeeNameContains(String employeeName);

	List<Employee> findByEmployeeName(String employeeName);

	List<Employee> findByEmployeeNameContainsOrderByEmployeeNameAsc(String employeeName);

	@Query("from Employee u where u.employeeName=:employeeName and u.password=:password")
	public Employee getEmployee(@Param("employeeName") String employeeName, @Param("password") String password);

	@Query(value = "select * from employee u where u.employee_name=:employeeName and u.password=:password", nativeQuery = true)
	public Employee getEmployeeByNativeSql(@Param("employeeName") String employeeName,
			@Param("password") String password);

}
