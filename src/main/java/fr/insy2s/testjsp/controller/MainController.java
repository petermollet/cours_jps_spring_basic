package fr.insy2s.testjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    /**
     * Afficher la page home (index.jsp) à l'adresse /
     *
     *
     * @return index.jsp
     */
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("message", "HELLO WORLD");
        return "index";
    }



}

