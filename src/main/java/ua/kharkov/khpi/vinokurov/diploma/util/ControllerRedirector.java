package ua.kharkov.khpi.vinokurov.diploma.util;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface ControllerRedirector {
    ModelAndView getRedirectData(Model model, String redirectUrl);

    ModelAndView getRedirectDataWithParameters(Model model, String redirectUrl, String... params);

    ModelAndView getRedirectDataForControllerGet(Model model, String controllerName);
}

