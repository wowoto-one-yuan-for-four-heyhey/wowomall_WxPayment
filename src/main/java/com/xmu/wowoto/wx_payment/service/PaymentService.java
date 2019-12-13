package com.xmu.wowoto.wx_payment.service;

import com.xmu.wowoto.wx_payment.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("wowoto-payment")
public interface PaymentService {

    /**
     * （模拟的）微信后台调用此方法修改订单状态
     * 此方法还会调用order模块的updateOrder方法，修改订单状态
     *
     * @param prepay_id：预支付订单号
     * @return Payment
     */
    @PutMapping("payment/{id}")
    public Payment updatePayment(@PathVariable("id") String prepay_id, Integer payChannel, boolean successfulPayment);

}
