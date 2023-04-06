package com.oysen.internalcommon.constant;


public class OrderConstants {
    //无效订单
    public static final int ORDER_INVALID = 0;
    //订单开始
    public static final int ORDER_START = 1;
    //司机接单
    public static final int DRIVER_RECEIVE_ORDER = 2;
    //接客
    public static final int DRIVER_TO_PICK_UP_PASSENGER = 3;
    //到达乘客上车点
    public static final int DRIVER_ARRIVED_DEPARTURE = 4;
    //乘客上车，行程开始
    public static final int PICK_UP_PASSENGER = 5;
    //到达目的地，行程结束，未支付
    public static final int PASSENGER_GETOFF = 6;
    //发起收款
    public static final int TO_START_PAY = 7;
    //支付完成
    public static final int SUCCESS_PAY = 8;
    //订单取消
    public static final int ORDER_CANCEL = 9;

    //订单取消

    /**
     * 乘客提前取消
     */
    public static final int CANCEL_PASSENGER_BEFORE = 1;

    /**
     * 驾驶员提前取消
     */
    public static final int CANCEL_DRIVER_BEFORE = 2;

    /**
     * 平台公司撤销
     */
    public static final int CANCEL_PLATFORM_BEFORE = 3;

    /**
     * 乘客违约取消
     */
    public static final int CANCEL_PASSENGER_ILLEGAL = 4;

    /**
     * 驾驶员违约取消
     */
    public static final int CANCEL_DRIVER_ILLEGAL = 5;


}