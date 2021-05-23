/*
 * Order.java
 *
 */

package edu.usm.cos420.example1.domain;

import java.io.Serializable;
import java.util.Date;


/**
 *
 *  Order holds three 
 *  piece of data. The class implements the interface 
 *  Serializable so that we can store and retrieve the 
 *  information in this class 
 * 
 */
public class Order implements Serializable {
    
	private static final long serialVersionUID = 7526472295622776147L;

	private Long id;
	private Date date;
    private Long[][] items;


	/**
	 * Default constructor for use with GSON.fromJson
	*/
	public Order() {
		this.id = -1L;
		this.date = new Date();
		this.items = new Long[0][0];
	}

	/**
	 * Two field constructor for user input
	 * @param id
	 * @param date
	 */
	public Order(Long id, Date date) {
		this.id = id;
		this.date = date;
		this.items = new Long[0][0];
	}

	/**
	 * get the date of the order
	 * @return date
	 */
	public Date getDate(){
		return this.date;
	}

    /**
     * get the ID of the Order 
     * @return ID 
     */
     public Long getID() {
 		return id;
	 }
	 
	/**
	 * get the items of the order
	 * @return items
	 */
	 public Long[][] getItems(){
		return this.items;
	 }

	/**
	 * Adds items to the order
	 * @param itemsToAdd the items to add
	 */
	public void addItems(Long[][] itemsToAdd) {
		Long[][] newOrders = new Long[items.length + itemsToAdd.length][2];
		System.arraycopy(items, 0, newOrders, 0, items.length);
		System.arraycopy(itemsToAdd, 0, newOrders, items.length, itemsToAdd.length);
		items = newOrders;
	}
}




