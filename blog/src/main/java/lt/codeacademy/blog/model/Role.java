package lt.codeacademy.blog.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "ROLES")
public class Role extends BaseEntity implements GrantedAuthority {

    private String role;

    @Override
    public String getAuthority() {
        return "ROLE_" + role;
    }
}
