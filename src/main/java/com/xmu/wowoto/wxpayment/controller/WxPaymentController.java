package com.xmu.wowoto.wxpayment.controller;

import com.xmu.wowoto.wxpayment.domain.Payment;
import com.xmu.wowoto.wxpayment.domain.WxPayment;
import com.xmu.wowoto.wxpayment.service.WxPaymentService;
import com.xmu.wowoto.wxpayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("wxPaymentService")
public class WxPaymentController {

    @Autowired
    WxPaymentService wxPaymentService;

    @Autowired
    PaymentService paymentService;

    /**
     * 支付模块调用此方法模拟微信统一支付api
     * 此方法应该返回给支付模块prepay_id等信息
     *
     * @param payment
     * @return String
     */
    @PostMapping("wxpayment")
    public String useWxPay(Payment payment){
        // unifiedWxPayment
        WxPayment wxPayment = new WxPayment();
        // prepayId
        wxPayment.setPayment(payment);

        WxPayment wxPaymentWithPrepayId;
        wxPaymentWithPrepayId = wxPaymentService.addWxPayment(wxPayment);

        return wxPaymentWithPrepayId.getPrepayId();
    }

    /**
     * 用户发起最终支付
     * 此方法将调用Payment模块的updatePayment方法修改支付状态等信息
     * updatePayment方法进而调用Order模块的updateOrder方法修改订单状态等信息
     * 同时，调用此方法后，前端应显示当前（支付状态），商品，商品全称，支付时间，支付方式，交易单号，商户单号等信息给用户
     *
     * @param prepay_id
     * @return updateWxPaymentVo
     */
    @PutMapping("wxpayment/{id}")
    public Object requestWxPayment(@PathVariable("id") String prepay_id, LocalDateTime endTime){
        // 判断支付是否超时
            // 获取当前时间
        LocalDateTime currentTime;
        currentTime = LocalDateTime.now();
        boolean successfulPayment;
        if(!currentTime.isBefore(endTime)){
            // 本次支付失效
            successfulPayment = false;
        }
        else{    // 如果不超时
            // 本次支付成功
            // TODO: 扣款（假装有扣款orz）
            successfulPayment = true;
        }
        WxPayment wxPayment = new WxPayment();
        Payment payment;
        payment = paymentService.updatePayment(prepay_id, successfulPayment);
        wxPayment.setPrepayId(payment.getPaySn());
        wxPayment.setPayment(payment);

        return wxPayment;
    }

}
