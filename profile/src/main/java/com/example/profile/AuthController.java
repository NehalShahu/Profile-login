package com.example.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserRepository repo;

    public AuthController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String register() {
        return "register";
    }
   
   
    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password) {
        repo.register(username, password);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password) {
        if (repo.login(username, password)) {
            return "redirect:/profile";
        }
        return "redirect:/login?error";
    }
}
