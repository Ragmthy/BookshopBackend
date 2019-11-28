package com.bookshop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.model.Order;
import com.bookshop.repository.OrderRepository;

@Service
@Transactional
public class OrderService {

	private OrderRepository orderRepo;

	public OrderService() {
		super();
	}
	
	@Autowired
	public OrderService(OrderRepository orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}

	// Listing all available Categories
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	public Order getOrder(long orderId) {
		Optional<Order> optionalOrder = orderRepo.findById(orderId);
		if (optionalOrder.isPresent()) {
			return optionalOrder.get();
		} else
			return null;
	}

	public Order saveOrder(Order order, long orderId) {
		return orderRepo.save(order);
	}

	// Deleting off a Order
	public Order removeOrder(long orderId) {
		Optional<Order> optionalOrder = orderRepo.findById(orderId);
		if (optionalOrder.isPresent()) {
			orderRepo.delete(optionalOrder.get());
			return optionalOrder.get();
		} else
			return null;
	}

	// Adding/Editing a Order
	public Order updateOrder(long orderId, Order order) {
		Optional<Order> optionalOrder = orderRepo.findById(orderId);
		if (optionalOrder.isPresent()) {
			Order orderToBeUpdated = optionalOrder.get();
			orderToBeUpdated.setCustomer(order.getCustomer());
			orderToBeUpdated.setPayment(order.getPayment());
			//orderToBeUpdated.setOrderStatus(order.getOrderStatus());
			//orderToBeUpdated.setQuantity(order.getQuantity());
			//orderToBeUpdated.setRecipientAddress(order.getRecipientAddress());
			orderToBeUpdated.setRecipientName(order.getRecipientName());
			orderToBeUpdated.setRecipientNum(order.getRecipientNum());
			//orderToBeUpdated.setSubtotal(order.getSubtotal());
			orderToBeUpdated.setTotal(order.getTotal());
			orderToBeUpdated.setOrderDate(order.getOrderDate());
			orderToBeUpdated.setOrderDetails(order.getOrderDetails());
			orderToBeUpdated.setOrderid(order.getOrderid());
			orderToBeUpdated.setShippingAddress(order.getShippingAddress());
			orderToBeUpdated.setStatus(order.getShippingStatus());

			return orderToBeUpdated;

		} else
			return null;

	}

}
