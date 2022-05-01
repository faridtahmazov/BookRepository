package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Personel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ElementCollection
    @CollectionTable(name = "personel_phone_numbers", joinColumns = @JoinColumn(name = "personelId"))
    @MapKeyColumn(name = "phoneType")
    @Column(name = "phoneNumber")
    private Map<String, String> phoneNumbers = new HashMap<>();

    public Personel() {
    }

    public Personel(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public void addPhoneNumber(String key, String value){
        this.phoneNumbers.put(key, value);
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

    public Map<String, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<String, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Personel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
