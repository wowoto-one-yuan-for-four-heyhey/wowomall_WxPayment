package com.xmu.wowoto.wxpayment.util;

import com.xmu.wowoto.wxpayment.domain.WxPayment;

import java.util.Random;

public class PrepayIdUtil {

    static public String encodePrepayId(WxPayment wxPayment){
        Integer length = 8;
        String lendata = "";
        Random r = new Random();
        for(int i = 0 ;i < length ;i++) {
            lendata += String.valueOf((char)(new Random().nextInt(26)+65));
        }
        return lendata;
    }

}
