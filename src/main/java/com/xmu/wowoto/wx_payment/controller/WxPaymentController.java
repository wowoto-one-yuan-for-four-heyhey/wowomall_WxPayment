package com.xmu.wowoto.wx_payment.controller;

import com.xmu.wowoto.wx_payment.controller.vo.WxPaymentVo;
import com.xmu.wowoto.wx_payment.domain.Payment;
import com.xmu.wowoto.wx_payment.domain.WxPayment;
import com.xmu.wowoto.wx_payment.service.WxPaymentService;
import com.xmu.wowoto.wx_payment.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wxPaymentService")
public class WxPaymentController {

    @Autowired
    WxPaymentService wxPaymentService;


    /**
     * 支付模块调用此方法模拟微信统一支付api
     * 此方法应该返回给支付模块prepay_id等信息
     *
     * @param payment
     * @return String
     */
    @PostMapping("wxpayment")
    public String useWxPay(Payment payment){
        // unifiedWxPayment
        WxPayment wxPayment = new WxPayment();
        // prepayId
        wxPayment.setPayment(payment);

        WxPayment wxPaymentWithPrepayId;
        wxPaymentWithPrepayId = wxPaymentService.addWxPayment(wxPayment);

        return wxPaymentWithPrepayId.getPrepayId();
    }


    /**
     * 用户发起最终支付
     * 此方法将调用Payment模块的updatePayment方法修改支付状态等信息
     * updatePayment方法进而调用Order模块的updateOrder方法修改订单状态等信息
     * 同时，调用此方法后，前端应显示当前（支付状态），商品，商品全称，支付时间，支付方式，交易单号，商户单号等信息给用户
     *
     * @param prepay_id
     * @return updateWxPaymentVo
     */
    @PutMapping("wxpayment/{id}")
    public Object requestWxPayment(@PathVariable("id") Integer prepay_id){}
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
