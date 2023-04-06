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

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
    public Integer getBindState() {
        return bindState;
    }

    public void setBindState(Integer bindState) {
        this.bindState = bindState;
    }
    public LocalDateTime getBindingTime() {
        return bindingTime;
    }

    public void setBindingTime(LocalDateTime bindingTime) {
        this.bindingTime = bindingTime;
    }
    public LocalDateTime getUnBindingTime() {
        return unBindingTime;
    }

    public void setUnBindingTime(LocalDateTime unBindingTime) {
        this.unBindingTime = unBindingTime;
    }

    @Override
    public String toString() {
        return "DriverCarBindingRelationship{" +
            "id=" + id +
            ", driverId=" + driverId +
            ", carId=" + carId +
            ", bindState=" + bindState +
            ", bindingTime=" + bindingTime +
            ", unBindingTime=" + unBindingTime +
        "}";
    }*/
}
