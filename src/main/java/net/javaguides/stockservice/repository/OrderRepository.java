package net.javaguides.stockservice.repository;

import net.javaguides.stockservice.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // You can define custom query methods here if needed
}
