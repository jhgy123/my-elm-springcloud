package com.example.elmspringcloud.controllers;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.elmspringcloud.entities.dto.CommonResult;
import com.example.elmspringcloud.sentinelhandler.MySentinelBlockHandler;
import com.example.elmspringcloud.sentinelhandler.MySentinelFallback;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/businessconfig")
@RefreshScope
@Tag(name = "config控制器 V1")
public class ConfigController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.food-server}")
    private String serverURL;  //向nacos获取食品微服务的url(包括负载均衡)

    @Value("${server.message}")
    private String server_message;
    @Value("${server.version}")
    private String server_version;
    @Value("${commons.message}")
    private String commons_message;
    @Value("${commons.version}")
    private String commons_version;

    @GetMapping("/get")
    @Operation(summary = "查询 获取配置文件信息")
    public String get() {
        return commons_message+"--"+commons_version+"\n"+
                server_message+"--"+server_version;
    }


    @GetMapping("/findfoodserver")
    @Operation(summary = "查询 查询实际调用的food-server微服务")
    @SentinelResource(value = "findfoodserver",
            blockHandlerClass = MySentinelBlockHandler.class,
            blockHandler = "findFoodServerHandlerException",
            fallbackClass = MySentinelFallback.class,
            fallback = "findFoodServerHandlerFallback") //熔断降级
    public CommonResult<String> findFoodServer() {
        //在商家微服务中调用食品微服务
        String result =restTemplate.getForObject(serverURL + "/config/getserverport", String.class);
        return new CommonResult(200,"success",result);
    }
}