package com.example.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @PostMapping("/contact")
    public String sendMessage(@RequestParam String email,
                             @RequestParam String message) {
        // Logic for saving message would go here
        return "redirect:/profile?sent=true";
    }
}