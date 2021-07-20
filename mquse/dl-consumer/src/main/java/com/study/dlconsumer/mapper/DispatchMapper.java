package com.study.dlconsumer.mapper;

import com.study.dlconsumer.model.DispatchEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DispatchMapper {

    /**
     * 新增派单任务
     */
    @Insert("INSERT into platoon values (null,#{orderId},#{userId});")
    int insertDistribute(DispatchEntity distributeEntity);

}
