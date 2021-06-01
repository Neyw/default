package ua.kharkov.khpi.vinokurov.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.FullUserFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.service.FullUserFlightService;

import java.util.List;
import java.util.Optional;


@RequestMapping("/full_user_flight")
@Controller
public class FullUserFlightController {
    @Autowired
    private FullUserFlightService fullUserFlightService;

    @PostMapping(value = "/create/userId/{id}")
    @ResponseBody
    public Optional<FullUserFlightDto> createFullUserFlight(@ModelAttribute List<UserFlightDto> userFlightDtoList, @PathVariable("id") long id, Model model) {
        return fullUserFlightService.add(userFlightDtoList, id);
    }

    @GetMapping(value = "/get/userId/{id}")
    @ResponseBody
    public List<FullUserFlightDto> getAllFlightsByUserId(@PathVariable("id") long id) {
        return fullUserFlightService.getAllByUserId(id);
    }
}
