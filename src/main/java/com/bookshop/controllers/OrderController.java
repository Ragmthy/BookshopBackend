package com.bookshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.model.Order;
import com.bookshop.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	public OrderController() {
		super();
	}

	@Autowired
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@GetMapping(path = "/orders") //Works
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@PutMapping(path = "/orders/{orderId}")
	public Order updateOrder(@RequestBody Order order, @PathVariable long orderId) {
		return orderService.updateOrder(orderId, order);
	}
	
	@GetMapping(path = "/orders/{orderId}")  //Works
	public Order getOrder(@PathVariable long orderId) {
		return orderService.getOrder(orderId);
	}
	
	@PostMapping("/orders") //Works
	public Order saveOrder(@RequestBody Order order) {
		return orderService.saveOrder(order, order.getOrderid());
	}
	
	@DeleteMapping(path = "/orders/{orderId}") //Works
	public Order removeOrder(@PathVariable long orderId) {
		return orderService.removeOrder(orderId);
	}
		
	

}
