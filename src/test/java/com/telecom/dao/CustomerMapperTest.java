package com.telecom.dao;

import com.telecom.domain.customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by huanghua on 2017/5/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerMapperTest {
    @Resource
    CustomerMapper mapper;

    @Test
    public void Test(){
        customer c = new customer();
        c.setUsername("黄骅");

        customer vo = mapper.query(c).get(0);
        vo.setReal_name("黄骅黄骅");
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(now);
        vo.setUpdate_time(str);
        mapper.update(vo);
    }
}
