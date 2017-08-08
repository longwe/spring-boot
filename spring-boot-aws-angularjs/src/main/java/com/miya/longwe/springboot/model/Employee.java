/**
 * 
 */
package com.miya.longwe.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;

/**
 * @author mlongwe
 *
 */
@Entity(name="app_employee")
@ApiModel(value="MediagramDTO")
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private Long id;

	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;

	@Column(name="AGE", nullable=false)
	private Integer age;

	@Column(name="SALARY", nullable=false)
	private double salary;
	
	
	
	
	

	public Employee() {

	}

	public Employee(int i, String name, Integer age, double salary) {
		super();
		this.id = (long) i;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	

}
