package ua.kharkov.khpi.vinokurov.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserDto;
import ua.kharkov.khpi.vinokurov.diploma.service.UserService;


@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public String home(@ModelAttribute UserDto userDto, Model model) {
        userService.add(userDto);
        return "/login";
    }
}
