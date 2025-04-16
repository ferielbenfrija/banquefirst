package com.banque.first.controllers;

import com.banque.first.entities.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    private List<Utilisateur> utilisateurs = new ArrayList<>();

    // Initialiser des utilisateurs en mémoire
    public LoginController() {
        utilisateurs.add(new Utilisateur("admin@banque.com", "1234"));
        utilisateurs.add(new Utilisateur("user1@banque.com", "abcd"));
        utilisateurs.add(new Utilisateur("client@banque.com", "pass"));
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username,
                              @RequestParam String password,
                              Model model) {

        for (Utilisateur u : utilisateurs) {
            if (u.getEmail().equals(username) && u.getMotDePasse().equals(password)) {
                return "redirect:/comptee/details";
            }
        }

        model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect");
        return "login";
    }
}
