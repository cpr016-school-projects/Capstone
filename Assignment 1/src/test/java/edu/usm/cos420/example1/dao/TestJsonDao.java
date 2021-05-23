package edu.usm.cos420.example1.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.usm.cos420.example1.domain.Customer;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


public class TestJsonDao 
{
	JsonDao<Long, Customer> dao1; 
	JsonDao<String, String> dao2; 
	
/** 
 * Create a clean DAO before each test
 */
	@Before
	public void setupData() {
	    Type t1 = new TypeToken<Map<Long, Customer>>(){}.getType(); 
	    Type t2 = new TypeToken<Map<String, String>>(){}.getType(); 

		dao1 = new JsonDao<Long, Customer>("_test1.json",t1);
		dao2 = new JsonDao<String, String>("_test2.json",t2);
	}
	
	@Test
    public void testSaveandFind1() {
        Long id; 
        Customer retrievedItem;
        
        Customer oneItem = new Customer(2, "a string"); 
        
        // get PK of first address
        id = oneItem.getID();
        
        dao1.add(id, oneItem);

        retrievedItem = (Customer) dao1.find(id);
        
        assertNotNull("Dao returns a null item.", retrievedItem);
        assertEquals("Stored Id and original Id are not equal ", retrievedItem.getID() , oneItem.getID());
        assertEquals("Stored int and original int are not equal ", retrievedItem.getMyInteger() , oneItem.getMyInteger());
        
	}

	@Test
    public void testSaveandRemove1() {
        Long id; 
        Customer retrievedItem;
        
    	
        Customer oneItem = new Customer(new Long((int) (Math.random()*100000)), 1, "a string"); 
        Customer twoItem = new Customer(new Long((int) (Math.random()*100000)), 2, "a string"); 
        Customer threeItem = new Customer(new Long((int) (Math.random()*100000)), 3, "a string"); 
        
        // get PK of first address
        id = oneItem.getID();        
        dao1.add(id, oneItem);
        id = twoItem.getID();        
        dao1.add(id, twoItem);
        id = threeItem.getID();        
        dao1.add(id, threeItem);

        dao1.remove(twoItem.getID());
        
        retrievedItem = (Customer) dao1.find(twoItem.getID());
        
        assertNull("Dao returns a null item.", retrievedItem);
        
	}

	@Test
    public void testSaveandUpdate1() {
        Long id; 
        Customer retrievedItem;
        
    	
        Customer oneItem = new Customer(new Long((int) (Math.random()*100000)), 1, "a string"); 
        Customer twoItem = new Customer(new Long((int) (Math.random()*100000)), 2, "a string"); 
        Customer threeItem = new Customer(new Long((int) (Math.random()*100000)), 3, "a string"); 
        
        // get PK of first address
        id = oneItem.getID();        
        dao1.add(id, oneItem);
        id = twoItem.getID();        
        dao1.add(id, twoItem);
        id = threeItem.getID();        
        dao1.add(id, threeItem);

        // CHeck one of the three items to make sure it was stored correctly
        retrievedItem = (Customer) dao1.find(twoItem.getID());
        
        assertNotNull("Dao returns a null item.", retrievedItem);
        assertEquals("Stored Id and original Id are not equal ", retrievedItem.getID() , twoItem.getID());
        assertEquals("Stored int and original int are not equal ", retrievedItem.getMyInteger() , twoItem.getMyInteger());
        assertEquals("Stored int and original int are not equal ", retrievedItem.getMyString() , twoItem.getMyString());

        twoItem.setMyString("A New String");
        twoItem.setMyInteger(55);
        dao1.update(twoItem.getID(),twoItem);
        retrievedItem = (Customer) dao1.find(twoItem.getID());

        // Check that the modified elements was properly stored
        assertNotNull("Dao returns a null item.", retrievedItem);
        assertEquals("Stored Id and original Id are not equal ", retrievedItem.getID() , twoItem.getID());
        assertEquals("Stored int and original int are not equal ", retrievedItem.getMyInteger() , twoItem.getMyInteger());
        assertEquals("Stored int and original int are not equal ", retrievedItem.getMyString() , twoItem.getMyString());

        retrievedItem = (Customer) dao1.find(threeItem.getID());
        
        // check one of the other elements to make sure they are ok 
        assertNotNull("Dao returns a null item.", retrievedItem);
        assertEquals("Stored Id and original Id are not equal ", retrievedItem.getID() , threeItem.getID());
        assertEquals("Stored int and original int are not equal ", retrievedItem.getMyInteger() , threeItem.getMyInteger());
        assertEquals("Stored int and original int are not equal ", retrievedItem.getMyString() , threeItem.getMyString());

        
	}

	@Test
    public void testSaveandFind2() {

		dao2.add("1", "Test 1");
		dao2.add("2", "Test 1");

        String retrievedItem = (String) dao2.find("1");
        
        assertNotNull("Dao returns a null item.", retrievedItem);
        assertEquals("Stored string and original String are not equal ", retrievedItem, "Test 1");
        
	}

	@Test
    public void testCountObjectsInFile() {
        Long id; 
        
        Customer oneItem = new Customer(1, "a string"); 
        Customer twoItem = new Customer(2, "a string"); 
        Customer threeItem = new Customer(3, "a string"); 
        
        // get PK of first address
        id = oneItem.getID();      
        dao1.add(id, oneItem);
        id = twoItem.getID();      
        dao1.add(id, twoItem);
        id = threeItem.getID();      
        dao1.add(id, threeItem);

        int retrievedCount = dao1.determineNumberOfObjectsInStream();
        
        assertEquals("Stored object counts are not equal ", retrievedCount, 3);
        
	}

	@Test
    public void testPersistenceAcrossTests() {
        Long id; 
	    Type t1 = new TypeToken<Map<Long, Customer>>(){}.getType(); 

 	    JsonDao<Long,Customer> pdao = new JsonDao<Long, Customer>("_ptest.json",t1);
        Customer oneItem = new Customer(new Long((int) (Math.random()*100000)), 1, "a string"); 
        Customer twoItem = new Customer(new Long((int) (Math.random()*100000)), 2, "a string"); 
        Customer threeItem = new Customer(new Long((int) (Math.random()*100000)), 3, "a string"); 

        int initialCount = pdao.determineNumberOfObjectsInStream();

        // get PK of first address
        id = oneItem.getID();        
        pdao.add(id, oneItem);
        id = twoItem.getID();        
        pdao.add(id, twoItem);
        id = threeItem.getID();        
        pdao.add(id, threeItem);

        int updatedCount = pdao.determineNumberOfObjectsInStream();

        assertEquals("Stored object counts are not equal after updating file", initialCount + 3, updatedCount);
    
		Path path3 = FileSystems.getDefault().getPath(".", "_ptest.json");
		try {
		    Files.delete(path3);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", path3 );
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", path3);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}

	}
	
	/** 
	 * Need to delete the file for next test
	 */
	@After
	public void tearDown()
	{

/*
 *   This will be run after every test ... overly ambitious
 */

		Path path1 = FileSystems.getDefault().getPath(".", "_test1.json");
		Path path2 = FileSystems.getDefault().getPath(".", "_test2.json");
		try {
		    Files.delete(path1);
		    Files.delete(path2);
		} catch (NoSuchFileException x) {
		} catch (DirectoryNotEmptyException x) {
		} catch (IOException x) {
		}
	}
	
}
