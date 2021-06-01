package ua.kharkov.khpi.vinokurov.diploma.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.kharkov.khpi.vinokurov.diploma.constant.PageNames;
import ua.kharkov.khpi.vinokurov.diploma.controller.beans.PageData;
import ua.kharkov.khpi.vinokurov.diploma.controller.beans.Pages;

@Configuration
public class BeanConfiguration {
    @Bean
    public Pages getPages() {
        return Pages.builder()
                .pageData(PageData.of(PageNames.CITY, PageNames.CITY_PAGE))
                .pageData(PageData.of(PageNames.COUNTRY, PageNames.COUNTRY_PAGE))
                .pageData(PageData.of(PageNames.PLANE, PageNames.PLANE_PAGE))
                .pageData(PageData.of(PageNames.SINGLE_FLIGHT, PageNames.SINGLE_FLIGHT_PAGE))
                .pageData(PageData.of(PageNames.STATION, PageNames.STATION_PAGE))
                .pageData(PageData.of(PageNames.USER, PageNames.USER_PAGE))
                .pageData(PageData.of(PageNames.ROUTE, PageNames.ROUTE_PAGE))
                .build();
    }
}
