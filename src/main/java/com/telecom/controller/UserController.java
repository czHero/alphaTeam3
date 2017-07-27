package com.telecom.controller;

import com.telecom.domain.customer;
import com.telecom.service.CustomerService;
import org.omg.CORBA.Object;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huanghua on 2017/5/26.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    CustomerService cusomerServie;

    @RequestMapping("/list")
    public ModelAndView queryAll(){

        customer c = new customer();
        List<customer> list = cusomerServie.query(c);

        ModelAndView modelAndView = new ModelAndView("userList");
        cusomerServie.query(c);
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String,String> userInsert(@RequestParam(value="username",required = true) String username,
                                         @RequestParam(value="password",required = true) String password,
                                         @RequestParam(value="email",required = true) String email,
                                         @RequestParam(value="mobile",required = true) String mobile){
        Map<String,String> resultMap = new HashMap<String,String>();
        customer c = new customer();
        c.setUsername(username);
        List<customer> tmp = cusomerServie.query(c);

        if(tmp != null){
            if(tmp.size() != 0){
                resultMap.put("flag","-1");
                resultMap.put("message","已存在该用户!");
                return resultMap;
            }
        }

        c.setPassword(password);
        c.setEmail(email);
        c.setMobile(mobile);
        c.setAdmin_flg("0");



        boolean flag = cusomerServie.insert(c);
        if(flag){
            resultMap.put("flag","0");
            resultMap.put("message","新用户注册成功!欢迎您");
        }else{
            resultMap.put("flag","-1");
            resultMap.put("message"," 注册失败!");
        }
        return resultMap;
    }

    @RequestMapping("/search")
    @ResponseBody
    public ModelAndView search(@RequestParam(value="username",required = false) String username){
        customer c = new customer();
        c.setUsername(username);

        ModelAndView modelAndView = new ModelAndView("userListPart");
        List<customer> list = cusomerServie.query(c);
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public ModelAndView userEdit(@RequestParam(value="id",required = false) String id){
        ModelAndView modelAndView = new ModelAndView("modifycustomer");
        customer c = new customer();
        c.setId(Integer.parseInt(id));
        customer vo = cusomerServie.query(c).get(0);
        modelAndView.addObject("customer", vo);
        return modelAndView;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public Map<String,String> userModify(@RequestParam(value="username",required = true) String username,
                                         @RequestParam(value="mobile",required = true) String mobile,
                                         @RequestParam(value="email",required = true) String email){

        Map<String,String> resultMap = new HashMap<String,String>();
        customer c = new customer();
        c.setUsername(username);

         customer vo = cusomerServie.query(c).get(0);
         vo.setMobile(mobile);
         vo.setEmail(email);

        cusomerServie.update(vo);
        resultMap.put("flag", "0");
        return resultMap;

    }

    @RequestMapping("/reset")
    @ResponseBody
    public Map<String,String> userReset(@RequestParam(value="username",required = true) String username,
                                         @RequestParam(value="mobile",required = true) String mobile,
                                         @RequestParam(value="email",required = true) String email){

        Map<String,String> resultMap = new HashMap<String,String>();
        customer c = new customer();
        c.setUsername(username);
        c.setEmail(email);
        c.setMobile(mobile);

        List<customer> vo = cusomerServie.query(c);
        if(vo.size()!=0){
            for(customer v : vo){
                v.setPassword("e10adc3949ba59abbe56e057f20f883e");
                cusomerServie.update(v);
            }
            resultMap.put("flag", "0");
            resultMap.put("message", "密码已重置为123456");
        }else{
            resultMap.put("flag", "-1");
            resultMap.put("message", "信息不正确");
        }
        return resultMap;

    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map<String,String> delete(@RequestParam(value="username",required = false) String username){
        Map<String,String> resultMap = new HashMap<String,String>();
        customer c = new customer();
        c.setUsername(username);

        boolean flag = cusomerServie.delete(c);
        if(flag){
            resultMap.put("flag","0");
            resultMap.put("message","删除成功");
        }else{
            resultMap.put("flag","-1");
            resultMap.put("message"," 删除失败!");
        }
        return resultMap;
    }
}
