package com.j2ee.mytest.model.bo;

import com.j2ee.mytest.model.VoObject;
import com.j2ee.mytest.model.po.OrderPo;
import lombok.Data;

@Data
public class Order{
    private Long id;
    private String orderSN;
    private Integer state;

    public Order(){

    }

    /**
     * 构造函数     *
     * @param po 用PO构造
     * @return Order
     */
    public Order(OrderPo po) {
        this.id = po.getId();
        this.state = po.getState();
        this.orderSN = po.getOrderSN();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderSN() {
        return orderSN;
    }

    public void setOrderSN(String orderSN) {
        this.orderSN = orderSN;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 用bo对象创建用于更新的po对象
     * @return OrderPo
     */
    public OrderPo getOrderPo() {
        OrderPo po = new OrderPo();
        po.setId(this.getId());
        po.setState(this.getState());
        return po;
    }

}
