package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "User.findById", query = "SELECT u FROM User u " +
                "LEFT JOIN FETCH u.userDetail WHERE u.userId = :userId"),

        @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u " +
                "WHERE u.username = :username"),

        @NamedQuery(name = "User.findWithUserDetailByUsername", query = "SELECT u FROM User u " +
                "LEFT JOIN FETCH u.userDetail WHERE u.username = :username"),

        @NamedQuery(name = "User.findUsers", query = "SELECT u FROM User u"),

        @NamedQuery(name = "User.count", query = "SELECT COUNT(u) FROM User u"),

        @NamedQuery(name = "User.findUserInfoByUsername", query = "SELECT new model.UserInfo" +
                "(u.username, u.userDetail.firstName, u.userDetail.lastName, u.userDetail.birthdate) FROM User u " +
                "WHERE u.username = :username")
})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private UserDetail userDetail;

    public User() {
    }

    public User(String username, String password, Date creationDate) {
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}