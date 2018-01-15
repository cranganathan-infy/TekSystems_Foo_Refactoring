package com.tek.interview.question.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.tek.interview.question.Helper.Calculator;
import com.tek.interview.question.Item.ItemImpl;
import com.tek.interview.question.Order.Order;
import com.tek.interview.question.Order.OrderImpl;
import com.tek.interview.question.OrderLine.OrderLineImpl;

public class FooTest {
	Map<String, Order> o = new HashMap<String, Order>();


	@Before
	public void setUp() throws Exception {

		//assertEquals(expected, actual);

	}

	@Test
	public void testForOrder1() throws Exception {

		Order c = new OrderImpl();

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream stdout = new PrintStream(os);
		System.setOut(stdout);


		String expected = "*******Order 1*******\r\n" + 
				"1 book: 13.74\r\n" + 
				"1 music CD: 16.49\r\n" + 
				"1 chocolate bar: 0.94\r\n" + 
				"Sales Tax: 2.84\r\n" + 
				"Total: 28.33\r\n"+ 
				"Sum of orders: 28.33\r\n";

		c.add(new OrderLineImpl(new ItemImpl("book", (float) 12.49), 1));
		c.add(new OrderLineImpl(new ItemImpl("music CD", (float) 14.99), 1));
		c.add(new OrderLineImpl(new ItemImpl("chocolate bar", (float) 0.85), 1));
		o.put("Order 1", c);
		new Calculator().calculate(o);
		assertEquals(expected,os.toString());

		//fail("Not yet implemented");
	}

	@Test
	public void testForOrder2() throws Exception {
		Order c = new OrderImpl();

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream stdout = new PrintStream(os);
		System.setOut(stdout);
		String expected = "*******Order 2*******\r\n" + 
				"1 imported box of chocolate: 11.5\r\n" + 
				"1 imported bottle of perfume: 54.62\r\n" + 
				"Sales Tax: 8.62\r\n" + 
				"Total: 57.5\r\n" + 
				"Sum of orders: 57.5\n";
		c.add(new OrderLineImpl(new ItemImpl("imported box of chocolate", 10), 1));
		c.add(new OrderLineImpl(new ItemImpl("imported bottle of perfume", (float) 47.50), 1));
		o.put("Order 2", c);
		new Calculator().calculate(o);
		//System.out.println(os.toString());

		assertEquals(expected.trim(),os.toString().trim());
	}

	@Test
	public void testForOrder3() throws Exception {

		Order c = new OrderImpl();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream stdout = new PrintStream(os);
		System.setOut(stdout);
		String expected = "*******Order 3*******\r\n" + 
				"1 Imported bottle of perfume: 32.19\r\n" + 
				"1 bottle of perfume: 20.89\r\n" + 
				"1 packet of headache pills: 10.73\r\n" + 
				"1 box of imported chocolates: 12.94\r\n" + 
				"Sales Tax: 8.77\r\n" + 
				"Total: 67.98\r\n" + 
				"Sum of orders: 67.98\n" ; 

		c.add(new OrderLineImpl(new ItemImpl("Imported bottle of perfume", (float) 27.99), 1));
		c.add(new OrderLineImpl(new ItemImpl("bottle of perfume", (float) 18.99), 1));
		c.add(new OrderLineImpl(new ItemImpl("packet of headache pills", (float) 9.75), 1));
		c.add(new OrderLineImpl(new ItemImpl("box of imported chocolates", (float) 11.25), 1)); 
		o.put("Order 3", c);
		new Calculator().calculate(o);
		assertEquals(expected.trim(),os.toString().trim());
	}

}
