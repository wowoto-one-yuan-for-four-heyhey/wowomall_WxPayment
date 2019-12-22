package com.xmu.wowoto.wxpayment.service;

import com.xmu.wowoto.wxpayment.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/20 19:41
 */
@Service
@FeignClient("paymentService")
public interface RemotePaymentService {

    /**
     * （模拟的）微信后台调用此方法修改订单状态
     * 此方法还会调用order模块的updateOrder方法，修改订单状态
     *
     * @param prepayId：预支付订单号
     * @param successfulPayment
     * @param operationType
     * @return Payment
     */
    @PutMapping("payment/{id}/status")
    String updatePayment(@PathVariable("id") String prepayId, @RequestParam boolean successfulPayment, @RequestParam String operationType);

}
