package net.javaguides.stockservice;

import net.javaguides.stockservice.dto.Order;
import net.javaguides.stockservice.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class StockServiceApplicationTests {

	@MockBean
	private OrderRepository orderRepository;

	@Test
	void contextLoads() {
		Order order = new Order();  // Default constructor
		order.setOrderId("12345");
		order.setName("test");
		order.setQty(1);
		order.setPrice(100.50);
		// Mock the repository call
		when(orderRepository.findAll()).thenReturn((List<Order>) order);
	}

}
