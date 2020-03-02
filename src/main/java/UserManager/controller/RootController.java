package UserManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import UserManager.service.UserService;

@Controller
public class RootController{

    @Autowired
    protected UserService service;

    @GetMapping("/")
    public String root() {
        return "users";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", service.getAll());
        return "users";
    }
}
