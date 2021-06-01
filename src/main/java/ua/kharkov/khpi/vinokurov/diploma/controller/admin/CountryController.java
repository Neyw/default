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
import org.springframework.web.servlet.ModelAndView;
import ua.kharkov.khpi.vinokurov.diploma.controller.beans.Pages;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.CountryDto;
import ua.kharkov.khpi.vinokurov.diploma.service.CityService;
import ua.kharkov.khpi.vinokurov.diploma.service.CountryService;
import ua.kharkov.khpi.vinokurov.diploma.util.ControllerRedirector;
import ua.kharkov.khpi.vinokurov.diploma.util.Paginator;

import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.CITIES;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.DEFAULT_PAGE_SIZE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.PAGE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.SIZE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.PageNames.COUNTRY;


@RequestMapping("/country")
@Controller
public class CountryController {
    private static final String COUNTRIES = "countries";

    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;
    @Autowired
    private ControllerRedirector redirector;

    @Autowired
    private Pages pages;

    @Autowired
    private Paginator paginator;

    @GetMapping(value = "/admin/get")
    public String getAdminPage(Model model) {
        return getCountryPage(DEFAULT_PAGE_SIZE, 1, model);
    }


    @GetMapping("/admin/page")
    public String getCountryPage(@RequestParam(name = "size") int size,
                                 @RequestParam(name = "page") int page, Model model) {
        model.addAttribute(COUNTRIES, paginator.getPage(countryService.getAllCountries(), page - 1, size));
        model.addAttribute(COUNTRY, new CountryDto());
        model.addAttribute(PAGE_ATTRIBUTE, page);
        model.addAttribute(SIZE_ATTRIBUTE, size);
        return pages.getPageByName(COUNTRY).getAddress();
    }

    @PostMapping(value = "/admin/create")
    public ModelAndView createCountry(@ModelAttribute CountryDto country, Model model) {
        countryService.addCountry(country);
        return redirector.getRedirectDataForControllerGet(model, "/country");
    }


    @GetMapping(value = "/get")
    public String getAllCountries(Model model) {
        return getCountryPage(DEFAULT_PAGE_SIZE, 1, model);
    }

    @GetMapping(value = "/get/{id}")
    public String getCountry(@PathVariable("id") long id, Model model) {
        model.addAttribute(COUNTRY, countryService.getCountryById(id));
        model.addAttribute(CITIES, cityService.getAllCitiesByCountry(id));
        return COUNTRY;
    }
}
