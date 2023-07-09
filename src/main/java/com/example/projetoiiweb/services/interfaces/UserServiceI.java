package com.example.projetoiiweb.services.interfaces;

import com.example.projetoiiweb.models.Cliente;
import jakarta.servlet.http.HttpSession;

public interface UserServiceI {
    void saveUser(Cliente user, HttpSession session);
}
