package employeepackage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotBlank(message = "Name is Empty")
	private String name;
	@NotBlank(message = "Job Title is Empty")
	private String jobTitle;
	private Date dateOfBirth;
	private String department;
	@NotBlank(message = "Email is Empty")
	@Email
	private String email;
	@Min(18)
	private Integer age;
	private Integer id;
	@DecimalMin(value = "0")
	private BigDecimal salary;

	public Employee(String name, Integer age, BigDecimal salary, String jobTitle, Date dateOfBirth, String department,
			String email, Integer id) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.jobTitle = jobTitle;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
		this.email = email;
		this.id = id;
	}

	public Employee(String name, Integer age, BigDecimal salary, String jobTitle, Date dateOfBirth, String department,
			String email) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.jobTitle = jobTitle;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
		this.email = email;
	}

	public Employee() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
