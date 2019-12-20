package com.xmu.wowoto.wxpayment.controller;

import com.xmu.wowoto.wxpayment.domain.Payment;
import com.xmu.wowoto.wxpayment.domain.WxPayment;
import com.xmu.wowoto.wxpayment.service.WxPaymentService;
import com.xmu.wowoto.wxpayment.service.PaymentService;
import com.xmu.wowoto.wxpayment.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("")
public class WxPaymentController {

    @Autowired
    WxPaymentService wxPaymentService;

    @Autowired
    PaymentService paymentService;

    /**
     * 支付模块调用此方法模拟微信统一支付api
     * 此方法应该返回给支付模块prepay_id等信息
     *
     * @param payment 支付domain类实例
     * @return String
     */
    @PostMapping("wxpayment")
    public Object useWxPay(Payment payment){
        // unifiedWxPayment
        WxPayment wxPayment = new WxPayment();
        // prepayId
        wxPayment.setPayment(payment);

        WxPayment wxPaymentWithPrepayId;
        wxPaymentWithPrepayId = wxPaymentService.addWxPayment(wxPayment);

        return ResponseUtil.ok(wxPaymentWithPrepayId.getPrepayId());
    }

    /**
     * 用户发起最终支付
     * 此方法将调用Payment模块的updatePayment方法修改支付状态等信息
     * updatePayment方法进而调用Order模块的updateOrder方法修改订单状态等信息
     * 同时，调用此方法后，前端应显示当前（支付状态），商品，商品全称，支付时间，支付方式，交易单号，商户单号等信息给用户
     *
     * @param prepay_id 预支付标识
     * @return WxPayment
     */
    @PutMapping("wxpayment/{id}")
    public Object requestWxPayment(@PathVariable("id") String prepay_id){
        boolean successfulPayment;
        successfulPayment = true;
        WxPayment wxPayment = new WxPayment();
        Payment payment;
        payment = paymentService.updatePayment(prepay_id, successfulPayment, "pay");
        wxPayment.setPrepayId(payment.getPaySn());
        wxPayment.setPayment(payment);

        return wxPayment;
    }

    /**
     * 退款
     * 当传入payment模块addPayment方法的参数payment的actualPrice属性为负时，addPayment代表退款操作
     * 此时，addPayment方法调用wxPayment模块的refund方法，传入paySn和actualPrice（退款金额）执行退款操作
     * 该方法与requestWxPayment类似，应调用updatePayment方法，进而调用updateOrder方法，修改相应的（多个）表状态
     *
     * @param refundWhom 支付时的paySn
     * @param refundPaymentPaySn 退款时的paySn
     * @param actualPrice 退款金额
     * @return
     */
    @PutMapping("wxpayment/{id}/refund")
    public Object refund(@PathVariable("id") String refundWhom, String refundPaymentPaySn, BigDecimal actualPrice){
        // TODO 将退款金额退给相应用户，并根据refundWhom查找wxpayment表的对应记录，修改其状态（假装有表），返回的记录的id，存储在retWxPaymentId中
        // TODO 判断retWxPaymentId合理性后，根据retWxPaymentId查找对应记录，返回的WxPayment实例存储在retWxPayment中

        WxPayment retWxPayment = new WxPayment();

        Payment payment = paymentService.updatePayment(refundPaymentPaySn, true, "refund");

        return retWxPayment;
    }

}
