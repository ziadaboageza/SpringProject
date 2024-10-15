package com.fawry.springproject.service.order;

import com.fawry.springproject.dto.OrderDto;
import com.fawry.springproject.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface OrderService {
    Order findOrderById(Long id);
    Page<Order> findAllOrders(Pageable pageable);
    Order createOrder(OrderDto order);
}
