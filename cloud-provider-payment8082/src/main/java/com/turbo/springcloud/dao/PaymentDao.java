package com.turbo.springcloud.dao;

import com.turbo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PaymentDao
 * @Author: HeYong
 * @Date: 2020/8/20 16:22
 * @Description: TODO Description
 * @Version: 1.0
 */
@Mapper
public interface PaymentDao {

    int addPayment(Payment payment);

    Payment getPayment(@Param("id") Long id);
}

