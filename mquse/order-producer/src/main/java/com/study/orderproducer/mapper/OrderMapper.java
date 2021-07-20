package com.study.orderproducer.mapper;

import com.study.orderproducer.model.OrderEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderMapper {

    @Insert(value = "INSERT INTO `order_test` VALUES (#{id}, " +
            "#{name}, #{orderCreatetime}, #{orderMoney}, #{orderState}, #{commodityId},#{orderId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int addOrder(OrderEntity orderEntity);


    @Select("SELECT * from order_test where order_id=#{orderId};")
    public OrderEntity findOrderId(@Param("orderId") String orderId);

}
