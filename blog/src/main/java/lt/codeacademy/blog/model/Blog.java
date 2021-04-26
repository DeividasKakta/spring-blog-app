package lt.codeacademy.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "BLOGS")
public class Blog extends BaseEntity {

    @NotBlank
    private String title;

    @Column(columnDefinition = "VARCHAR(1500)")
    @NotBlank
    private String content;

    private Date date = new Date();

//    private String author;

//    private UUID userID;
}
