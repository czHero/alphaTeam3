package com.telecom.service;

import com.telecom.domain.customer;

import java.util.List;

/**
 * Created by huanghua on 2017/5/26.
 */
public interface CustomerService {
    public List<customer> query( customer c);

    public boolean insert(customer c);

    public void update(customer c);

    public boolean delete(customer c);
}
