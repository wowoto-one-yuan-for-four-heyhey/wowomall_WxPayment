package com.xmu.wowoto.wxpayment.domain;



/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/20 19:41
 */
public class WxPayment {

    private String prepayId;
    private Payment payment;

    public String getPrepayId() {
        return this.prepayId;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(final Object o) {
       return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof WxPayment;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "WxPayment(prepayId=" + this.getPrepayId() + ", payment=" + this.getPayment() + ")";
    }
}
