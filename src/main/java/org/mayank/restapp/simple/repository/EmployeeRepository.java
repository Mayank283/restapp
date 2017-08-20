package org.mayank.restapp.simple.repository;

import org.mayank.restapp.simple.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

	@Query(value = "SELECT * FROM EMPLOYEE WHERE EMP_ID = :emp_id",nativeQuery = true)
	EmployeeEntity findById(@Param("emp_id") Long emp_id);
}
