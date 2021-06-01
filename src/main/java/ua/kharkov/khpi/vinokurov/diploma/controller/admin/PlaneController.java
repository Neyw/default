package ua.kharkov.khpi.vinokurov.diploma.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.kharkov.khpi.vinokurov.diploma.controller.beans.Pages;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.PlaneDto;
import ua.kharkov.khpi.vinokurov.diploma.service.PlaneService;
import ua.kharkov.khpi.vinokurov.diploma.util.ControllerRedirector;
import ua.kharkov.khpi.vinokurov.diploma.util.Paginator;

import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.DEFAULT_PAGE_SIZE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.PAGE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.PLANES;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.SIZE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.PageNames.PLANE;


@RequestMapping("/plane")
@Controller
public class PlaneController {
    @Autowired
    private PlaneService planeService;
    @Autowired
    private ControllerRedirector redirector;
    @Autowired
    private Paginator paginator;

    @Autowired
    private Pages pages;

    @PostMapping(value = "/admin/create")
    public ModelAndView createPlane(@ModelAttribute PlaneDto plane, Model model) {
        planeService.create(plane);
        return redirector.getRedirectDataForControllerGet(model, "/plane");
    }


    @GetMapping("/admin/page")
    public String getPage(@RequestParam(name = "size") int size,
                          @RequestParam(name = "page") int page, Model model) {
        model.addAttribute(PLANES, paginator.getPage(planeService.getAll(), page - 1, size));
        model.addAttribute(PLANE, new PlaneDto());
        model.addAttribute(PAGE_ATTRIBUTE, page);
        model.addAttribute(SIZE_ATTRIBUTE, size);
        return pages.getPageByName(PLANE).getAddress();
    }

    @GetMapping(value = "/get")
    public String getAll(Model model) {
        return getPage(DEFAULT_PAGE_SIZE, 1, model);
    }


    @GetMapping(value = "/get/{id}")
    public String getPlane(@PathVariable("id") long id, Model model) {
        model.addAttribute(PLANE, planeService.getById(id));
        return PLANE;
    }

    @PutMapping(value = "/admin/name/planeId/{id}")
    public ModelAndView updatePlaneName(@PathVariable("id") long id, @ModelAttribute("name") String newName, Model model) {
        planeService.updateName(id, newName);
        return redirector.getRedirectDataForControllerGet(model, "/plane");
    }
}
