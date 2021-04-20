package lt.codeacademy.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "COMMENTS")
public class Comment extends BaseEntity {

    private String message;

    private String username;

    private Date date;

//    private UUID blogID;

}
