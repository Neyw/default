package ua.kharkov.khpi.vinokurov.diploma.util.impl;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import ua.kharkov.khpi.vinokurov.diploma.util.ControllerRedirector;

@Component
public class ControllerRedirectorImpl implements ControllerRedirector {
    private static final String REDIRECT_PREFIX = "redirect:";
    private static final String GET_PAGE_SUFFIX = "/get";

    @Override
    public ModelAndView getRedirectData(Model model, String redirectUrl) {
        final ModelAndView modelAndView = new ModelAndView(REDIRECT_PREFIX + redirectUrl);
        modelAndView.addAllObjects(model.asMap());
        return modelAndView;
    }

    @Override
    public ModelAndView getRedirectDataWithParameters(Model model, String redirectUrl, String... params) {
        for (String param : params) {
            redirectUrl = redirectUrl.replaceFirst("\\{}", param);
        }
        return getRedirectData(model, redirectUrl);
    }

    @Override
    public ModelAndView getRedirectDataForControllerGet(Model model, String controllerUrl) {
        return getRedirectData(model, controllerUrl + GET_PAGE_SUFFIX);
    }
}
