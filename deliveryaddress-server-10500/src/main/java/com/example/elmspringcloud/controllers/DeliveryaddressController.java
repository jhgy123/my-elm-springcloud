package com.example.elmspringcloud.controllers;

import com.example.elmspringcloud.entities.Deliveryaddress;
import com.example.elmspringcloud.entities.User;
import com.example.elmspringcloud.service.DeliveryaddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
//@CrossOrigin
@RestController
@RequestMapping("deliveryaddress")
@Tag(name = "deliveryaddress控制器 V1")
public class DeliveryaddressController extends AbstractTypedController<Deliveryaddress, Integer> {
    DeliveryaddressService miService;
    DeliveryaddressController(DeliveryaddressService muSvc) {
        this.svcContext = muSvc;
        this.miService=muSvc;
    }

    @PostMapping("/findbyuser")
    @Operation(summary = "查询 根据用户查询地址列表")
    public List<Deliveryaddress> findByUser(@RequestBody User user) {
        return miService.queryAllByUser(user);
    }
}
