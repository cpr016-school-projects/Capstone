package edu.usm.cos420.example1.service.impl;

import java.util.List;

import edu.usm.cos420.example1.dao.domain.CusDao;
import edu.usm.cos420.example1.dao.domain.ItemDao;
import edu.usm.cos420.example1.dao.domain.OrderDao;
import edu.usm.cos420.example1.domain.Customer;
import edu.usm.cos420.example1.domain.Item;
import edu.usm.cos420.example1.domain.Order;
import edu.usm.cos420.example1.service.ExampleService;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * The Service1 Layer Implementation is based a design pattern which
 * aims to organize the functionality of the application into logical units that
 * are typically layered on top of much of the low level functionality of the
 * application. This organization helps support service oriented architectures.
 *
 */
public class Service1 implements ExampleService {

	CusDao cusDao;
	ItemDao itemDao;
	OrderDao orderDao;

	/**
	 * Default Constructor creates default dao objects
	 */
	public Service1() {
		this.cusDao = new CusDao();
		this.itemDao = new ItemDao();
		this.orderDao = new OrderDao();
	}

	/**
	 * Creates a new customer object
	 * @param id 
	 * @param name
	 * @param address
	 */
	public void addCustomer(Long id, String name, String address) 
	{
		Customer newCus = new Customer(id, name, address);
		cusDao.add(newCus);
	}

	/**
	 * Creates a new item object
	 * @param id
	 * @param description
	 */
	public void addItem(Long id, String description) 
	{
		Item newItem = new Item(id, description);
		itemDao.add(newItem);
	}

	/**
	 * Adds stock to the target item
	 * @param id target item
	 * @param amt stock amount
	 */
	public void addStock(Long id, int amt) 
	{
		// find item by id, then add the number of stock to it.
		Item item;
		try {
			item = itemDao.find(id);
			item.addStock(amt);
			itemDao.update(item);
		} catch (Exception e) {
			System.out.println();
			System.out.println("*********");
			System.out.println("Error adding the stock. Does the item exist?");
			System.out.println("*********");
		}
	}

	/**
	 * Creates a new order object
	 * @param cusId the customer id for the order
	 * @param orderId the order id
	 * @param currDate the current date
	 */
	public void placeOrder(Long cusId, Long orderId, Date currDate) {
		// add the orderID to Customer
		Customer cus;
		try {
			cus = cusDao.find(cusId);
			cus.addOrder(orderId);
			cusDao.update(cus);
		} catch (Exception e) {
			System.out.println();
			System.out.println("*********");
			System.out.println("Error placing the order. Does the customer exist?");
			System.out.println("*********");
		}

		// create the order
		Order newOrder = new Order(orderId, currDate);
		orderDao.add(newOrder);
	}

	/**
	 * Add items to a target order
	 * @param id the target order
	 * @param items the items to add
	 */
	public void addOrderItems(Long id, Long[][] items) 
	{
		Order order;
		try {
			order = orderDao.find(id);
			order.addItems(items);
			orderDao.update(order);
		} catch (Exception e) {
			System.out.println();
			System.out.println("*********");
			System.out.println("Error adding items. Does the order exist?");
			System.out.println("*********");
		}
	}
	
	/**
	 * Helps to display the orders for a customer within a date range
	 * @param id the customer id
	 * @param begin start of date range
	 * @param end end of date range
	 * @return list of orders
	 */
	public ArrayList<Order> displayOrders(Long id, Date begin, Date end) {
		
		Customer cus = cusDao.find(id);
		
		if (cus == null) {
			System.out.println();
			System.out.println("*********");
			System.out.println("Error: Customer not found. Does the customer exist?");
			System.out.println("*********");
			return new ArrayList<Order>();
		} else {
			Long[] orders = cus.getOrders();
			ArrayList<Order> validOrders = new ArrayList<Order>();

			for (int i = 0; i < orders.length; i++) {
				Order toTest = orderDao.find(orders[i]);
				// test if date is after begin-date
				// begin.compare(test) <= 0 if begin is before/equals test
				if (begin.compareTo(toTest.getDate()) <= 0) {
					//test if date is before end-date
					// end.compare(test) >= 0 if end is after/equals test
					if (end.compareTo(toTest.getDate()) >= 0) {
						// append to arraylist
						validOrders.add(toTest);
					}
				}
			}

			return validOrders;
		}
	}

	/**
	 * finds an Item object
	 * @param id item id
	 * @return Item
	 */
	public Item findItem(Long id) {
		return itemDao.find(id);
	}

	/**
	 * finds a Customer object
	 * @param id customer id
	 * @return Customer
	 */
	public Customer findCustomer(Long id) {
		return cusDao.find(id);
	}

	/**
	 * Helps to display the inventory
	 * @return list of inventory
	 */
	public List<Item> displayInventory() {
		return itemDao.list();
	}

	/**
	 * Helps ti display customers
	 * @return list of customers
	 */
	public List<Customer> displayCustomers() {
		return cusDao.list();
	}
}
