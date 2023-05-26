package com.example.elmspringcloud.service;
import com.example.elmspringcloud.dao.CartDao;
import com.example.elmspringcloud.entities.Business;
import com.example.elmspringcloud.entities.Cart;
import com.example.elmspringcloud.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CartService extends AbstractTypedService<Cart, Integer> {
    // @Resource
    CartDao miDao;
    CartService(CartDao dao) {
        this.dataContext = dao;
        this.miDao = dao;
    }
    @Operation(summary = "根据商家和用户获取购物车食物列表")
    public List<Cart> queryCartsByBusinessAndUser(Integer businessid, String userid){
        Business build = Business.builder().id(businessid).build();
        User build1 = User.builder().build();
        build1.setId(userid);
        return miDao.findCartsByBusinessAndUser(build,build1);
    }
    public void deleteAllByCarts(List<Cart> carts){
        miDao.deleteAllInBatch(carts);
    }
}
