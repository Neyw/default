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
import ua.kharkov.khpi.vinokurov.diploma.model.dto.StationDto;
import ua.kharkov.khpi.vinokurov.diploma.service.CityService;
import ua.kharkov.khpi.vinokurov.diploma.service.RouteService;
import ua.kharkov.khpi.vinokurov.diploma.service.StationService;
import ua.kharkov.khpi.vinokurov.diploma.util.Paginator;

import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.CITIES;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.DEFAULT_PAGE_SIZE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.PAGE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.ROUTES;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.SIZE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.STATIONS;
import static ua.kharkov.khpi.vinokurov.diploma.constant.PageNames.STATION;


@RequestMapping("/station")
@Controller
public class StationController {
    @Autowired
    private StationService stationService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private CityService cityService;
    @Autowired
    private Paginator paginator;

    @Autowired
    private Pages pages;

    @GetMapping(value = "/admin/get")
    public String getAdminPage(Model model) {
        return getPage(DEFAULT_PAGE_SIZE, 1, model);
    }

    @GetMapping(value = "/get")
    public String getAllStations(Model model) {
        return getPage(DEFAULT_PAGE_SIZE, 1, model);
    }


    @GetMapping("/admin/page")
    public String getPage(@RequestParam(name = "size") int size,
                          @RequestParam(name = "page") int page, Model model) {
        model.addAttribute(STATIONS, paginator.getPage(stationService.getAllStations(), page - 1, size));
        model.addAttribute(STATION, new StationDto());
        model.addAttribute(PAGE_ATTRIBUTE, page);
        model.addAttribute(SIZE_ATTRIBUTE, size);
        model.addAttribute(CITIES, cityService.getAllCities());
        return pages.getPageByName(STATION).getAddress();
    }

    @PostMapping(value = "/admin/create")
    public String createStation(@ModelAttribute StationDto station, Model model) {
        stationService.createStation(station);
        return getAdminPage(model);
    }

    @GetMapping(value = "/get/{id}")
    public String getStation(@PathVariable("id") long id, Model model) {
        model.addAttribute(STATION, stationService.getStation(id).orElse(null));
        model.addAttribute(ROUTES, routeService.findByStation(id));
        return STATION;
    }
}
