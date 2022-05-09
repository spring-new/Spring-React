package java.spring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data

@Getter
@Setter
@Entity
@Table(name = "t_drlResult")
public class DrlResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer did;
    private String staute;
    private String message;
    private String value;
    private String key;
    private String user;
    private String car;
    private String roles;
    private String person;
    private String blog;

    public DrlResult(String staute, String message, String value, String key, User user, Car car, Roles roles, Person person, Blog blog) {
        this.staute = staute;
        this.message = message;
        this.value = value;
        this.key = key;
        this.user = String.valueOf(user);
        this.car = String.valueOf(car);
        this.roles = String.valueOf(roles);
        this.person = String.valueOf(person);
        this.blog = String.valueOf(blog);
    }

    public DrlResult() {
        this.staute = staute;
        this.message = message;
        this.value = value;
        this.key = key;
        this.user = user;
        this.car = car;
        this.roles = roles;
        this.person = person;
        this.blog = blog;
    }


    @Override
    public String toString() {
        return "Result{" +
                "staute='" + staute + '\'' +
                ", message='" + message + '\'' +
                ", value='" + value + '\'' +
                ", key='" + key + '\'' +
                ", user=" + user +
                ", car=" + car +
                ", roles=" + roles +
                ", person=" + person +
                ", blog=" + blog +
                '}';
    }

    public String getStaute() {
        return staute;
    }

    public void setStaute(String staute) {
        this.staute = staute;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = String.valueOf(user);
    }

    public Object getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = String.valueOf(car);
    }

    public Object getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = String.valueOf(roles);
    }

    public Object getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = String.valueOf(person);
    }

    public Object getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = String.valueOf(blog);
    }
}
