package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class EmployeeInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @OneToOne(mappedBy = "employeeInfo")
    private Employee employee;

    public EmployeeInfo() {
    }

    public EmployeeInfo(Integer age, String country, String city) {
        this.age = age;
        this.country = country;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "id=" + id +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
