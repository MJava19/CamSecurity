package ua.lviv.lgs.CamSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @PostMapping("/error")
    public String handleError500(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == 403) {
                return "error-403";
            }
            else if(statusCode == 500) {
                return "error-500";
            }
        }
        return "error";
    }

    @GetMapping("/error")
    public String handleError403(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == 403) {
                return "error-403";
            }
    }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
