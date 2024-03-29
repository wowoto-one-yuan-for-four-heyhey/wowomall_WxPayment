package com.xmu.wowoto.wxpayment.controller.vo;

import java.math.BigDecimal;



/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/20 19:41
 */
public class WxPaymentVo {
    private BigDecimal actualPrice;

    private Integer orderId;

    /**************************************
     * 生成代码
     **************************************/
    @Override
    public String toString() {
        return "WxPaymentVo{" +
                "actualPrice=" + actualPrice +
                ", orderId=" + orderId +
                '}';
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }
}
