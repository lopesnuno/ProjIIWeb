package com.example.projetoiiweb.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        Boolean isLoggedIn = session.getAttribute("isLoggedIn") != null && (boolean) session.getAttribute("isLoggedIn");
        if (isLoggedIn) {
            model.addAttribute("isLoggedIn", isLoggedIn);
            session.setAttribute("isLoggedIn", isLoggedIn);
            return "index";
        }

        return "login";
    }
}