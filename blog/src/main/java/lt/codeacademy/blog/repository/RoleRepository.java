package lt.codeacademy.blog.repository;

import lt.codeacademy.blog.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
