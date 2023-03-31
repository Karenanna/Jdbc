package sky.proj.models;

import java.util.Objects;

public class Employ {

    private String firstName;

    private String lastName;

    private int age;

    private City city;

    public Employ(String firstName, String lastName, int age, City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return firstName  + " " + lastName +
                " " + age + "Город" + city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employ employ = (Employ) o;
        return age == employ.age && firstName.equals(employ.firstName) && lastName.equals(employ.lastName) && city.equals(employ.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, city);
    }
}
