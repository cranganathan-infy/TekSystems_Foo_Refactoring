package com.tek.interview.question.Order;

import com.tek.interview.question.OrderLine.OrderLine;

public interface Order {
	
	public void add(OrderLine o) throws Exception;

	public int size() ;

	public OrderLine get(int i) ;

	public void clear() ;

	
}
