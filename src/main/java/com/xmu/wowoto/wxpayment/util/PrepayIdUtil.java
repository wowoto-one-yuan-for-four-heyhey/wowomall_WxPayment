package com.xmu.wowoto.wxpayment.util;

import com.xmu.wowoto.wxpayment.domain.WxPayment;

public class PrepayIdUtil {

    static public String encodePrepayId(WxPayment wxPayment){
        return wxPayment.getPayment().getId().toString();
    }

}
