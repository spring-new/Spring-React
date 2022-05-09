package java.spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
//@Data
@Entity   //表示该类是一个实体类
@Table(name = "t_user")   //是生成的数据库中的表名
public class User {
    @Id   //该注解表示设置为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //主键的生成策略
    private Integer id;
    @Column(nullable =true, length = 50)
    private String name;
    private String password;
    private Integer age;
    private String address;
    //主要操作用户表，注意维护Roles表
    @ManyToOne(cascade = CascadeType.PERSIST)  //多对一  增删改时保证角色也要同时改变
    @JoinColumn(name = "role_id")   //关联外键（定义一个外键）
    private Roles roles;


    public Object generate() {
        return null;
    }

    public String getGender() {
        return null;
    }

    public void setGender(String 男) {
    }
}

