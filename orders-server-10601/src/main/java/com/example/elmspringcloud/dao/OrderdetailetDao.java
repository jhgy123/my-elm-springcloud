package com.example.elmspringcloud.dao;
import com.example.elmspringcloud.entities.Orderdetailet;
import com.example.elmspringcloud.entities.Orders;

import java.util.List;

public interface OrderdetailetDao extends AbstractDao<Orderdetailet, Integer> {
    /**
     * 根据ordersid(订单号)查询所有的订单详细信息
     * @param orders 订单对象（主要是订单号）
     * @return List<Orderdetailet> 订单详细list
     */
    List<Orderdetailet> findAllByOrders(Orders orders);
}
