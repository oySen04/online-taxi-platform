package com.oysen.servicedriveruser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oysen.internalcommon.dto.DriverUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverUserMapper extends BaseMapper<DriverUser> {
    //public int select1(String arg);
    public int selectDriverUserCountByCityCode(@Param("cityCode") String cityCode);
}
