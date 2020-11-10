package com.j2ee.mytest.mapper;

import com.j2ee.mytest.model.po.OrderPo;
import com.j2ee.mytest.model.po.OrderPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface OrderPoMapper {
    long countByExample(OrderPoExample example);

    int deleteByExample(OrderPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderPo record);

    int insertSelective(OrderPo record);

    List<OrderPo> selectByExample(OrderPoExample example);

    OrderPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderPo record, @Param("example") OrderPoExample example);

    int updateByExample(@Param("record") OrderPo record, @Param("example") OrderPoExample example);

    int updateByPrimaryKeySelective(OrderPo record);

    int updateByPrimaryKey(OrderPo record);
}