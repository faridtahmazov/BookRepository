package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private Integer salary;

    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    public Employee() {
    }

    public Employee(String name, String surname, Integer salary, Date hireDate) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer id) {
        this.employeeId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                ", department=" + department +
                '}';
    }
}
