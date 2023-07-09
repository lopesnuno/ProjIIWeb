package com.example.projetoiiweb.controllers;

import com.example.projetoiiweb.models.Cliente;
import com.example.projetoiiweb.services.UsersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpSession session) {
        Cliente currentUser = (Cliente) session.getAttribute("user");
        if (currentUser != null) {
            model.addAttribute("isLoggedIn", session.getAttribute("isLoggedIn"));
            model.addAttribute("user", currentUser);
            return "profile";
        }

        return "redirect:/login";
    }

    @PostMapping("/save")
    public String saveChanges(@RequestParam("tel") Integer phoneNumber,
                              @RequestParam("name") String name,
                              @RequestParam("nif") Integer nif,
                              @RequestParam("password") String password,
                              HttpSession session) {
        Cliente currentUser = (Cliente) session.getAttribute("user");
        if (currentUser != null) {
            currentUser.setTel(phoneNumber);
            currentUser.setNome(name);
            currentUser.setNif(nif);
            currentUser.setPassword(password);

            usersService.saveUser(currentUser, session);

            return "redirect:/";
        }

        return "redirect:/login";
    }
}
