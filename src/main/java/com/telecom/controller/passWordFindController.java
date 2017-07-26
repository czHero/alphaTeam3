package com.telecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huanghua on 2017/5/26.
 */
@Controller
@RequestMapping("/pswfinder")
public class passWordFindController{

    @RequestMapping("/setsct")
    public ModelAndView setsct() {
        ModelAndView modelAndView = new ModelAndView("setsct");
        return modelAndView;
    }

    @RequestMapping("/forget")
    public ModelAndView forget() {
        ModelAndView modelAndView = new ModelAndView("forget");
        return modelAndView;
    }

    @RequestMapping("/done")
    public ModelAndView done() {
        ModelAndView modelAndView = new ModelAndView("done");
        return modelAndView;
    }

}
