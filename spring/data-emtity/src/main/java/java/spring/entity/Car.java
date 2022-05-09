package java.spring.entity;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "t_car")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;  //
    private int discount = 100;
    private String person;
    private String name;
    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Object getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = String.valueOf(person);
    }

    @Override
    public String toString() {
        return "Car{" +
                "discount=" + discount +
                ", person=" + person +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}



