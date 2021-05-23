package edu.usm.cos420.example1.dao.domain;

import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.dao.JsonDao;
import edu.usm.cos420.example1.domain.Order;

/**
 * 
 *  A Data Access Object specifically for Order entities 
 *     
 */
public class OrderDao
{
	private GenericDao<Long,Order> orderDao;

	/**
	 * Default constructor creates an Json file called order.json
	 * TypeToken allows the GSON parser to map to/from JSON to objects
	 */
	public OrderDao()
	{
        Type t = new TypeToken<Map<Long, Order>>(){}.getType(); 
		orderDao = new JsonDao<>("orders.json",t); 
	}

	/**
	 * Add a Order to the DAO repository
	 * @param entity any Order object
	 */
	public void add(Order entity)
	{
		orderDao.add(entity.getID(), entity);
	}
	
	/**
	 * Update a Order in the DAO repository
	 * @param entity any Order object
	 */
	public void update(Order entity) 
	{
		orderDao.update(entity.getID(), entity);
	}
	
	/**
	 * Remove a Order in the DAO repository
	 * @param id of the Order object to remove
	 */

	public void remove(Long id)
	{
		orderDao.remove(id);
	}
	
	/**
	 * Find a Order in the DAO repository
	 * @param id of the Order object to locate
	 * @return the Order with id field equal to key
	 */
	public Order find(Long key)
	{
		return orderDao.find(key);
	}
    
	/**
	 * Generate a list of Orders in the DAO repository
	 * @return List of Orders 
	 */

	public List<Order> list() {
		return orderDao.list();
	}

}

