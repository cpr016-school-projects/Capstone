/*
 * Item.java
 *
 */

package edu.usm.cos420.example1.domain;

import java.io.Serializable;


/**
 *
 *  Item holds three 
 *  piece of data. The class implements the interface 
 *  Serializable so that we can store and retrieve the 
 *  information in this class 
 * 
 */
public class Item implements Serializable {
    
	private static final long serialVersionUID = 7526472295622776147L;
	
	private Long id;
	private String description;
    private int stock;

	
	/**
	 * Default constructor for use with GSON.fromJson
	*/
	public Item() {
		this.id = -1L;
		this.description = "";
		this.stock = 0;
	}

	/**
	 * Two field constructor for user input
	 * @param id
	 * @param description
	 */
	 
	public Item(Long id, String description) {
		this.id = id;
		this.description = description;
		this.stock = 0;
	}


	/**
	 * Changes stock
	 * @param amt amount to change stock by
	 */
	public void addStock(int amt) {
		//check to make sure it won't be negative
		int test = this.stock + amt;
		if (test < 0) {
			this.stock = 0;
		} else {
			this.stock += amt;
		}
	}

    /**
     * get the ID of the Item 
     * @return ID 
     */
     public Long getID() {
 		return id;
	 }
	 
	/**
	 * A method to get the item description
	 * @return item description
	 */
	public String getDescription(){
		return this.description;
	}

	/**
	 * A method to get the stock 
	 * @return stock amount
	 */
	public int getStock() {
		return this.stock;
	}
}




