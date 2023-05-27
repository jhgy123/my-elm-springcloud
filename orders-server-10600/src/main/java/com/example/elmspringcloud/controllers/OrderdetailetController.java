package com.example.elmspringcloud.controllers;

import com.example.elmspringcloud.entities.Orderdetailet;
import com.example.elmspringcloud.entities.Orders;
import com.example.elmspringcloud.service.OrderdetailetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
//@CrossOrigin
@RestController
@RequestMapping("orderdetailet")
@Tag(name = "orderdetailet控制器 V1")
public class OrderdetailetController extends AbstractTypedController<Orderdetailet, Integer> {
    OrderdetailetService miService;
    OrderdetailetController(OrderdetailetService muSvc) {
        this.svcContext = muSvc;
        this.miService=muSvc;
    }

    @PostMapping("/findbyorders")
    @Operation(summary = "查询 根据订单编号查询订单详情")
    public List<Orderdetailet> findByOrders(@RequestBody Orders orders) {
        return miService.queryAllByOrders(orders);
    }

}
