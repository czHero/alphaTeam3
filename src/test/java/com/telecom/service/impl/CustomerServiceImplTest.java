package com.telecom.service.impl;

import com.telecom.domain.customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by huanghua on 2017/5/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {
    @Resource
    CustomerServiceImpl service;

    @Test
    public void Test(){
        customer c = new customer();
        c.setId(1);
        List<customer> lst = service.query(c);
        System.out.println("查询的用户姓名:" + lst.get(0).getUsername() + "   查询的用户号码:" + lst.get(0).getMobile());
    }
}
