package com.turbo.springcloud.service;

import com.turbo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @ClassName: PaymentService
 * @Author: HeYong
 * @Date: 2020/8/20 16:36
 * @Description: TODO Description
 * @Version: 1.0
 */
public interface PaymentService {
    int add(Payment payment);
    Payment getPayment(@Param("id") Long id);
}

