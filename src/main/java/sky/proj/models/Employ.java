package sky.proj.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employ")
public class Employ {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    @Column(name = "city_id")
    private int city;



    public Employ(String firstName, String lastName, int age, int city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public Employ() {

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCity() {
        return city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(int city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +
                " " + age + "Город" + city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employ employ = (Employ) o;
        return age == employ.age && firstName.equals(employ.firstName) && lastName.equals(employ.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, city);
    }
}
