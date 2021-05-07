package lt.codeacademy.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "POSTS")
public class Post extends BaseEntity {

    @NotBlank
    private String title;

    @Column(columnDefinition = "VARCHAR(1500)")
    @NotBlank
    private String content;

    private Date date = new Date();

    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;

}
