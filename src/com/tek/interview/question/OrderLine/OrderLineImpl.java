package com.tek.interview.question.OrderLine;

import com.tek.interview.question.Item.ItemImpl;
/*
 * represents an order line which contains the @link Item and the quantity.
*
*/
public class OrderLineImpl implements OrderLine{

	private int quantity;
	private ItemImpl item;

	/*
	 * @param item Item of the order
	 * 
	 * @param quantity Quantity of the item
	 */
	public OrderLineImpl(ItemImpl item, int quantity) throws Exception {
		super();
		if (item == null) {
			System.err.println("ERROR - Item is NULL");
			throw new Exception("Item is NULL");
		}
		assert quantity > 0;
		//Fix 1 - Using this to assign to OrderLine variables
		this.item = item;
		this.quantity = quantity;
	}

	public ItemImpl getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}
}
