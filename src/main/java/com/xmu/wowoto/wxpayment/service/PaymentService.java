package com.xmu.wowoto.wxpayment.service;

import com.xmu.wowoto.wxpayment.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("paymentService")
public interface PaymentService {

    /**
     * （模拟的）微信后台调用此方法修改订单状态
     * 此方法还会调用order模块的updateOrder方法，修改订单状态
     *
     * @param prepay_id：预支付订单号
     * @return Payment
     */
    @PutMapping("payment/{id}/status")
    Payment updatePayment(@PathVariable("id") String prepay_id, @RequestParam boolean successfulPayment,@RequestParam String operationType);

}
