package com.turbo.springcloud.service;

import com.turbo.springcloud.entities.CommonResult;
import com.turbo.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/getById/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id);
}
