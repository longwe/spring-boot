package com.miya.longwe.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miya.longwe.springboot.model.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeRepository.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Find by name.
     *
     * @param name the name
     * @return the employee
     */
    Employee findByName(String name);

}
