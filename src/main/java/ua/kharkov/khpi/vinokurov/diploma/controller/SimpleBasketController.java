package ua.kharkov.khpi.vinokurov.diploma.controller;

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
import ua.kharkov.khpi.vinokurov.diploma.model.dto.BasketDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.SeatDto;
import ua.kharkov.khpi.vinokurov.diploma.service.BasketService;
import ua.kharkov.khpi.vinokurov.diploma.service.SeatService;
import ua.kharkov.khpi.vinokurov.diploma.util.ControllerRedirector;
import ua.kharkov.khpi.vinokurov.diploma.util.Paginator;

import java.util.List;
import java.util.Objects;

import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.DEFAULT_PAGE_SIZE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.PAGE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.SEATS;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.SIZE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.PageNames.BASKET;
import static ua.kharkov.khpi.vinokurov.diploma.constant.PageNames.USER;


@Controller
@RequestMapping("/simple_basket")
public class SimpleBasketController {
    public static final String REDIRECT_URL = "/simple_basket/get/{}";

    @Autowired
    private BasketService basketService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private Paginator paginator;
    @Autowired
    private ControllerRedirector redirector;


    @Autowired
    private Pages pages;

    @GetMapping("/get/{id}")
    public String getBasket(@PathVariable("id") long id, Model model) {
        return getBasketPage(basketService.getById(id).orElse(null), DEFAULT_PAGE_SIZE, 1, model);
    }

    @GetMapping("/userId/{id}")
    public ModelAndView getBasketByUserId(@PathVariable("id") long userId, Model model) {
        return getOrCreateBasket(userId, DEFAULT_PAGE_SIZE, 1, model);
    }

    @GetMapping("/get/userId/{id}")
    public ModelAndView getOrCreateBasket(@PathVariable("id") long userId,
                                          @RequestParam(name = "size") int size,
                                          @RequestParam(name = "page") int page, Model model) {
        final BasketDto basketDto = basketService.getOrCreate(userId);
        return redirector.getRedirectDataWithParameters(model, REDIRECT_URL, String.valueOf(basketDto.getId()));
    }


    private String getBasketPage(BasketDto basketDto, @RequestParam(name = "size") int size,
                                 @RequestParam(name = "page") int page, Model model) {
        model.addAttribute(BASKET, basketDto);
        if (Objects.nonNull(basketDto)) {
            model.addAttribute(SEATS, paginator.getPage(basketDto.getSeat(), page - 1, size));
            model.addAttribute(USER, basketDto.getUser().getName());
            model.addAttribute(PAGE_ATTRIBUTE, page);
            model.addAttribute(SIZE_ATTRIBUTE, size);
        }
        return BASKET;
    }


    @PutMapping("/update/basketId/{id}")
    public ModelAndView updateBasket(@PathVariable("id") long basketId, @ModelAttribute List<SeatDto> seats, Model model) {
        basketService.updateSeats(basketId, seats)
                .orElseThrow(() -> new IllegalArgumentException("No such element"));
        return redirector.getRedirectDataWithParameters(model, REDIRECT_URL, String.valueOf(basketId));
    }

    @PostMapping("/add/basketId/{id}")
    public ModelAndView addSeatToBasket(@PathVariable("id") long basketId, @ModelAttribute long seatId, Model model) {
        basketService.addSeat(basketId, seatId);
        return redirector.getRedirectDataWithParameters(model, REDIRECT_URL, String.valueOf(basketId));
    }

    @PostMapping("/add/userId/{id}")
    public ModelAndView addSeatToBasketByUser(@PathVariable("id") long userId,
                                              @ModelAttribute(name = "seatId") long seatId, Model model) {
        final BasketDto basket = basketService.getOrCreate(userId);
        basketService.addSeat(basket.getId(), seatId);
        return redirector.getRedirectDataWithParameters(model, REDIRECT_URL, String.valueOf(basket.getId()));
    }

}
