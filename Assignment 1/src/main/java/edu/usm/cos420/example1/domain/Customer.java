/*
 * Customer.java
 */

package edu.usm.cos420.example1.domain;

import java.io.Serializable;


/**
 *
 *  Customer holds four 
 *  piece of data. The class implements the interface 
 *  Serializable so that we can store and retrieve the 
 *  information in this class 
 * 
 */
public class Customer implements Serializable {
    
	private static final long serialVersionUID = 7526472295622776147L;

	private Long id;
	private String name;
	private String address;
	private Long[] orders;


	/**
	 * Default constructor for use with GSON.fromJson
	*/
	public Customer() {
		this.id = -1L;
		this.name = "";
		this.address = "";
		this.orders = new Long[0];
    }

	
	/**
	 * Three field constructor for user input
	 * @param id
	 * @param name
	 * @param address
	 */
	public Customer(Long id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
		// no reason to initialize orders
	}
	
	/**
	 * Adds an order to the customer file
	 * @param orderId
	 */
	public void addOrder(Long orderId) {
		Long[] newOrders = new Long[orders.length + 1];
		System.arraycopy(orders, 0, newOrders, 0, orders.length);
		newOrders[newOrders.length - 1] = orderId;
		orders = newOrders;
	}

	/**
	 * get the orders for this customer
	 * @return the orders
	 */
	public Long[] getOrders(){
		return this.orders;
	}

    /**
     * get the ID of the Customer 
     * @return ID 
     */
     public Long getID() {
 		return id;
	 }
	 
	/**
	 * get the name of the customer
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * get the address of the customer
	 * @return the address
	 */
	public String getAddress() {
		return this.address;
	}
}




