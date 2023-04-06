package com.oysen.internalcommon.constant;

public class DriverCarConstants {
    /**
     * 司机车辆状态绑定
     */
    public static int DRIVER_CAR_BIND = 1;

    /**
     * 司机车辆状态解绑
     */
    public static int DRIVER_CAR_UNBIND = 2;

    /**
     * 司机状态有效
     */
    public static int DRIVER_STATE_VALID = 1;

    /**
     * 司机状态无效
     */
    public static int DRIVER_STATE_INVALID = 0;

    /**
     * 司机存在
     */
    public static int DRIVER_EXISTS = 1;

    /**
     * 司机不存在
     */
    public static int DRIVER_NOT_EXISTS = 0;

    /**
     * 司机工作状态：0：暂停 1：收车 2：暂停
     */
    public static int DRIVER_WORK_STATUS_STOP = 0;
    public static int DRIVER_WORK_STATUS_START = 1;
    public static int DRIVER_WORK_STATUS_SUSPEND = 2;
}
