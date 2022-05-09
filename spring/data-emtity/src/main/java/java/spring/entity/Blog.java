package java.spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


//@Data
@Getter
@Setter
@Entity
@Table(name = "t_blog")

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;  //博客id
    //作者id
    private String uid;
    //博客或小说名字
    private String name;
    //作者
    private String auther;
    //标题
    private String title;
    //主体
    private String body;
    //点赞
    private String love;
    //被浏览
    private String watched;
    //转发
    private String forwarded ;
    //创建时间
    private String createdDate;
    //更新时间
    private String updateDate;


}
