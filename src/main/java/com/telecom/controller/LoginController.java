package com.telecom.controller;

import com.telecom.domain.customer;
import com.telecom.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huanghua on 2017/5/26.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    CustomerService customerService;

    @RequestMapping("/check")
    @ResponseBody
    public Map<String,String> hello(@RequestParam(value="username",required = true) String username,
                                    @RequestParam(value="password",required = true) String password)
    {
        Map<String,String> resultMap = new HashMap<String,String>();
        customer c = new customer();
        c.setUsername(username);
        c.setPassword(password);
        List<customer> lst = customerService.query(c);
        if(lst.size() == 0){
            resultMap.put("flag","-1");
        }else{
            String admin_flg = lst.get(0).getAdmin_flg();

            if(admin_flg != null && admin_flg != ""){
                if(admin_flg.equals("1")){
                    resultMap.put("flag","1");
                }else{
                    resultMap.put("flag","0");
                }
            }
        }
        return resultMap;
    }
}
