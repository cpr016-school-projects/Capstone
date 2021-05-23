package edu.usm.cos420.example1.dao.domain;

import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.dao.JsonDao;
import edu.usm.cos420.example1.domain.Item;

/**
 * 
 *  A Data Access Object specifically for Item entities 
 *     
 */
public class ItemDao
{
	private GenericDao<Long,Item> itemDao;

	/**
	 * Default constructor creates an Json file called item.json
	 * TypeToken allows the GSON parser to map to/from JSON to objects
	 */
	public ItemDao()
	{
        Type t = new TypeToken<Map<Long, Item>>(){}.getType(); 
		itemDao = new JsonDao<>("inventory.json",t); 
	}

	/**
	 * Add a Item to the DAO repository
	 * @param entity any Item object
	 */
	public void add(Item entity)
	{
		itemDao.add(entity.getID(), entity);
	}
	
	/**
	 * Update a Item in the DAO repository
	 * @param entity any Item object
	 */
	public void update(Item entity) 
	{
		itemDao.update(entity.getID(), entity);
	}
	
	/**
	 * Remove a Item in the DAO repository
	 * @param id of the Item object to remove
	 */

	public void remove(Long id)
	{
		itemDao.remove(id);
	}
	
	/**
	 * Find a Item in the DAO repository
	 * @param id of the Item object to locate
	 * @return the Item with id field equal to key
	 */
	public Item find(Long key)
	{
		return itemDao.find(key);
	}
    
	/**
	 * Generate a list of Items in the DAO repository
	 * @return List of Items 
	 */
	public List<Item> list() {
		return itemDao.list();
	}

}

