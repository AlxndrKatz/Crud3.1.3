package su.soviet.crudApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import su.soviet.crudApp.dao.UserRepository;
import su.soviet.crudApp.model.User;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private RoleService roleService;

    public User createUser(User user) {
        Optional<User> userByName = repo.getUserByName(user.getName());
        Optional<User> userByEmail = repo.getUserByEmail(user.getEmail());
        if (userByName.isEmpty() && userByEmail.isEmpty()) {
            user.setRoles(roleService.setDefaultRole());
            return repo.save(user);
        }
        return null;
    }

    public User getUserById(Long id) {
        if (repo.existsById(id)) {
            return repo.findById(id).orElse(null);
        }
        return null;
    }

    public User updateUser(User user) {
        return repo.save(user);
    }

    public void deleteUser(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }

    public List<User> getUsers() {
        return repo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return repo.getUserByName(name).orElseThrow(() -> new UsernameNotFoundException("User not found " + name));
    }
}
