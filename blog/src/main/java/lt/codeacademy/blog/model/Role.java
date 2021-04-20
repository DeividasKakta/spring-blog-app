package lt.codeacademy.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "ROLES")
public class Role extends BaseEntity {

    private String role;
}
