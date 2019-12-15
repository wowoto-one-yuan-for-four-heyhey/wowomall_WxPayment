package com.xmu.wowoto.wxpayment.service.impl;

import com.xmu.wowoto.wxpayment.domain.WxPayment;
import com.xmu.wowoto.wxpayment.service.WxPaymentService;
import com.xmu.wowoto.wxpayment.util.PrepayIdUtil;
import org.springframework.stereotype.Service;

/**
 *
*@author MedalWill
*@date 2019/12/15 16:41
*
*/
@Service
public class WxPaymentServiceImpl implements WxPaymentService {

    @Override
    public WxPayment addWxPayment(WxPayment wxPayment) {

        String prepayId;
        prepayId = PrepayIdUtil.encodePrepayId(wxPayment);
        wxPayment.setPrepayId(prepayId);

        return wxPayment;
    }

}
