package com.example.projetoiiweb.controllers;

import com.example.projetoiiweb.models.Produto;
import com.example.projetoiiweb.services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService, HttpSession session) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String listProducts(Model model, HttpSession session) {
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

    @GetMapping("/products/{id}")
    public String viewProduct(Model model, @PathVariable("id") String id, HttpSession session) {
        boolean isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
        model.addAttribute("isLoggedIn", isLoggedIn);
        if (isLoggedIn) {
            try {
                Optional<Produto> product = productService.findProdutoById(id);
                model.addAttribute("product", product);
                session.setAttribute("product", product);

                return "product";
            } catch (Exception e) {
                model.addAttribute("error", e.getMessage());
                return "error";
            }
        }
        return "redirect:/login";
    }
}
