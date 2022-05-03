package model;

import model.util.PhoneType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "user_detail")
@NamedQueries({
        @NamedQuery(name = "UserDetail.findById", query = "SELECT u FROM User u " +
                "LEFT JOIN FETCH u.userDetail WHERE u.userId = :userId"),

        @NamedQuery(name = "UserDetail.findByUsername", query = "SELECT ud FROM UserDetail ud " +
                "WHERE ud.user.username = :username"),

        @NamedQuery(name = "UserDetail.findWithAddressByUsername", query = "SELECT ud FROM UserDetail ud " +
                "LEFT JOIN FETCH ud.addresses WHERE ud.user.username = :username"),

        @NamedQuery(name = "UserDetail.findWithAdvertisementByUsername", query = "SELECT ud FROM UserDetail ud " +
                "LEFT JOIN FETCH ud.advertisements WHERE ud.user.username = :username")
})
public class UserDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userDetailId;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @ElementCollection
    @JoinTable(name = "useerDetail_phoneNumber", joinColumns = @JoinColumn(name = "userDetailId"))
    @MapKeyColumn(name = "phoneType")
    @Column(name = "phoneNumber")
    private Map<PhoneType, String> phoneNumbers = new HashMap<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(name = "userDetail_address", joinColumns = @JoinColumn(name = "userDetailId"))
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Advertisements> advertisements = new ArrayList<>();

    @OneToOne(mappedBy = "userDetail", fetch = FetchType.LAZY)
    private User user;

    public UserDetail() {
    }

    public UserDetail(String firstName, String lastName, Date birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    public Integer getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(Integer userDetailId) {
        this.userDetailId = userDetailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Map<PhoneType, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Advertisements> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisements> advertisements) {
        this.advertisements = advertisements;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "userDetailId=" + userDetailId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}