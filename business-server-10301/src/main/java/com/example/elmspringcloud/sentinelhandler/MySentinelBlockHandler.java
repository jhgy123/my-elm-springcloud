package com.example.elmspringcloud.sentinelhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.elmspringcloud.entities.Food;
import com.example.elmspringcloud.entities.dto.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedList;
import java.util.List;

public class MySentinelBlockHandler {
    public static CommonResult findFoodServerHandlerException(BlockException exception) {
        return new CommonResult(4444,"sentinel触发了熔断降级");
    }
    //函数参数需要与controller方法的参数一致
    public static List<Food>  findFoodsByOrderTypeIdHandlerException(@PathVariable int businessid,BlockException exception) {
        List<Food> list =new LinkedList<>();
        return list;
    }
}
