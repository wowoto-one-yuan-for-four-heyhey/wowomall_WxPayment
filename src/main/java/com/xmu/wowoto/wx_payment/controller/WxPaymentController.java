package com.xmu.wowoto.wx_payment.controller;

import com.xmu.wowoto.wx_payment.controller.vo.WxPaymentVo;
import com.xmu.wowoto.wx_payment.util.ResponseUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class WxPaymentController {

    @PostMapping("wxPayment")
    public String addWxPayment(WxPaymentVo wxPaymentVo){
        Integer orderId=wxPaymentVo.getOrderId();
        String msg=wxPaymentVo.getActualPrice().toString();
        System.out.println("微信收款"+msg+"元");
        String ret="wx"+orderId.toString();
        return ret;
    }

    @PutMapping("wxPayment")
    public Object doPayment(String prePayId){
        if(prePayId==null){
            return ResponseUtil.fail(402,"bad params!");
        }
        else{
        //@TODO 向payment发出修改请求
        return ResponseUtil.ok();
        }
    }
}
