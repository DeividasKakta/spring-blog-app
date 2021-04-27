package lt.codeacademy.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "COMMENTS")
public class Comment extends BaseEntity {

    @NotBlank
    private String message;

    private String username = "Test";

    private Date date = new Date();

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Blog blog;

}
