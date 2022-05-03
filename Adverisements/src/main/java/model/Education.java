package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "education")
@NamedQueries({
        @NamedQuery(name = "Education.findEducations", query = "SELECT e FROM Education e "),

        @NamedQuery(name = "Education.findById", query = "SELECT e FROM Education e " +
                "WHERE e.educationId = :educationId"),

        @NamedQuery(name = "Education.findWithAdvertisementById", query = "SELECT e FROM Education e " +
                "LEFT JOIN FETCH e.advertisements WHERE e.educationId = :educationId")
})
public class Education implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer educationId;
    private String name;
    private Integer licenceYear;

    @ManyToMany(mappedBy = "educations", fetch = FetchType.LAZY)
    private List<Advertisements> advertisements = new ArrayList<>();

    public Education() {
    }

    public Education(String name, Integer licenceYear) {
        this.name = name;
        this.licenceYear = licenceYear;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLicenceYear() {
        return licenceYear;
    }

    public void setLicenceYear(Integer licenceYear) {
        this.licenceYear = licenceYear;
    }

    public List<Advertisements> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisements> advertisements) {
        this.advertisements = advertisements;
    }

    @Override
    public String toString() {
        return "Education{" +
                "educationId=" + educationId +
                ", name='" + name + '\'' +
                ", licenceYear=" + licenceYear +
                '}';
    }
}