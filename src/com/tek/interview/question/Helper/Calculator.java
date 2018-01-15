package com.tek.interview.question.Helper;

import java.text.DecimalFormat;
import java.util.Map;

import com.tek.interview.question.Order.Order;

public class Calculator {

	public static double rounding(double value) {
		//return ( (int) (value * 100)) / 100;
		//Fix - change the rounding logic
		DecimalFormat df = new DecimalFormat("#.00");
		return Double.valueOf(df.format(value));
	}

	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public void calculate(Map<String, Order> o) {

		double grandtotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			//grandtotal = 0;

			Order r = entry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			for (int i = 0; i < r.size(); i++) { //Fix - iterating <size() instead of <= size()

				// Calculate the taxes
				double tax = 0;

				if (r.get(i).getItem().getDescription().toLowerCase().contains("imported")) {
					tax = rounding(r.get(i).getItem().getPrice() * 0.15); // Extra 5% tax on
					// imported items
				} else {
					tax = rounding(r.get(i).getItem().getPrice() * 0.10);
				}

				// Calculate the total price
				double totalprice = r.get(i).getItem().getPrice() +rounding(tax); //Fix- making use of the rounding method instead of floor

				// Print out the item's total price
				//Fix-Adding Item quantity
				System.out.println(r.get(i).getQuantity() +" "+ r.get(i).getItem().getDescription() + ": " + rounding(totalprice));//Fix- making use of the rounding method instead of floor

				// Keep a running total
				totalTax += tax;
				total += r.get(i).getItem().getPrice();
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + rounding(totalTax));

			//total = total + totalTax;

			// Print out the total amount
			System.out.println("Total: " + rounding(total * 100) / 100);
			grandtotal += total;
		}

		System.out.println("Sum of orders: " + rounding(grandtotal * 100) / 100);
	}
}

