package com.example.elmspringcloud.service;
import com.example.elmspringcloud.dao.OrdersDao;
import com.example.elmspringcloud.entities.Orders;
import com.example.elmspringcloud.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class OrdersService extends AbstractTypedService<Orders, Integer> {
    // @Resource
    OrdersDao miDao;
    OrdersService(OrdersDao dao) {
        this.dataContext = dao;
        this.miDao = dao;
    }
    @Operation(summary = "根据用户和订单状态查询订单")
    public List<Orders> queryAllByUserAndOrderState(User user, Boolean state){
        if(user==null||state==null){
            return new LinkedList<>();
        }
        return miDao.findAllByUserAndOrderState(user,state);
    }
    @Operation(summary = "支付订单")
    public Orders payorder(Orders item) {
        Orders byId = miDao.getById(item.getId());
        byId.setOrderState(true);
        return miDao.save( byId);
    }
}
