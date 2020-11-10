package com.j2ee.mytest.controller;

import com.j2ee.mytest.J2eeApplication;
import com.j2ee.mytest.dao.OrderDao;
import com.j2ee.mytest.model.bo.Order;
import com.j2ee.mytest.util.ResponseCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = J2eeApplication.class)
@AutoConfigureMockMvc
@Transactional
public class OrderControllerTest {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private MockMvc mvc;

    @Test
    public void findOrderById() throws Exception{
        String requireJson = null;
        String responseString = null;
        ResultActions res = null;

        //正常查询
        requireJson = "{\"id\":\"1\"}";
        res = this.mvc.perform(post("/order/orders/{id}")
                .contentType("application/json;charset=UTF-8")
                .content(requireJson));
        responseString = res.andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.errno").value(ResponseCode.OK.getCode()))
                .andExpect(jsonPath("$.errmsg").value("成功"))
                .andExpect(jsonPath("$.data").isString())
                .andReturn().getResponse().getContentAsString();
        //endregion
    }


}
