package com.xmu.wowoto.wxpayment.service;

import com.xmu.wowoto.wxpayment.domain.WxPayment;

/**
 *
*@author MedalWill
*@date 2019/12/15 16:40
*
*/
public interface WxPaymentService {

    /**
     * （模拟的）微信后台调用此方法修改订单状态
     * 此方法还会调用order模块的updateOrder方法，修改订单状态
     * @param wxPayment
     * @return Payment
     */
    WxPayment addWxPayment(WxPayment wxPayment);

}
