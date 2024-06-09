package su.soviet.crudApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import su.soviet.crudApp.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByName(String name);

    Optional<User> getUserByEmail(String email);
}
