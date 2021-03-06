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
    @Size(max = 255, message = "{validation.size.message}")
    private String message;

    @Column(updatable = false)
    private Date date = new Date();

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

}
