package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "advertisements")
@NamedQueries({
        @NamedQuery(name = "Advertisements.findById", query = "SELECT a FROM Advertisements a " +
                "LEFT JOIN FETCH a.educations WHERE a.advertisementsId = :advertisementsId"),

        @NamedQuery(name = "Advertisements.findByUsername", query = "SELECT a FROM User u " +
                "LEFT JOIN u.userDetail ud LEFT JOIN ud.advertisements a WHERE u.username = :username"),

        @NamedQuery(name = "Advertisements.findAdvertisement", query = "SELECT a FROM Advertisements a ")
})
public class Advertisements implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer advertisementsId;
    private String title;
    @Lob
    private String workDefinition;
    @Lob
    private String criteria;
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    private Date removeDate = new Date();
    private Boolean enabled = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "advertisements_education", joinColumns = @JoinColumn(name = "advertisementId"),
                                                inverseJoinColumns = @JoinColumn(name = "educationId"))
    private List<Education> educations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userDetailId")
    private UserDetail userDetail;

    public Advertisements() {
    }

    public Advertisements(String title, String workDefinition, String criteria) {
        this.title = title;
        this.workDefinition = workDefinition;
        this.criteria = criteria;
    }

    public Integer getAdvertisementsId() {
        return advertisementsId;
    }

    public void setAdvertisementsId(Integer advertisementsId) {
        this.advertisementsId = advertisementsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWorkDefinition() {
        return workDefinition;
    }

    public void setWorkDefinition(String workDefinition) {
        this.workDefinition = workDefinition;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public String toString() {
        return "Advertisements{" +
                "advertisementsId=" + advertisementsId +
                ", title='" + title + '\'' +
                ", workDefinition='" + workDefinition + '\'' +
                ", criteria='" + criteria + '\'' +
                ", addDate=" + addDate +
                ", updatedDate=" + updatedDate +
                ", removeDate=" + removeDate +
                ", enabled=" + enabled +
                '}';
    }
}