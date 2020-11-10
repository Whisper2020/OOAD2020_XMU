package com.j2ee.mytest.controller;

import com.j2ee.mytest.J2eeApplication;
import com.j2ee.mytest.dao.OrderDao;
import com.j2ee.mytest.mapper.OrderPoMapper;
import com.j2ee.mytest.model.bo.Order;
import com.j2ee.mytest.model.po.OrderPo;
import com.j2ee.mytest.util.ResponseCode;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = J2eeApplication.class)
@AutoConfigureMockMvc
@Transactional
public class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    //通过正确id查询订单
    @Test
    public void findOrderById1() throws Exception{

        String responseString = this.mvc.perform(get("/order/orders/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse = "{\"errno\":0,\"data\":{\"id\":1,\"orderSN\":2020-11-10,\"state\":0,\"orderPo\":{\"id\":1,\"orderSN\":\"2020-11-10\",\"state\":0}},\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expectedResponse, responseString, true);

    }

    //通过不正确id查询订单
    @Test
    public void findOrderById2() throws Exception{

        String responseString = this.mvc.perform(get("/order/orders/2"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse = "{\"errno\":504,\"errmsg\":\"订单id不存在：2\"}";
        JSONAssert.assertEquals(expectedResponse, responseString, true);

    }

    //正常更改状态
    @Test
    public void updateOrder1() throws Exception{

        String expectedResponse = "";
        String responseString = null;
        try {
            responseString = this.mvc.perform(put("/order/orders/1").contentType("application/json;charset=UTF-8"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json;charset=UTF-8"))
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        expectedResponse = "{\"errno\":0,\"errmsg\":\"成功\"}";
        try {
            JSONAssert.assertEquals(expectedResponse, responseString, true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //要改状态的订单id不存在
    @Test
    public void updateOrder2() throws Exception{

        String expectedResponse = "";
        String responseString = null;
        try {
            responseString = this.mvc.perform(put("/order/orders/2").contentType("application/json;charset=UTF-8"))
                    .andExpect(status().isNotFound())
                    .andExpect(content().contentType("application/json;charset=UTF-8"))
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        expectedResponse = "{\"errno\":504,\"errmsg\":\"订单id不存在：2\"}";
        try {
            JSONAssert.assertEquals(expectedResponse, responseString, true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
