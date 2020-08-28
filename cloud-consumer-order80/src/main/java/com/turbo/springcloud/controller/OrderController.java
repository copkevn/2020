package com.turbo.springcloud.controller;

import com.turbo.springcloud.entities.CommonResult;
import com.turbo.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName: OrderController
 * @Author: HeYong
 * @Date: 2020/8/28 14:43
 * @Description: TODO Description
 * @Version: 1.0
 */
@RequestMapping("/consumer")
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL="http://localhost:8001/payment";

//    httpclient   服务之间的调用
//    restTemplate
//    RPC

//    注解的方式，注入restTemplate
    @Resource
    private RestTemplate restTemplate;



//    public CommonResult<Payment> getById(Long id){
//        return restTemplate.getForObject(PAYMENT_URL,id,CommonResult.class);
//    }


    @GetMapping("/creat")
    public CommonResult<Payment> creat(Payment payment){
        log.info("进来了》》》》》》》》》》》》》");
        return restTemplate.postForObject(PAYMENT_URL+"/creat",payment,CommonResult.class);
    }

    @GetMapping("/getById/{id}")
    public CommonResult<Payment> getPayMent(@PathVariable("id") Long id){
        log.info("进来查询》》》》》》》》》》》》》》");
        return restTemplate.getForObject(PAYMENT_URL+"/getById/"+id,CommonResult.class);
    }

}

