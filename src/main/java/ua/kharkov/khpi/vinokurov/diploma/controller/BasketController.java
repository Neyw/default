package ua.kharkov.khpi.vinokurov.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.BasketDto;
import ua.kharkov.khpi.vinokurov.diploma.model.dto.UserFlightDto;
import ua.kharkov.khpi.vinokurov.diploma.service.BasketService;
import ua.kharkov.khpi.vinokurov.diploma.util.Paginator;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.DEFAULT_PAGE_SIZE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.PAGE_ATTRIBUTE;
import static ua.kharkov.khpi.vinokurov.diploma.constant.ModelAttributes.SIZE_ATTRIBUTE;


@Controller
@RequestMapping("/basket")
public class BasketController {
  /*  private static final String BASKET_PAGE = "basket";
    private static final String BASKET_CONTENT_PAGE = "fragments/basket_content :: content";
    private static final String BASKET_ATTRIBUTE = "basket";
    private static final String BASKET_ID_ATTRIBUTE = "basketId";
    private static final String USER_FLIGHTS_ATTRIBUTE = "user_flights";

    @Autowired
    private BasketService basketService;
    @Autowired
    private Paginator paginator;

    @GetMapping("/get/{id}")
    public Optional<BasketDto> getBasket(@PathVariable("id") long id, Model model) {
        return basketService.getById(id);
    }

    @GetMapping("/userId/{id}")
    public String getBasketPage(@PathVariable("id") long userId, Model model) {
        getOrCreateBasket(userId, DEFAULT_PAGE_SIZE, 1, model);
        return BASKET_PAGE;
    }

    @GetMapping("/get/userId/{id}")
    public String getOrCreateBasket(@PathVariable("id") long userId,
                                    @RequestParam(name = "size") int size,
                                    @RequestParam(name = "page") int page, Model model) {
        final BasketDto basketDto = basketService.getOrCreate(userId);
        if (Objects.nonNull(basketDto.getUserFlight())) {
            model.addAttribute(USER_FLIGHTS_ATTRIBUTE, paginator.getPage(basketDto.getUserFlight(), page - 1, size));
        }
        model.addAttribute(BASKET_ID_ATTRIBUTE, basketDto.getId());
        return BASKET_CONTENT_PAGE;
    }

    private void paginatedBasket(BasketDto basketDto, int size, int page, Model model) {
        if (Objects.nonNull(basketDto.getUserFlight())) {
            model.addAttribute(USER_FLIGHTS_ATTRIBUTE, paginator.getPage(basketDto.getUserFlight(), page, size));
            model.addAttribute(PAGE_ATTRIBUTE, page);
            model.addAttribute(SIZE_ATTRIBUTE, paginator.getPageAmount(basketDto.getUserFlight(), size));
        }
        model.addAttribute(BASKET_ID_ATTRIBUTE, basketDto.getId());
    }

    @PutMapping("/update/basketId/{id}")
    public String updateBasket(@PathVariable("id") long basketId, @ModelAttribute List<UserFlightDto> userFlights, Model model) {
        final BasketDto basketDto = basketService.updateSeats(basketId, userFlights)
                .orElseThrow(() -> new IllegalArgumentException("No such element"));
        model.addAttribute(USER_FLIGHTS_ATTRIBUTE, paginator.toPages(basketDto.getUserFlight(), DEFAULT_PAGE_SIZE));
        return BASKET_CONTENT_PAGE;
    }

    @PutMapping("/add/basketId/{id}")
    public String addFlightToBasket(@PathVariable("id") long basketId, @ModelAttribute UserFlightDto userFlight, Model model) {
        model.addAttribute(BASKET_ATTRIBUTE, basketService.addSeat(basketId, userFlight));
        return BASKET_CONTENT_PAGE;
    }*/
}
