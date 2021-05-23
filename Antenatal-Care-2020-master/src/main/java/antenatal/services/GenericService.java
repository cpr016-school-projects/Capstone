package antenatal.services;

import java.util.List;

public interface GenericService<T> {
	
	/**
	 * Add a randomly generated CItem element to the repository
	 */
    public void addItem(T entity);
    /**
     * finds a single entry in the repository based on string search criteria
     */
    public T findItem(String search);
	/**
	 * return the list of CItems from the repository
	 */
    public List<T> getAll();
	/**
	 * Puts the newly updated item into repository
	 * @param the newly updated entity
	 */
	public void updateItem(T entity);
}
