package com.telecom.dao;

import com.telecom.domain.customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by huanghua on 2017/5/26.
 */
@Mapper
@Repository
public interface CustomerMapper {

    public List<customer> query(customer c);

    public void insert(customer c);

    public void update(customer c);

    public void delete(customer c);
}
