package com.emirhanarici.ProductService.service;

import com.emirhanarici.ProductService.payload.request.ProductRequest;
import com.emirhanarici.ProductService.payload.response.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest request);

    ProductResponse getProductById(long productId);
}
