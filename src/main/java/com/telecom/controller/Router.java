package com.telecom.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huanghua on 2017/5/23.
 */
@Controller
public class Router {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(value="name",required = false,defaultValue = "") String name){
        return "hello world";
    }
    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}