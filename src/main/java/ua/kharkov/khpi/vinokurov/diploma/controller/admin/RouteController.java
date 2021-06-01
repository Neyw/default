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
import ua.kharkov.khpi.vinokurov.diploma.model.dto.RouteDto;
import ua.kharkov.khpi.vinokurov.diploma.service.RouteService;
import ua.kharkov.khpi.vinokurov.diploma.service.SingleFlightService;
import ua.kharkov.khpi.vinokurov.diploma.service.StationService;
import ua.kharkov.khpi.vinokurov.diploma.util.ControllerRedirector;
import ua.kharkov.khpi.vinokurov.diploma.util.Paginator;

import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.DEFAULT_PAGE_SIZE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.PAGE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.ROUTES;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.SINGLE_FLIGHTS;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.SIZE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.STATIONS;
import static ua.kharkov.khpi.vinokurov.diploma.constant.PageNames.ROUTE;


@RequestMapping("/route")
@Controller
public class RouteController {
    @Autowired
    private SingleFlightService singleFlightService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private StationService stationService;
    @Autowired
    private Paginator paginator;
    @Autowired
    private ControllerRedirector redirector;
    @Autowired
    private Pages pages;

    @GetMapping(value = "/admin/get")
    public String getAdminPage(Model model) {
        return getPage(DEFAULT_PAGE_SIZE, 1, model);
    }

    @GetMapping(value = "/get")
    public String getAllRoutes(Model model) {
        return getPage(DEFAULT_PAGE_SIZE, 1, model);
    }


    @GetMapping("/admin/page")
    public String getPage(@RequestParam(name = "size") int size,
                          @RequestParam(name = "page") int page, Model model) {
        model.addAttribute(ROUTES, paginator.getPage(routeService.getAllRoutes(), page - 1, size));
        model.addAttribute(ROUTE, new RouteDto());
        model.addAttribute(PAGE_ATTRIBUTE, page);
        model.addAttribute(SIZE_ATTRIBUTE, size);
        model.addAttribute(STATIONS, stationService.getAllStations());
        return pages.getPageByName(ROUTE).getAddress();
    }

    @PostMapping(value = "/admin/create")
    public ModelAndView createRoute(@ModelAttribute RouteDto routeDto, Model model) {
        routeService.create(routeDto);
        return redirector.getRedirectDataForControllerGet(model, "/route");
    }

    @GetMapping(value = "/get/{id}")
    public String getRoute(@PathVariable("id") long id, Model model) {
        model.addAttribute(ROUTE, routeService.getById(id).orElse(null));
        model.addAttribute(SINGLE_FLIGHTS, singleFlightService.findByRouteId(id));
        return ROUTE;
    }
}
