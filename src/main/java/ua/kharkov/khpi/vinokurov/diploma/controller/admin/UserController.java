package ua.kharkov.khpi.vinokurov.diploma.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserDto;
import ua.kharkov.khpi.vinokurov.diploma.service.UserService;


@RequestMapping("/users")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/admin/create")
    @ResponseBody
    public UserDto createUser(@ModelAttribute UserDto user, Model model) {
        return userService.add(user);
    }

    @GetMapping(value = "/admin/get")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "greetings";
    }

    @GetMapping(value = "/get/{id}")
    public String getUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "greetings";
    }
}
