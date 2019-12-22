package com.xmu.wowoto.wxpayment.service.impl;

import com.xmu.wowoto.wxpayment.domain.Payment;
import com.xmu.wowoto.wxpayment.service.PaymentService;
import com.xmu.wowoto.wxpayment.service.RemotePaymentService;
import com.xmu.wowoto.wxpayment.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Tens
 * @Description:
 * @Date: 2019/12/20 19:42
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    RemotePaymentService remotePaymentService;

    @Override
    public Payment updatePayment(String prepayId, boolean successfulPayment, String operationType) {
        String json = remotePaymentService.updatePayment(prepayId, successfulPayment, operationType);
        return JacksonUtil.parseObject(json, "data", Payment.class);
    }
}
