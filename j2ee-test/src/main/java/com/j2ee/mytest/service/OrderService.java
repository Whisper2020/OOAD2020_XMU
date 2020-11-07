package com.j2ee.mytest.service;

import com.j2ee.mytest.dao.OrderDao;
import com.j2ee.mytest.model.bo.Order;
import com.j2ee.mytest.util.ResponseCode;
import com.j2ee.mytest.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public ReturnObject<Object> updateOrder(Long id){
        Order order = new Order();
        order.setState(1);
        ReturnObject<Order> retObj = orderDao.updateOrder(order);
        ReturnObject<Object> retOrder;
        if (retObj.getCode().equals(ResponseCode.OK)) {
            retOrder = new ReturnObject<>(retObj.getData());
        } else {
            retOrder = new ReturnObject<>(retObj.getCode(), retObj.getErrmsg());
        }
        return retOrder;
    }
}
