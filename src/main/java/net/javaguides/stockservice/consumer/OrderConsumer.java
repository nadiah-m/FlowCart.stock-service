package net.javaguides.stockservice.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.stockservice.dto.Order;
import net.javaguides.stockservice.dto.OrderEvent;
import net.javaguides.stockservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
    @Autowired
    private OrderRepository orderRepository;
    @RabbitListener(queues = "${rabbitmq.queue.order.name}")
    public void consume(OrderEvent event, Message message){
        if (event == null) {
            return;
        } else {
            LOGGER.info(String.format("Order event received => %s", event.toString()));
            Order order = event.getOrder();
            orderRepository.save(order);
        }

    }
}
