package com.example.elmspringcloud.service;
import com.example.elmspringcloud.dao.BusinessDao;
import com.example.elmspringcloud.entities.Business;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BusinessService extends AbstractTypedService<Business, Integer> {
    // @Resource
    BusinessDao miDao;
    BusinessService(BusinessDao dao) {
        this.dataContext = dao;
        this.miDao = dao;
    }
    @Operation(summary = "根据点餐分类编号获取商家对象列表")
    public List<Business> queryAllByOrderTypeId(int orderTypeId){
        return miDao.findAllByOrderTypeId(orderTypeId);
    }

}
