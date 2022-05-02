package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;


    @Column(name = "responsibilities")
    private String responsibilities;

    @Column(name = "salary")
    private Integer salary;

    @Temporal(TemporalType.DATE)
    @Column(name = "startDate")
    private Date startDate;

    @OneToOne
    @JoinColumn(name = "infoId")
    private EmployeeInfo employeeInfo;

    public Employee() {
    }

    public Employee(String name, String surname, String responsibilities, Integer salary, Date startDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.responsibilities = responsibilities;
        this.salary = salary;
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", responsibilities='" + responsibilities + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                '}';
    }
}
