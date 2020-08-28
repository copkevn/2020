package com.turbo.springcloud.controller;

import com.turbo.springcloud.entities.CommonResult;
import com.turbo.springcloud.entities.Payment;
import com.turbo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentController
 * @Author: HeYong
 * @Date: 2020/8/20 16:40
 * @Description: TODO Description
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;


    @PostMapping("/creat")
    public CommonResult creat(@RequestBody Payment payment){
        int result= paymentService.add(payment);
        log.info("【creat】 结果:{}",result);
        if (result>0){
            return new CommonResult(200,"插入数据成功",result);
        }
        return new CommonResult(500,"插入数据失败",null);
    }

    @GetMapping("/getById/{id}")
    public CommonResult getById(@PathVariable("id") Long id){
        Payment payment =paymentService.getPayment(id);
        if (null!=payment){
            return new CommonResult(200,"查询成功",payment);
        }else{
            return new CommonResult(500,"没有对应记录,查询id:"+id,null);
        }
    }
}

