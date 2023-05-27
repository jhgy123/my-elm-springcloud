package com.example.elmspringcloud.controllers;
import com.example.elmspringcloud.entities.User;
import com.example.elmspringcloud.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("user")
@Tag(name = "user控制器 V1")
public class UserController extends AbstractTypedController<User, String> {
    UserService miService;
    UserController(UserService muSvc) {
        this.svcContext = muSvc;
        this.miService=muSvc;
    }
    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public User loginf(@RequestParam String id, @RequestParam String password) {
        return miService.queryUserByIdAndPassword(id,password);
    }

}
