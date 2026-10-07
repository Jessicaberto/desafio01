package com.devsuperior.services;


import org.springframework.stereotype.Service;

import com.devsuperior.entities.Order;


@Service
public class OrderService {

    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        double discount = order.getBasic() * order.getDiscount() / 100.0;
        double basicWithDiscount = order.getBasic() - discount;
        return basicWithDiscount + shippingService.shipment(order);
    }
}
