package com.telecom.dao;

import com.telecom.domain.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by huanghua on 2017/5/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemMapperTest {

    @Resource
    ItemMapper mapper;

    @Test
    public void Test(){

        int id = 1;
        List<Item> lst =  mapper.query(id);
        System.out.println();
       System.out.println("aaaaa");
    }
}
