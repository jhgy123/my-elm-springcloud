package com.example.elmspringcloud.controllers;
import com.example.elmspringcloud.entities.Business;
import com.example.elmspringcloud.entities.Food;
import com.example.elmspringcloud.service.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
//@CrossOrigin
@RestController
@RequestMapping("food")
@Tag(name = "food控制器 V1")
public class FoodController extends AbstractTypedController<Food, Integer> {
    FoodService miService;
    FoodController(FoodService muSvc) {
        this.svcContext = muSvc;
        this.miService=muSvc;
    }

    @PostMapping("/findbybusiness")
    @Operation(summary = "查询 根据商家查询菜品列表")
    public List<Food> findByBusiness(@RequestBody Business business) {
        return miService.queryAllByBusiness(business);
    }
}
