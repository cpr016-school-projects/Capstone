package edu.usm.cos420.example1.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.usm.cos420.example1.domain.Customer;
import edu.usm.cos420.example1.domain.Item;
import edu.usm.cos420.example1.domain.Order;

/**
 * 
 *  The Example1 Service Interface is based a design pattern
 *      which aims to organize the functionality of the application into logical units 
 *      that are typically layered on top of much of the low level functionality of the 
 *      application. This organization helps support service oriented architectures. 
 *
 */
public interface ExampleService {
	
	/**
	 * Creates a new customer object
	 * @param id 
	 * @param name
	 * @param address
	 */
	public void addCustomer(Long id, String name, String address);
	/**
	 * Creates a new item object
	 * @param id
	 * @param description
	*/
	public void addItem(Long id, String description);
	/**
	 * Adds stock to the target item
	 * @param id target item
	 * @param amt stock amount
	 */
	public void addStock(Long id, int amt);
	/**
	 * Creates a new order object
	 * @param cusId the customer id for the order
	 * @param orderId the order id
	 * @param currDate the current date
	 */
	public void placeOrder(Long cusId, Long orderId, Date currDate);
	/**
	 * Add items to a target order
	 * @param id the target order
	 * @param items the items to add
	 */
	public void addOrderItems(Long id, Long[][] items);
	/**
	 * Helps to display the orders for a customer within a date range
	 * @param id the customer id
	 * @param begin start of date range
	 * @param end end of date range
	 * @return list of orders
	 */
	public ArrayList<Order> displayOrders(Long id, Date begin, Date end);
	/**
	 * finds an Item object
	 * @param id item id
	 * @return Item
	 */
	public Item findItem(Long id);
	/**
	 * finds a Customer object
	 * @param id customer id
	 * @return Customer
	 */
	public Customer findCustomer(Long id);
	/**
	 * Helps to display the inventory
	 * @return list of inventory
	 */
	public List<Item> displayInventory();
	/**
	 * Helps ti display customers
	 * @return list of customers
	 */
	public List<Customer> displayCustomers();
	// /**
	//  * return the list of CItems from the repository
	//  */
    // public List<Customer> getAll();
    // /**
    //  * Calculate the maximum ID value of elements in the repository     
    //  * @return the maximum id of a Customer in the repository
    //  */
	// public Long maxCItemId();
	
}
