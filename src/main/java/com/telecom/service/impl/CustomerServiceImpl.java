package com.telecom.service.impl;

import com.telecom.dao.CustomerMapper;
import com.telecom.domain.customer;
import com.telecom.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by huanghua on 2017/5/26.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerMapper mapper;

    public boolean delete(customer c){
         mapper.delete(c);
        int id = c.getId();
        customer vo = new customer();
        vo.setId(id);
        List<customer> lst = mapper.query(vo);
        if(lst.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public void update(customer c){
        mapper.update(c);
    }

    /**
     * 查询操作
     * @param c
     * @return
     */
    public List<customer> query(customer c){
        return mapper.query(c);
    }

    /**
     *  插入操作
     * @param c
     * @return
     */
    public boolean insert(customer c){
        if(c != null){
            /**设置当前时间**/
            Date now = new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str = sdf.format(now);

            c.setReg_time(str);
            c.setUpdate_time(str);

            mapper.insert(c);
        }

        int id = c.getId();
        customer vo = new customer();
        vo.setId(id);
        List<customer> lst = mapper.query(vo);
        if(lst.size() == 0){
            return false;
        }else{
            return true;
        }
    }
}
