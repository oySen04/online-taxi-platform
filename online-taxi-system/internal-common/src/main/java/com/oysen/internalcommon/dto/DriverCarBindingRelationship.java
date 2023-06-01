package com.oysen.internalcommon.dto;

//import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author yang
 * @since 2023-03-11
 */
@Data
//@TableName("driver_car_binding_relationship")
public class DriverCarBindingRelationship implements Serializable {

    //private static final long serialVersionUID = 1L;

    private Long id;

    private Long driverId;

    private Long carId;

    private Integer bindState;

    private LocalDateTime bindingTime;

    private LocalDateTime unBindingTime;

}
