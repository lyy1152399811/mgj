package com.qingao.mgj.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ErrorPageResovler implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView mv = new ModelAndView();
        switch (status) {
        case NOT_FOUND:
            mv.setViewName("redirect:/errorpage_404.html");
            break;
        case INTERNAL_SERVER_ERROR:
            mv.setViewName("redirect:/errorpage_500.html");
            break;
            
            default:
                mv.setViewName("redirect:/err404.html");
        }
        return mv;
    }
}