package ua.kharkov.khpi.vinokurov.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SingleFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.service.UserFlightService;

import java.util.List;


@RequestMapping("/user_flight")
@Controller
public class UserFlightController {
    @Autowired
    private UserFlightService userFlightService;

    @PostMapping(value = "/create/seat/{number}")
    @ResponseBody
    public UserFlightDto createUserFlight(@ModelAttribute SingleFlightDto singleFlightDto, @PathVariable("number") int seat) {
        return userFlightService.add(singleFlightDto, seat);
    }

    @GetMapping(value = "/get/userId/{id}")
    @ResponseBody
    public List<UserFlightDto> getAllFlightsByUserId(@PathVariable("id") long id) {
        return userFlightService.getAllByUserId(id);
    }
}
