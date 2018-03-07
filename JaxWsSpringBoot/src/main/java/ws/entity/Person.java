package ws.entity;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by EGBoldyr on 07.03.18.
 */

@XmlRootElement(name = "Person")
@XmlType(propOrder = {"id", "name", "surname", "age"})
public class Person implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private Integer age;

    public Person() {}

    public Person(Long id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
