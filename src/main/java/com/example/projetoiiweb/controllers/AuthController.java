package com.example.projetoiiweb.controllers;

import com.example.projetoiiweb.models.Cliente;
import com.example.projetoiiweb.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AuthController {
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
        Optional<Cliente> user = userRepository.findUserByUsername(username);
        if (user.isPresent()){
            Cliente currentUser = user.get();
            System.out.println(currentUser);
            if (currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)){
                model.addAttribute("isLoggedIn", true);
                return "redirect:/atividades";
            }
            return "redirect:/error";
        }
        return "redirect:/error";
    }

    @GetMapping("/logout")
    public String logout(Model model){
        model.addAttribute("isLoggedIn", false);
        return "redirect:/login";
    }
}
