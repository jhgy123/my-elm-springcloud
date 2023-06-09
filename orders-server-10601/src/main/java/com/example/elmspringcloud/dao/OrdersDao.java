package com.example.elmspringcloud.dao;

import com.example.elmspringcloud.entities.Orders;
import com.example.elmspringcloud.entities.User;

import java.util.List;

public interface OrdersDao extends AbstractDao<Orders, Integer> {
    /**
     * 根据用户和订单的状态进行查询
     * @param user 用户对象
     * @param state 订单状态
     * @return List<Orders> 订单列表
     */
    List<Orders> findAllByUserAndOrderState(User user, Boolean state);
}
