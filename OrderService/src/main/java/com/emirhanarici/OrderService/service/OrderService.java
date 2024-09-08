package com.emirhanarici.OrderService.service;

import com.emirhanarici.OrderService.payload.request.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
