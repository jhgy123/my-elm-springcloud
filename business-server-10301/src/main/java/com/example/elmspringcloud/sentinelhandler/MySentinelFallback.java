package com.example.elmspringcloud.sentinelhandler;
import com.example.elmspringcloud.entities.Food;
import com.example.elmspringcloud.entities.dto.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedList;
import java.util.List;

public class MySentinelFallback {

    public static CommonResult findFoodServerHandlerFallback(Throwable e) {
        return new CommonResult(403,"服务出现问题了，请稍后再重试");
    }
    //函数参数需要与controller方法的参数一致
    public static List<Food> findFoodsByOrderTypeIdHandlerFallback(@PathVariable int businessid, Throwable e) {
        List<Food> list =new LinkedList<>();
        return list;
    }
}
