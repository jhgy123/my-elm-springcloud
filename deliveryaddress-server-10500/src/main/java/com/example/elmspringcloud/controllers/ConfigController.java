package com.example.elmspringcloud.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/deliveryaddressconfig")
@RefreshScope
@Tag(name = "config控制器 V1")
public class ConfigController {

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
}