package com.example.elmspringcloud.service;
import com.example.elmspringcloud.dao.UserDao;
import com.example.elmspringcloud.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService extends AbstractTypedService<User, String>{
    // @Resource
    UserDao miDao;
    UserService(UserDao dao) {
        this.dataContext = dao;
        this.miDao = dao;
    }
    public User getUserById(String id) {
        if (id == null || id == "") {
            return null;
        }
        return miDao.findById(id).orElse(null);
    }
    public User getUserByUserName(String userName) {

        var us = this.miDao.findUserByUsername(userName);

        return us;
    }
    @Operation(summary = "根据用户id和密码查询用户")
    public User queryUserByIdAndPassword(String id,String password){
        if(id==""||password==""||id==null||password==null){
            return null;
        }
        return miDao.findUserByIdAndPassword(id,password);
    }
}
