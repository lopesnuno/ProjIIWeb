package com.example.projetoiiweb.controllers;

import com.example.projetoiiweb.models.Produto;
import com.example.projetoiiweb.services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService, HttpSession session) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String listAtividades(Model model, HttpSession session) {
        boolean isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
        model.addAttribute("isLoggedIn", isLoggedIn);
        if (isLoggedIn) {
            try {
                List<Produto> products = productService.findAllProdutos();
                model.addAttribute("products", products);
                return "products";
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                return "error";
            }
        } else {
            return "redirect:/login";
        }
    }
}
