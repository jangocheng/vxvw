package com.snax.vxvw.vxvwdb.util;

import com.snax.vxvw.vxvwdb.domain.LitemallOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 订单流程：下单成功-》支付订单-》发货-》收货
 * 订单状态
 * 101 订单生成，未支付；102，下单未支付用户取消；103，下单未支付，等待超时，系统自动取消
 * 201，支付成功，商家未发货；202，订单生产，已付款未发货，用户申请退款；203，管理员执行退款操作，确认退款成功
 * 301 商家发货，未到达，302商家发货，已到达，用户未收货
 * 401 用户确认收货，订单结束，402 用户没有确认收货，但是快递反馈，超过一段时间，系统自动确认收货，订单结束
 *
 * 当101用户未付款时，此时用户可以进行的操作是取消或者付款
 *  * 当201支付完成而商家未发货时，此时用户可以退款
 *  * 当301商家已发货时，此时用户可以有确认收货
 *  * 当401用户确认收货以后，此时用户可以进行的操作是退货、删除、去评价或者再次购买
 *  * 当402系统自动确认收货以后，此时用户可以删除、去评价、或者再次购买
 */
public class OrderUtil {

    public static final Short STATUS_CREATE = 101;
    public static final Short STATUS_PAY = 201;
    public static final Short STATUS_SHIP = 301;
    public static final Short STATUS_ARRIVED=302;
    public static final Short STATUS_CONFIRM = 401;
    public static final Short STATUS_CANCEL = 102;
    public static final Short STATUS_AUTO_CANCEL = 103;
    public static final Short STATUS_REFUND = 202;
    public static final Short STATUS_REFUND_CONFIRM = 203;
    public static final Short STATUS_AUTO_CONFIRM = 402;

    public static String orderStatusOption(LitemallOrder order){
        int status=order.getOrderStatus().intValue();

        switch (status){
            case 101:return "未付款";
            case 102:return "已取消";
            case 103:return "订单超时，自动取消";
            case 201:return "已付款";
            case 202:return "退款中";
            case 203:return "已退款";
            case 301:return "已发货";
            case 302:return "已到达";
            case 401:return "已收货";
            case 402:return "已收货(系统)";
            default:throw new IllegalStateException("orderStatus不支持");
        }
    }

    public static List<OrderHandleOption> build(LitemallOrder order){
        int status=order.getOrderStatus().intValue();
        List<OrderHandleOption> options=new LinkedList<>();
        switch (status){
            case 101:{
                options.add(OrderHandleOption.CANCEL);
                options.add(OrderHandleOption.PAY);
                break;
            }
            case 102:{
                options.add(OrderHandleOption.DELETE);
                break;
            }
            case 103:case 202: case 302:{
                break;
            }
            case 201:{
                options.add(OrderHandleOption.REFUND);
                break;
            }
            case 203:{
                options.add(OrderHandleOption.DELETE);
                break;
            }
            case 301:{
                options.add(OrderHandleOption.CONFIRM);
                break;
            }
            case 401: case 402:{
                options.add(OrderHandleOption.DELETE);
                options.add(OrderHandleOption.COMMENT);
                options.add(OrderHandleOption.REBUY);
                break;
            }
            default:throw new IllegalStateException("status不支持");

        }
        return options;
    }

    public static List<Short> orderStatus(Integer showType){
        // 全部订单
        if (showType == 0) {
            return null;
        }

        List<Short> status = new ArrayList<Short>(2);

        if (showType.equals(1)) {
            // 待付款订单
            status.add((short)101);
        }
        else if (showType.equals(2)) {
            // 待发货订单
            status.add((short)201);
        }
        else if (showType.equals(3)) {
            // 待收货订单
            status.add((short)301);
        }
        else if (showType.equals(4)) {
            // 待评价订单
            status.add((short)401);
        }
        else {
            return null;
        }

        return status;
    }

    public static boolean isCreateStatus(LitemallOrder litemallOrder) {
        return OrderUtil.STATUS_CREATE == litemallOrder.getOrderStatus().shortValue();
    }

    public static boolean isPayStatus(LitemallOrder litemallOrder) {
        return OrderUtil.STATUS_PAY == litemallOrder.getOrderStatus().shortValue();
    }

    public static boolean isShipStatus(LitemallOrder litemallOrder) {
        return OrderUtil.STATUS_SHIP == litemallOrder.getOrderStatus().shortValue();
    }

    public static boolean isConfirmStatus(LitemallOrder litemallOrder) {
        return OrderUtil.STATUS_CONFIRM == litemallOrder.getOrderStatus().shortValue();
    }

    public static boolean isCancelStatus(LitemallOrder litemallOrder) {
        return OrderUtil.STATUS_CANCEL == litemallOrder.getOrderStatus().shortValue();
    }

    public static boolean isAutoCancelStatus(LitemallOrder litemallOrder) {
        return OrderUtil.STATUS_AUTO_CANCEL == litemallOrder.getOrderStatus().shortValue();
    }

    public static boolean isRefundStatus(LitemallOrder litemallOrder) {
        return OrderUtil.STATUS_REFUND == litemallOrder.getOrderStatus().shortValue();
    }

    public static boolean isRefundConfirmStatus(LitemallOrder litemallOrder) {
        return OrderUtil.STATUS_REFUND_CONFIRM == litemallOrder.getOrderStatus().shortValue();
    }

    public static boolean isAutoConfirmStatus(LitemallOrder litemallOrder) {
        return OrderUtil.STATUS_AUTO_CONFIRM == litemallOrder.getOrderStatus().shortValue();
    }
}
