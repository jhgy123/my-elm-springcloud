package com.example.elmspringcloud.controllers;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.elmspringcloud.entities.Business;
import com.example.elmspringcloud.entities.Food;
import com.example.elmspringcloud.sentinelhandler.MySentinelBlockHandler;
import com.example.elmspringcloud.sentinelhandler.MySentinelFallback;
import com.example.elmspringcloud.service.BusinessService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("business")
@Tag(name = "business控制器 V1")
public class BusinessController extends AbstractTypedController<Business, Integer> {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.food-server}")
    private String serverURL;  //向nacos获取食品微服务的url(包括负载均衡)

    BusinessService miService;
    BusinessController(BusinessService muSvc) {
        this.svcContext = muSvc;
        this.miService=muSvc;
    }

    @GetMapping("/findbyordertypeid/{ordertypeid}")
    @Operation(summary = "查询 根据分类编号查询数据实体列表")
    public List<Business> findByOrderTypeId(@PathVariable int ordertypeid) {
        return miService.queryAllByOrderTypeId(ordertypeid);
    }

    @GetMapping("/findfoodsbybusinessid/{businessid}")
    @Operation(summary = "查询 根据商家id查询所有食品")
    @SentinelResource(value = "findfoodsbybusinessid",
            blockHandlerClass = MySentinelBlockHandler.class,
            blockHandler = "findFoodsByOrderTypeIdHandlerException",
            fallbackClass = MySentinelFallback.class,
            fallback = "findFoodsByOrderTypeIdHandlerFallback")  //熔断降级
    public List<Food> findFoodsByOrderTypeId(@PathVariable int businessid) {
        Business business=new Business();
        business.setId(businessid);
//        System.out.println(serverURL);
        //在商家微服务中调用食品微服务
        List<Food> list = restTemplate.postForObject(serverURL + "/food/findbybusiness", business, List.class);
        return list;
    }


}
