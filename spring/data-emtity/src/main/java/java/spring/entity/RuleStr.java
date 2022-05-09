package java.spring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "t_ruleStr")
public class RuleStr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;
    private String str;

    public RuleStr(Integer rid, String str) {
        this.rid = rid;
        this.str = str;
    }


    public RuleStr() {

    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public RuleStr(String k) {
        this.str = String.valueOf(k);
    }
}
