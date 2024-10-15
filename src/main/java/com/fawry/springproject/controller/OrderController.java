package com.fawry.springproject.controller;

import com.fawry.springproject.dto.OrderDto;
import com.fawry.springproject.entity.Order;
import com.fawry.springproject.service.order.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping // *
    public Page<Order> getAllOrders(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "asc") String sortingDirection
    ) {
        Sort sort;
        if (sortingDirection.equalsIgnoreCase("asc")) {
            sort = Sort.by(Sort.Direction.ASC, "date");
        } else {
            sort = Sort.by(Sort.Direction.DESC, "date");
        }
        return orderService.findAllOrders(PageRequest.of(pageNo, size, sort));
    }

    @PostMapping // *
    public Order createOrder(@Valid @RequestBody OrderDto order) {
        return orderService.createOrder(order);
    }

}
