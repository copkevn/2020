package com.turbo.springcloud.controller;

import com.turbo.springcloud.entities.CommonResult;
import com.turbo.springcloud.entities.Payment;
import com.turbo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PaymentController
 * @Author: HeYong
 * @Date: 2020/8/20 16:40
 * @Description:
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/creat")
    public CommonResult creat(@RequestBody Payment payment){
        int result= paymentService.add(payment);
        log.info("【creat】 结果:{}",result);
        if (result>0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,result);
        }
        return new CommonResult(500,"插入数据失败",null);
    }

    @GetMapping("/getById/{id}")
    public CommonResult getById(@PathVariable("id") Long id){
        Payment payment =paymentService.getPayment(id);
        if (null!=payment){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }else{
            return new CommonResult(500,"没有对应记录,查询id:"+id,null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String i:services) {
            log.info("============================ : "+i);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance ins :
                instances) {
            log.info("=-==================  : "+ins.getServiceId()+ins.getHost()+ins.getPort()+ins.getUri());
        }
        return this.discoveryClient;
    }
}

