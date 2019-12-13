package com.xmu.wowoto.wx_payment.service.impl;

import com.xmu.wowoto.wx_payment.domain.Payment;
import com.xmu.wowoto.wx_payment.domain.WxPayment;
import com.xmu.wowoto.wx_payment.service.WxPaymentService;
import com.xmu.wowoto.wx_payment.util.PrepayIdUtil;

public class WxPaymentServiceImpl implements WxPaymentService {

    public WxPayment addWxPayment(WxPayment wxPayment) {

        String prepayId;
        prepayId = PrepayIdUtil.encodePrepayId(wxPayment);
        wxPayment.setPrepayId(prepayId);

        return wxPayment;
    }

}
