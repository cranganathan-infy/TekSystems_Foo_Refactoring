package com.tek.interview.question.Order;

import java.util.ArrayList;
import java.util.List;

import com.tek.interview.question.OrderLine.OrderLine;
	
public class OrderImpl implements Order{

	//Fix 2 - Making a new ArrayList
	private List<OrderLine> orderLines= new ArrayList<OrderLine>();

	public void add(OrderLine o) throws Exception {
		if (o == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		orderLines.add(o);
	}

	public int size() {
		return orderLines.size();
	}

	public OrderLine get(int i) {
		return orderLines.get(i);
	}

	public void clear() {
		this.orderLines.clear();
	}
}
