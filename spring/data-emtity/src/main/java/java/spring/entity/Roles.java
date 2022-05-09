package java.spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


//@Data
@Getter
@Setter
@Entity
@Table(name ="t_roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    private Integer roleid;
    @Column(name = "rolename")
    private String rolename;
    @OneToMany(mappedBy = "roles")  //一对多   roles 属性是和User表做映射
    private Set<User> users = new HashSet<>();

}
