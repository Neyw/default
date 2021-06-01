package ua.kharkov.khpi.vinokurov.diploma.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kharkov.khpi.vinokurov.diploma.constant.PageNames;
import ua.kharkov.khpi.vinokurov.diploma.controller.beans.Pages;


@RequestMapping("/content")
@Controller
public class AdminController {
    @Autowired
    private Pages pages;

    @GetMapping("")
    public String getPage(Model model) {
        model.addAttribute("pages", pages);
        return PageNames.CONTENT_PAGE;
    }
}
