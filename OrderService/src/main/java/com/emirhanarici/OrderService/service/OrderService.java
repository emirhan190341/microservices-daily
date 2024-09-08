package com.emirhanarici.OrderService.service;

import com.emirhanarici.OrderService.payload.request.OrderRequest;
import com.emirhanarici.OrderService.payload.response.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);
}
