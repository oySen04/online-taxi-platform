package com.oysen.servicedriveruser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oysen.internalcommon.dto.Car;
import com.oysen.internalcommon.dto.ResponseResult;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yang
 * @since 2022-08-21
 */
@Repository
public interface CarMapper extends BaseMapper<Car> {
}
