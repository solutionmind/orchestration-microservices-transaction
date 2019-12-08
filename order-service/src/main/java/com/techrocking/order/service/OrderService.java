package com.techrocking.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techrocking.order.entity.Order;
import com.techrocking.order.kafka.source.OrderNotProcessedEventSource;
import com.techrocking.order.kafka.source.OrderPlacedEventSource;
import com.techrocking.order.payload.PlaceOrderRequest;
import com.techrocking.order.payload.PlaceOrderResponse;

@Service
public class OrderService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(OrderService.class);
	
	@Autowired
	private OrderPlacedEventSource orderPlacedEventSource;
	
	@Autowired
	private OrderNotProcessedEventSource OoderNotProcessedEventSource;
	
	public PlaceOrderResponse createOrder(PlaceOrderRequest request) {
		Order order = new Order();
		
		/*order service should call inventory service to get item name by item id*/
		order.setItemName("item-xyz");
		
		/*order service should call customer service to get customer name by id*/
		order.setCustomerName("customer-abc");
		
		/*order service should assign some valid order id*/
		order.setId(234L);
		
		/*order service should save order*/
		//orderRepository.save(order)
		
		PlaceOrderResponse response = new PlaceOrderResponse();
		response.setMessage("order placed successfully");
		response.setOrderId(order.getId());
		
		logger.info("going to place orderPlacedEvent for order :"  + order.getId() );
		orderPlacedEventSource.publishOrderEvent(order.getId());
		
		return response;
	}
	
	public void compensateOrder(Long orderId) {
		/*delete order record for given order id from database*/
		
		/*publish OoderNotProcessedEvent*/ 
		OoderNotProcessedEventSource.publishOrderNotProcessedEvent(orderId);
	}

}
