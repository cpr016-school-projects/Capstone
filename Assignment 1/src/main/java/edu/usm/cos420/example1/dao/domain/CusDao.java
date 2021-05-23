package edu.usm.cos420.example1.dao.domain;

import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.dao.JsonDao;
import edu.usm.cos420.example1.domain.Customer;

/**
 *  A Data Access Object specifically for Customer entities   
 */
public class CusDao
{
	private GenericDao<Long,Customer> cusDao;

	/**
	 * Default constructor creates an Json file called customer.json
	 * TypeToken allows the GSON parser to map to/from JSON to objects
	 */
	public CusDao()
	{
        Type t = new TypeToken<Map<Long, Customer>>(){}.getType(); 
		cusDao = new JsonDao<>("customers.json",t); 
	}

	/**
	 * Add a Customer to the DAO repository
	 * @param entity any Customer object
	 */
	public void add(Customer entity)
	{
		cusDao.add(entity.getID(), entity);
	}
	
	/**
	 * Update a Customer in the DAO repository
	 * @param entity any Customer object
	 */
	public void update(Customer entity) 
	{
		cusDao.update(entity.getID(), entity);
	}
	
	/**
	 * Find a Customer in the DAO repository
	 * @param id of the Customer object to locate
	 * @return the Customer with id field equal to key
	 */
	public Customer find(Long key)
	{
		return cusDao.find(key);
	}
    
	/**
	 * Generate a list of Customers in the DAO repository
	 * @return List of Customers 
	*/
	public List<Customer> list() {
		return cusDao.list();
	}

}

