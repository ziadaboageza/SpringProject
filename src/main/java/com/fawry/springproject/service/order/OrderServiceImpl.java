package com.fawry.springproject.service.order;

import com.fawry.springproject.dto.OrderDto;
import com.fawry.springproject.entity.Merchant;
import com.fawry.springproject.entity.Order;
import com.fawry.springproject.entity.OrderItem;
import com.fawry.springproject.entity.Product;
import com.fawry.springproject.enums.OrderStatus;
import com.fawry.springproject.repository.OrderRepository;
import com.fawry.springproject.service.mechant.MerchantService;
import com.fawry.springproject.service.product.ProductService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MerchantService merchantService;
    private final ProductService productService;

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Order with id " + id + " not found")
        );
    }

    @Override
    public Page<Order> findAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Order createOrder(OrderDto order) {
        Merchant customer = merchantService.getMerchantById(order.customerId());
        Order newOrder = new Order();

        newOrder.setMerchant(customer);
        newOrder.setDate(LocalDateTime.now());
        newOrder.setStatus(OrderStatus.PENDING);

        double[] totalAmount = new double[1];
        List<OrderItem> orderItems = order.items()
                .parallelStream()
                .map(item -> {
                    Product product = productService.getProductById(item.productId());
                    return OrderItem.builder()
                            .product(product)
                            .quantity(item.quantity())
                            .unitPrice(product.getPrice())
                            .totalPrice(product.getPrice() * item.quantity())
                            .order(newOrder)
                            .build();
                }).peek((orderItem) -> totalAmount[0] += orderItem.getTotalPrice())
                .collect(Collectors.toList());

        newOrder.setItems(orderItems);
        newOrder.setTotalPrice(totalAmount[0]);
        return orderRepository.save(newOrder);
    }
    

}
