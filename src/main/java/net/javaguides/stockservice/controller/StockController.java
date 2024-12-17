package net.javaguides.stockservice.controller;

import net.javaguides.stockservice.dto.Order;
import net.javaguides.stockservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    private OrderRepository orderRepository;
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> ordersPlaced = orderRepository.findAll();
        return new ResponseEntity<>(ordersPlaced, HttpStatus.OK);
    }
}
