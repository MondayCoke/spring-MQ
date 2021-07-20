package com.study.delay.mapper;

import com.study.delay.model.OrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderMapper {
    @Insert("insert into order_info values (null,#{orderName},#{orderId} ,#{orderStatus})")
    int addOrder(OrderEntity orderEntity);

    @Select("SELECT * from order_info where order_id=#{orderId}")
    OrderEntity getOrder(String orderId);

    @Update("update order_info set order_status=#{orderStatus} where order_id=#{orderId}")
    Integer updateStatus(String orderId, Integer orderStatus);
}
