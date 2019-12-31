package yuansim.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yuansim.SpringUtils;
import yuansim.dao.mapper.PaymentChannelMapper;
import yuansim.dao.dto.PaymentChannel;
import yuansim.payment.Pay;
import yuansim.view.BaseResource;
import yuansim.view.controller.BaseRestController;
import yuansim.view.exception.DataException;
import yuansim.view.exception.ViewParamException;

/**
 * @QQ交流群: 648741281
 * @Email: 177300883312@163.com
 * @微信: londu19930418
 * @Author: Simon.Mr
 * @Created 2019/12/31
 */
@RestController
public class DemoController extends BaseRestController {

    @Autowired
    private PaymentChannelMapper paymentChannelMapper;


    @PostMapping(value = "/strategy/normal/pay")
    public BaseResource pay(@RequestParam String code) {

        if(StringUtils.isEmpty(code)) {

            throw new ViewParamException();
        }

        PaymentChannel paymentChannel = paymentChannelMapper.getPaymentChannel(code);

        if(null == paymentChannel) {

            throw new DataException();
        }

        String strategyBeanId = paymentChannel.getStrategyBeanId();
        if(StringUtils.isEmpty(strategyBeanId)) {

            throw new DataException("beanId不存在");
        }

        Pay pay = SpringUtils.getBean(strategyBeanId, Pay.class);

        String call = pay.call();

        return BaseResource.fromSuccess(call);

    }



}
