package lt.codeacademy.blog.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "COMMENTS")
public class Comment extends BaseEntity {

    @NotBlank
    @Size(max = 255)
    private String message;

    private String username = "Test";

    private Date date = new Date();

    @JoinColumn
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

}
