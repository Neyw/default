package ua.kharkov.khpi.vinokurov.diploma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
    @GetMapping(value = "/home")
    public String home(@RequestParam(value = "error", required = false) String error, Model model) {
        model.addAttribute("error", true);
        return "greetings";
    }
}
