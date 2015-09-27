package fr.epita.sigl.miwa.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

    @RequestMapping(value = {"/", "/home"})
    public String home() {
        return "/home/home";
    }
}
