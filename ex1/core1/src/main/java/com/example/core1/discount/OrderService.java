package com.example.core1.discount;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
