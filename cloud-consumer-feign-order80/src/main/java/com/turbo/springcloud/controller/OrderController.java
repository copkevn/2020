package com.turbo.springcloud.controller;

import com.turbo.springcloud.entities.CommonResult;
import com.turbo.springcloud.entities.Payment;
import com.turbo.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: OrderController
 * @Author: HeYong
 * @Date: 2020/9/1 17:09
 * @Description: TODO Description
 * @Version: 1.0
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPayment(id);
    }
}

