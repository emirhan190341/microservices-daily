package com.emirhanarici.OrderService.service.impl;

import com.emirhanarici.OrderService.entity.Order;
import com.emirhanarici.OrderService.payload.request.OrderRequest;
import com.emirhanarici.OrderService.repository.OrderRepository;
import com.emirhanarici.OrderService.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public long placeOrder(OrderRequest orderRequest) {
        log.info("OrderServiceImpl | placeOrder is called");

        //Order Entity -> Save the data with Status Order Created
        //Product Service - Block Products (Reduce the Quantity)
        //Payment Service -> Payments -> Success-> COMPLETE, Else
        //CANCELLED

        log.info("OrderServiceImpl | placeOrder | Placing Order Request orderRequest : " + orderRequest.toString());

        log.info("OrderServiceImpl | placeOrder | Calling productService through FeignClient");
//        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

        log.info("OrderServiceImpl | placeOrder | Creating Order with Status CREATED");
        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();

        order = orderRepository.save(order);

        log.info("OrderServiceImpl | placeOrder | Calling Payment Service to complete the payment");

//        PaymentRequest paymentRequest
//                = PaymentRequest.builder()
//                .orderId(order.getId())
//                .paymentMode(orderRequest.getPaymentMode())
//                .amount(orderRequest.getTotalAmount())
//                .build();

        String orderStatus = null;

//        try {
//            paymentService.doPayment(paymentRequest);
//            log.info("OrderServiceImpl | placeOrder | Payment done Successfully. Changing the Oder status to PLACED");
//            orderStatus = "PLACED";
//        } catch (Exception e) {
//            log.error("OrderServiceImpl | placeOrder | Error occurred in payment. Changing order status to PAYMENT_FAILED");
//            orderStatus = "PAYMENT_FAILED";
//        }

//        order.setOrderStatus(orderStatus);

//        orderRepository.save(order);

        log.info("OrderServiceImpl | placeOrder | Order Places successfully with Order Id: {}", order.getId());
        return order.getId();
    }
}
