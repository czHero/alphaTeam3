package com.telecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huanghua on 2017/5/26.
 */
@Controller
@RequestMapping("/register")
public class RegisterController{

    @RequestMapping("/home")
    @ResponseBody
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @RequestMapping("/protocol")
    public ModelAndView protocol(){
        ModelAndView modelAndView = new ModelAndView("protocol");
        return modelAndView;
    }

}
