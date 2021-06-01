package ua.kharkov.khpi.vinokurov.diploma.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kharkov.khpi.vinokurov.diploma.controller.beans.Pages;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.CityDto;
import ua.kharkov.khpi.vinokurov.diploma.service.CityService;
import ua.kharkov.khpi.vinokurov.diploma.service.CountryService;
import ua.kharkov.khpi.vinokurov.diploma.service.StationService;
import ua.kharkov.khpi.vinokurov.diploma.util.Paginator;

import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.CITIES;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.COUNTRIES;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.DEFAULT_PAGE_SIZE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.PAGE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.SIZE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.STATIONS;
import static ua.kharkov.khpi.vinokurov.diploma.constant.PageNames.CITY;


@RequestMapping("/city")
@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StationService stationService;

    @Autowired
    private Paginator paginator;

    @Autowired
    private Pages pages;

    @GetMapping("/page")
    public String getCityPage(@RequestParam(name = "size") int size,
                              @RequestParam(name = "page") int page, Model model) {
        model.addAttribute(CITIES, paginator.getPage(cityService.getAllCities(), page - 1, size));
        model.addAttribute(CITY, new CityDto());
        model.addAttribute(PAGE_ATTRIBUTE, page);
        model.addAttribute(SIZE_ATTRIBUTE, size);
        model.addAttribute(COUNTRIES, countryService.getAllCountries());
        return pages.getPageByName(CITY).getAddress();
    }

    @PostMapping(value = "/admin/create")
    public String createCity(@ModelAttribute CityDto city, Model model) {
        cityService.addCity(city);
        return getAllCities(model);
    }

    @GetMapping(value = "/get")
    public String getAllCities(Model model) {
        return getCityPage(DEFAULT_PAGE_SIZE, 1, model);
    }

    @GetMapping(value = "/get/{id}")
    public String getCity(@PathVariable("id") long id, Model model) {
        model.addAttribute(CITY, cityService.getCityById(id));
        model.addAttribute(STATIONS, stationService.getStationsByCity(id));
        return CITY;
    }
}
