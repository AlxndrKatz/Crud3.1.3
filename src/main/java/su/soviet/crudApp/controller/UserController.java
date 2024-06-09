package su.soviet.crudApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import su.soviet.crudApp.model.User;
import su.soviet.crudApp.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String getUserData(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user/{id}")
    public String getUserData(@PathVariable("id") Long id, Model model) {
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "user";
    }
}
