package com.telecom.dao;

import com.telecom.domain.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by huanghua on 2017/5/25.
 */
@Mapper
@Repository
public interface ItemMapper {
     public List<Item> query(int id);


}
