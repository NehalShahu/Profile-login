package com.example.profile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("name", "NEHAL SHAHU");
        model.addAttribute("course", "ARTIFICIAL INTELLIGENCE & DATA SCIENCE");
        model.addAttribute("skills", "JAVA, SPRING BOOT, PYTHON, ML, SQL");
        model.addAttribute("projects", "AI CHATBOT, STUDENT PORTAL, PORTFOLIO");
        return "profile";
    }
}