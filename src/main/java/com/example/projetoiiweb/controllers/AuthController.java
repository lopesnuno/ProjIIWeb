package com.example.projetoiiweb.controllers;

import com.example.projetoiiweb.models.Cliente;
import com.example.projetoiiweb.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Optional;

@Controller
@SessionAttributes({"isLoggedIn", "user"})
public class AuthController {
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        Optional<Cliente> user = userRepository.findUserByUsername(username);
        if (user.isPresent()){
            Cliente currentUser = user.get();
            System.out.println(currentUser);
            if (currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)) {
                session.setAttribute("isLoggedIn", true);
                model.addAttribute("isLoggedIn", true);
                model.addAttribute("user", currentUser);

                return "redirect:/products";
            }
            return "redirect:/error";
        }
        return "redirect:/error";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session){
        model.addAttribute("isLoggedIn", false);
        session.setAttribute("isLoggedIn", false);

        return "redirect:/login";
    }
}
