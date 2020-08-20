package com.turbo.springcloud.service.impl;

import com.turbo.springcloud.dao.PaymentDao;
import com.turbo.springcloud.entities.Payment;
import com.turbo.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentServiceImpl
 * @Author: HeYong
 * @Date: 2020/8/20 16:38
 * @Description: TODO Description
 * @Version: 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int add(Payment payment) {
        return paymentDao.addPayment(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentDao.getPayment(id);
    }
}

