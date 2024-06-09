package su.soviet.crudApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import su.soviet.crudApp.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
