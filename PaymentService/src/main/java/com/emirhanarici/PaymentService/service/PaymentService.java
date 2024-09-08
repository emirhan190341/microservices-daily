package com.emirhanarici.PaymentService.service;

import com.emirhanarici.PaymentService.payload.PaymentRequest;
import com.emirhanarici.PaymentService.payload.PaymentResponse;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(long orderId);
}
