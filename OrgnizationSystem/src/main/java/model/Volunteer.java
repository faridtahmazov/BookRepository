package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "volunteer")
public class Volunteer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer volunteerId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "position")
    private String position;

    @ManyToMany
    @JoinTable(name = "organization_volunteer", joinColumns = @JoinColumn(name = "volunteerId"),
                                                inverseJoinColumns = @JoinColumn(name = "organizationId"))
    private List<Organization> organizations;

    public Volunteer() {
    }

    public Volunteer(String name, String surname, String position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

    public void addOrganization(Organization organization){
        this.organizations.add(organization);
    }

    public Integer getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Integer volunteerId) {
        this.volunteerId = volunteerId;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "volunteerId=" + volunteerId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", profession='" + position + '\'' +
                ", organization=" + organizations +
                '}';
    }
}