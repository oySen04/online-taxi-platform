package com.oysen.internalcommon.dto;

//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    //@TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 车辆所在城市
     */
    private String address;

    /**
     * 车辆号牌
     */
    private String vehicleNo;

    /**
     * 车牌颜色（1：蓝色，2：黄色，3：黑色，4：白色，5：绿色，9：其他）
     */
    private String plateColor;

    /**
     * 核定载客位
     */
    private Integer seats;

    /**
     * 车辆厂牌
     */
    private String brand;

    /**
     * 车辆型号
     */
    private String model;

    /**
     * 车辆类型
     */
    private String vehicleType;

    /**
     * 车辆所有人
     */
    private String ownerName;

    /**
     * 车辆颜色（1：白色，2：黑色）
     */
    private String vehicleColor;

    /**
     * 发动机号
     */
    private String engineId;

    private String vin;

    /**
     * 车辆注册日期
     */
    private LocalDate certifyDateA;

    /**
     * 燃料类型(1：汽油，2：柴油，3：天然气，4：液化气，5：电动，9：其他）
     */
    private String fueType;

    /**
     * 发动机排量（毫升）
     */
    private String engineDisplace;

    /**
     * 车辆运输证发证机构
     */
    private String transAgency;

    /**
     * 车辆经验区域
     */
    private String transArea;

    /**
     * 车辆运输证有效期起
     */
    private LocalDate transDateStart;

    /**
     * 车辆运输证有效期止
     */
    private LocalDate transDateEnd;

    /**
     * 车辆初次登记日期
     */
    private LocalDate certifyDateB;

    /**
     * 车辆的检修状态(0：未检修，1：已检修，2：未知）
     */
    private String fixState;

    /**
     * 下次年检时间
     */
    private LocalDate nextFixDate;

    /**
     * 年度审验状态（0：未年审，1：年审合格，2：年审不合格）
     */
    private String checkState;

    /**
     * 发票打印设备序列号
     */
    private String feePrintId;

    /**
     * 卫星定位装置品牌
     */
    private String gpsBrand;

    /**
     * 卫星型号
     */
    private String gpsModel;

    /**
     * 卫星定位设备安装日期
     */
    private LocalDate gpsInstallDate;

    /**
     * 报备日期
     */
    private LocalDate registerDate;

    /**
     * 服务类型：1：网络预约出租车，2：巡游出租车，3：私人小客车合乘
     */
    private Integer commercialType;

    /**
     * 运价编码 关联计价规则
     */
    private String fareType;

    /**
     * 状态：0:有效，1：失效
     */
    //private Boolean state;
    private Integer state;

    /**
     * 终端Id
     */
    private String tid;

    /**
     * 轨迹ID
     */
    private String trid;

    /**
     * 轨迹名称
     */
    private String trname;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModified;

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
    public String getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(String plateColor) {
        this.plateColor = plateColor;
    }
    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }
    public String getEngineId() {
        return engineId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
    public LocalDate getCertifyDateA() {
        return certifyDateA;
    }

    public void setCertifyDateA(LocalDate certifyDateA) {
        this.certifyDateA = certifyDateA;
    }
    public String getFueType() {
        return fueType;
    }

    public void setFueType(String fueType) {
        this.fueType = fueType;
    }
    public String getEngineDisplace() {
        return engineDisplace;
    }

    public void setEngineDisplace(String engineDisplace) {
        this.engineDisplace = engineDisplace;
    }
    public String getTransAgency() {
        return transAgency;
    }

    public void setTransAgency(String transAgency) {
        this.transAgency = transAgency;
    }
    public String getTransArea() {
        return transArea;
    }

    public void setTransArea(String transArea) {
        this.transArea = transArea;
    }
    public LocalDate getTransDateStart() {
        return transDateStart;
    }

    public void setTransDateStart(LocalDate transDateStart) {
        this.transDateStart = transDateStart;
    }
    public LocalDate getTransDateEnd() {
        return transDateEnd;
    }

    public void setTransDateEnd(LocalDate transDateEnd) {
        this.transDateEnd = transDateEnd;
    }
    public LocalDate getCertifyDateB() {
        return certifyDateB;
    }

    public void setCertifyDateB(LocalDate certifyDateB) {
        this.certifyDateB = certifyDateB;
    }
    public String getFixState() {
        return fixState;
    }

    public void setFixState(String fixState) {
        this.fixState = fixState;
    }
    public LocalDate getNextFixDate() {
        return nextFixDate;
    }

    public void setNextFixDate(LocalDate nextFixDate) {
        this.nextFixDate = nextFixDate;
    }
    public String getCheckState() {
        return checkState;
    }

    public void setCheckState(String checkState) {
        this.checkState = checkState;
    }
    public String getFeePrintId() {
        return feePrintId;
    }

    public void setFeePrintId(String feePrintId) {
        this.feePrintId = feePrintId;
    }
    public String getGpsBrand() {
        return gpsBrand;
    }

    public void setGpsBrand(String gpsBrand) {
        this.gpsBrand = gpsBrand;
    }
    public String getGpsModel() {
        return gpsModel;
    }

    public void setGpsModel(String gpsModel) {
        this.gpsModel = gpsModel;
    }
    public LocalDate getGpsInstallDate() {
        return gpsInstallDate;
    }

    public void setGpsInstallDate(LocalDate gpsInstallDate) {
        this.gpsInstallDate = gpsInstallDate;
    }
    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }
    public Integer getCommercialType() {
        return commercialType;
    }

    public void setCommercialType(Integer commercialType) {
        this.commercialType = commercialType;
    }
    public String getFareType() {
        return fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
    public String getTrid() {
        return trid;
    }

    public void setTrid(String trid) {
        this.trid = trid;
    }
    public String getTrname() {
        return trname;
    }

    public void setTrname(String trname) {
        this.trname = trname;
    }
    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "Car{" +
            "id=" + id +
            ", address=" + address +
            ", vehicleNo=" + vehicleNo +
            ", plateColor=" + plateColor +
            ", seats=" + seats +
            ", brand=" + brand +
            ", model=" + model +
            ", vehicleType=" + vehicleType +
            ", ownerName=" + ownerName +
            ", vehicleColor=" + vehicleColor +
            ", engineId=" + engineId +
            ", vin=" + vin +
            ", certifyDateA=" + certifyDateA +
            ", fueType=" + fueType +
            ", engineDisplace=" + engineDisplace +
            ", transAgency=" + transAgency +
            ", transArea=" + transArea +
            ", transDateStart=" + transDateStart +
            ", transDateEnd=" + transDateEnd +
            ", certifyDateB=" + certifyDateB +
            ", fixState=" + fixState +
            ", nextFixDate=" + nextFixDate +
            ", checkState=" + checkState +
            ", feePrintId=" + feePrintId +
            ", gpsBrand=" + gpsBrand +
            ", gpsModel=" + gpsModel +
            ", gpsInstallDate=" + gpsInstallDate +
            ", registerDate=" + registerDate +
            ", commercialType=" + commercialType +
            ", fareType=" + fareType +
            ", state=" + state +
            ", tid=" + tid +
            ", trid=" + trid +
            ", trname=" + trname +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
        "}";
    }*/
}
