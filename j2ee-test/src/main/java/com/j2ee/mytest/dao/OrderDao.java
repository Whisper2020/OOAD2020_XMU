package com.j2ee.mytest.dao;


import com.j2ee.mytest.mapper.OrderPoMapper;
import com.j2ee.mytest.model.bo.Order;
import com.j2ee.mytest.model.po.OrderPo;
import com.j2ee.mytest.util.ResponseCode;
import com.j2ee.mytest.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class OrderDao {
    @Autowired
    private OrderPoMapper orderPoMapper;

    @Autowired
    private OrderDao orderDao;



    /**
     * 修改订单
     * @param order
     * @return ReturnObject<Order>
     */
    public ReturnObject<Order> updateOrder(Order order){
        OrderPo orderPo = order.getOrderPo();
        ReturnObject<Order> retObj = null;
        try {
            int ret = orderPoMapper.updateByPrimaryKeySelective(orderPo);
            if (ret == 0) {
                //修改失败
                retObj = new ReturnObject<>(ResponseCode.RESOURCE_ID_NOTEXIST, String.format("订单id不存在：" + orderPo.getId()));
            } else {
                //修改成功
                retObj = new ReturnObject<>();
            }
        }
        catch (Exception e) {
            //错误
            retObj = new ReturnObject<>(ResponseCode.INTERNAL_SERVER_ERR, String.format("发生了错误：%s", e.getMessage()));
        }
        return retObj;
    }




}
