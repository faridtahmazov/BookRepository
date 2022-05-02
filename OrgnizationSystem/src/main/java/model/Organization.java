package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "organization")
public class Organization implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer organizationId;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "organizations")
    private List<Volunteer> volunteers;

    public Organization() {
    }

    public Organization(String name) {
        this.name = name;
    }

    public void addVolunteer(Volunteer volunteer){
        this.volunteers.add(volunteer);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organizationId=" + organizationId +
                ", name='" + name + '\'' +
                ", volunteers=" + volunteers +
                '}';
    }
}