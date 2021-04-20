package lt.codeacademy.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "BLOGS")
public class Blog extends BaseEntity {

    private String title;

    private String content;

    private Date date;

//    private String author;

//    private UUID userID;
}
