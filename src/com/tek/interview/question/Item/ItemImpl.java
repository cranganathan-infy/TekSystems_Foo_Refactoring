/**
 * 
 */
package com.tek.interview.question.Item;

/**
 * @author rpcha
 *
 */
public class ItemImpl {

	private String description;
	private float price;

	public ItemImpl(String description, float price) {
		super();
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public float getPrice() {
		return price;
	}
}
