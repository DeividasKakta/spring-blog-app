package lt.codeacademy.blog.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.blog.model.Role;
import lt.codeacademy.blog.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;

    public Set<Role> addUserRoleToSet(Set<Role> roles) {
        roles.add(repository.getUserRole());
        return roles;
    }
}
