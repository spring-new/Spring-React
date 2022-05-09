package java.spring.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class SysAdm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sys_adm_id;
    private String sys_adm_name;

    private Date birthday;
    private String passwd;

    public Integer getSys_adm_id() {
        return sys_adm_id;
    }

    public void setSys_adm_id(Integer sys_adm_id) {
        this.sys_adm_id = sys_adm_id;
    }

    public String getSys_adm_name() {
        return sys_adm_name;
    }

    public void setSys_adm_name(String sys_adm_name) {
        this.sys_adm_name = sys_adm_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
