package yuansim.payment.impl;

import org.springframework.stereotype.Component;
import yuansim.constant.PayConstant;
import yuansim.payment.Pay;


/**
 * @QQ交流群: 648741281
 * @Email: 177300883312@163.com
 * @微信: londu19930418
 * @Author: Simon.Mr
 * @Created 2019/12/31
 */
public class AliPay implements Pay {


    @Override
    public String call() {
        System.out.println("调用支付宝");
        return "ali";
    }

    @Override
    public String getType() {
        return PayConstant.ali_pay.name();
    }
}
