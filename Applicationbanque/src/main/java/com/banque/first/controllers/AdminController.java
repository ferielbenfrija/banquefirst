package com.banque.first.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import com.banque.first.entities.Compte;

import static com.banque.first.ApplicationbanqueApplication.comptees;

@Controller
@RequestMapping("comptee")
public class AdminController {
	@RequestMapping("comptes")
	public String comptes(Model model)
	{model.addAttribute("comptees",comptees);
	return "comptes";
	}
	
	

@PostMapping("add")
public String ajouter(@RequestParam("titulaire") String titulaire,@RequestParam("solde") double solde
)
{Compte c=new Compte(titulaire,solde);
int id =comptees.size();
id++;

	
	c.setId(id);
	comptees.add(c);
return"redirect:/comptee/comptes";}



@GetMapping("add")
public String add()
{
return"ajouter";
}


@RequestMapping("details")
public String details(Model model) {
    model.addAttribute("comptees", comptees); 
    return "details"; 
}

@GetMapping("/depot/{id}")
public String depotForm(@PathVariable int id, Model model) {
    model.addAttribute("id", id); 
    return "depot"; 
}
@PostMapping("/depot/{id}")
public String depot(@PathVariable int id, @RequestParam double montant)
{
    for (Compte c : comptees) {
        if (c.getId() == id) {
        c.deposer(montant);           
        break; 
        }
    }
    return "redirect:/comptee/details"; 
    
    
}

@GetMapping("/retrait/{id}")
public String retraitForm(@PathVariable int id,  Model model) {
	model.addAttribute("id", id); 
    return "retrait"; 
}
@PostMapping("/retrait/{id}")
public String retrait(@PathVariable int id, @RequestParam double montant)
{
    for (Compte c : comptees) {
        if (c.getId() == id) {
        	c.retirer(montant);           
            break; 
            }
        }
        return "redirect:/comptee/details"; 
        
        }

  
}
