package com.grpc.product.service.grpc;

import com.ndmkcn.grpc.DiscountRequest;
import com.ndmkcn.grpc.DiscountResponse;

public interface DiscountGrpcService {
    DiscountResponse getDiscount(DiscountRequest discountRequest);
}
