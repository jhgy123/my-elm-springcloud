package src.main.java.com.example.elmspringcloud.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.main.java.com.example.elmspringcloud.config.CommonResult;

@RestController
public class FallbackController {
    @RequestMapping("/fallback")
    public CommonResult fallback(){
        //403：发送的请求被服务器拒绝
        return new CommonResult(403,"Gateway触发了熔断降级方法",null);
    }
}
