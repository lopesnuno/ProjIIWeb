package com.example.projetoiiweb.services;

import com.example.projetoiiweb.models.Cliente;
import com.example.projetoiiweb.repository.UserRepository;
import com.example.projetoiiweb.services.interfaces.UserServiceI;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserServiceI {
    private final UserRepository userRepository;

    @Autowired
    public UsersService(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public void saveUser(Cliente user, HttpSession session) {
        Cliente existingUser = (Cliente) session.getAttribute("user");

        if (existingUser != null) {
            existingUser.setTel(user.getTel());
            existingUser.setNome(user.getNome());
            existingUser.setNif(user.getNif());
            existingUser.setPassword(user.getPassword());

            userRepository.save(existingUser);
        }
    }
}
