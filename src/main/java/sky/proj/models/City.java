package sky.proj.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


public class City {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int city_id;
    private String city_name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Employ> employs;


    public int getCity_id() {
        return city_id;
    }

    public void setCity_id() {
        this.city_id = city_id;
    }

    public City(int city_id) {
        this.city_id = city_id;


    }

    private String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
