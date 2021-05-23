package edu.usm.cos420.example1.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import edu.usm.cos420.example1.domain.Customer;
import edu.usm.cos420.example1.domain.Item;
import edu.usm.cos420.example1.domain.Order;
import edu.usm.cos420.example1.service.ExampleService;
import edu.usm.cos420.example1.view.impl.View;

/**
 * A Controller class to execute user's menu choice. List of possible choices
 * can be found at {@link edu.usm.cos420.example1.view.TextUI}
 * 
 */
public class Controller {

	private ExampleService atMyService;
	private View view;

	/**
	 * Constructor : pass in a service class which can provide access to cItem
	 * operations.
	 * 
	 * @param view
	 * @param service
	 */
	public Controller(View view, ExampleService service) {
		this.view = view;
		this.atMyService = service;
	}

	/**
	 * Allow the user to access the collection
	 */
	public void provideAccess() {
		int choice = View.NO_CHOICE;
		while (choice != View.EXIT) {
			view.displayMenu();
			choice = view.readIntWithPrompt("Enter choice: ");
			executeChoice(choice);
		}
	}

	/**
	 * Allow the user to add orders
	 */
	public void provideOrderAccess() {
		int choiceOrder = View.NO_CHOICE;
		// get customer id and date for the order
		Long customerId = view.readIDWithPrompt("Enter Customer ID for Order: ");
		if (customerId == null) {
			System.out.println("Error: Customer Not Found.");
		}
		Long orderId = view.readIDWithPrompt("Enter new Unique ID for Order: ");
		Date currDate = new Date();

		// create the order,
		// add the orderID to Customer
		atMyService.placeOrder(customerId, orderId, currDate);

		// enter loop to add items to the order
		ArrayList<Long[]> items = new ArrayList<Long[]>();
		while (choiceOrder != View.ENDORDER) {
			// display the order menu
			view.menuOrder();
			choiceOrder = view.readIntWithPrompt("Enter choice: ");
			switch (choiceOrder) {
				case View.ADD_ORDER_ITEM:
					Long itemID = view.readIDWithPrompt("Enter Item ID: ");
					// note: Needs to be Long for Long[] below. 
					//Also, i DO want to use readID rather than readInt then convert to long,
					// because I do not want amt to be negative. 
					Long amt = view.readIDWithPrompt("Enter Amount: ");
					// check to see if the item exists and is in stock
					Item temp = atMyService.findItem(itemID);
					if (temp == null) {
						System.out.println("Item '" + itemID + "' not found. Item skipped.");
					} else {
						if ((temp.getStock() - amt) < 0) {
							System.out.println("There is only '" + temp.getStock() + "' of this item left. Please try again.");
						} else {
							// add the items to the arrayList
							Long[] toAdd = { itemID, amt };
							items.add(toAdd);
						}
					}
					break;
				case View.ENDORDER:
					break;
			}
		}
		// convert arrayList to array, add to orders.
		if (!(items.isEmpty())) {
			Long[][] array = new Long[items.size()][2];
			for (int i = 0; i < items.size(); i++) {
				array[i][0] = items.get(i)[0];
				array[i][1] = items.get(i)[1];
			}
			atMyService.addOrderItems(orderId, array);
		}
	}

	/**
	 * Performs the branching logic to call appropriate functions to satisfy user
	 * choice
	 * 
	 * @param choice represents the user selection of action they want accomplished.
	 */
	public void executeChoice(int choice) {
		System.out.println();
		switch (choice) {
			case View.NO_CHOICE:{
				break;}

			case View.ADDCUS:{
				Long cusId = view.readIDWithPrompt("Enter Customer ID: ");
				String name = view.readLineWithPrompt("Enter Name: ");
				String address = view.readLineWithPrompt("Enter Address: ");
				
				atMyService.addCustomer(cusId, name, address);
				break;}
			case View.ADDITEM:{
				Long itemId = view.readIDWithPrompt("Enter Item ID: ");
				String description = view.readLineWithPrompt("Enter Description: ");
				atMyService.addItem(itemId, description);
				break;}
			case View.ADDSTOCK:{
				Long id = view.readIDWithPrompt("Enter Target Item ID: ");
				if (id == null) {
					System.out.println("Item Not Found.");
					break;
				}
				int amt = view.readIntWithPrompt("Enter Amount(negative to subtract): ");
				atMyService.addStock(id, amt);
				break;}
			case View.PLACEORD:{
				provideOrderAccess();
				break;}
			case View.DISPLAYORD:{
				Long cusId = view.readIDWithPrompt("Enter Customer ID: ");
				Date begin = view.readDateWithPrompt("Enter Begin Date(yyyy-MM-dd) for range: ");
				Date end = view.readDateWithPrompt("Enter End Date(yyyy-MM-dd) for range: ");			

				ArrayList<Order> orders = atMyService.displayOrders(cusId, begin, end);
				// check to see if orders is valid
				if (!(orders.isEmpty())) {
					System.out.println();
					System.out.println("Customer Name: " + atMyService.findCustomer(cusId).getName());
					System.out.println("Orders:");
					for(Order ord : orders) {
						System.out.println();
						System.out.println("Order ID: " + ord.getID());
						System.out.println("   Date Placed: " + ord.getDate());
						System.out.printf("   Items Ordered(amt): ");
						Long[][] items = ord.getItems();
						for (int i = 0; i < items.length; i++) {
							// print item, amount ordered, and commas if necessary
							if (!(i == items.length - 1)) {
								System.out.printf(items[i][0] + "(" + items[i][1] + ")" + ", ");
							} else {
								System.out.printf(items[i][0] + "(" + items[i][1] + ")");
							}
						}
					}
					System.out.println();
				} else {
					System.out.println("There are no orders for this customer.");
				}
				break;}
			case View.DISPLAYINV:{
				List<Item> items = atMyService.displayInventory();
				System.out.println("Current Inventory:");

				//iterate through and display
				for (Item item : items) {
					System.out.println();
					System.out.println("Item ID: " + item.getID());
					System.out.println("   Description: " + item.getDescription());
					System.out.println("   Stock: " + item.getStock());
				}
				break;}
			case View.DISPLAYCUS:{
				List<Customer> customers = atMyService.displayCustomers();
				System.out.println("Customers:");

				//iterate through and display
				for (Customer customer : customers) {
					System.out.println();
					System.out.println("Customer ID: " + customer.getID());
					System.out.println("   Name: " + customer.getName());
					System.out.println("   Address: " + customer.getAddress());
					System.out.printf("   Orders: ");
					Long[] orders = customer.getOrders();
					for (int i = 0; i < orders.length; i++) {
						if (!(i == orders.length -1)) {
							System.out.printf(orders[i] + ", ");
						} else {
							System.out.printf("%d", orders[i]);
						}
					}
				}
				break;}
			case View.EXIT:{
				System.out.println("Goodbye");
				break;}
		}
	} 
}
