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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.kharkov.khpi.vinokurov.diploma.controller.beans.Pages;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SingleFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.service.PlaneService;
import ua.kharkov.khpi.vinokurov.diploma.service.RouteService;
import ua.kharkov.khpi.vinokurov.diploma.service.SingleFlightService;
import ua.kharkov.khpi.vinokurov.diploma.util.ControllerRedirector;
import ua.kharkov.khpi.vinokurov.diploma.util.Paginator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.DEFAULT_PAGE_SIZE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.PAGE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.PLANES;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.ROUTES;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.SINGLE_FLIGHTS;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.SIZE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.PageNames.SINGLE_FLIGHT;


@RequestMapping("/single_flight")
@Controller
public class SingleFlightController {
    @Autowired
    private SingleFlightService singleFlightService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private PlaneService planeService;
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
    public String getAllSingleFlights(Model model) {
        return getPage(DEFAULT_PAGE_SIZE, 1, model);
    }


    @GetMapping("/admin/page")
    public String getPage(@RequestParam(name = "size") int size,
                          @RequestParam(name = "page") int page, Model model) {
        model.addAttribute(SINGLE_FLIGHTS, paginator.getPage(singleFlightService.getAllSingleFlight(), page - 1, size));
        model.addAttribute(SINGLE_FLIGHT, new SingleFlightDto());
        model.addAttribute(PAGE_ATTRIBUTE, page);
        model.addAttribute(SIZE_ATTRIBUTE, size);
        model.addAttribute(ROUTES, routeService.getAllRoutes());
        model.addAttribute(PLANES, planeService.getAll());
        return pages.getPageByName(SINGLE_FLIGHT).getAddress();
    }

    @PostMapping(value = "/admin/create")
    public ModelAndView createSingleFlight(@ModelAttribute SingleFlightDto singleFlightDto, Model model) {
        singleFlightService.create(singleFlightDto);
        return redirector.getRedirectDataForControllerGet(model, "/single_flight");
    }

    @GetMapping(value = "/get/{id}")
    public String getSingleFlight(@PathVariable("id") long id, Model model) {
        model.addAttribute(SINGLE_FLIGHT, singleFlightService.getById(id).orElse(null));
        return SINGLE_FLIGHT;
    }

    @GetMapping(value = "/get/routeId/{id}")
    @ResponseBody
    public List<SingleFlightDto> getAllSingleFlightsForRoute(@PathVariable("id") long id, Model model) {
        return singleFlightService.findByRouteId(id);
    }

    @GetMapping(value = "/get/stations")
    @ResponseBody
    public List<SingleFlightDto> getByStationsAndDate(@ModelAttribute("startId") long startId, @ModelAttribute("endId") long endId, @ModelAttribute("date") Date date) {
        return singleFlightService.findByBeginDateAndStations(date, startId, endId);
    }
}
