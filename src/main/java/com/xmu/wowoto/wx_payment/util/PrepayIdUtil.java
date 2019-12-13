package com.xmu.wowoto.wx_payment.util;

import com.xmu.wowoto.wx_payment.domain.WxPayment;

public class PrepayIdUtil {

    static public String encodePrepayId(WxPayment wxPayment){
        return wxPayment.getPayment().getId().toString();
    }

}
