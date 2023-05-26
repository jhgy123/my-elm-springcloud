package com.example.elmspringcloud.dao;
import com.example.elmspringcloud.entities.Business;
import com.example.elmspringcloud.entities.Cart;
import com.example.elmspringcloud.entities.User;

import java.util.List;

public interface CartDao extends AbstractDao<Cart, Integer> {
    List<Cart> findCartsByBusinessAndUser(Business business, User user);

    @Override
    void deleteAllInBatch(Iterable<Cart> entities);
}
