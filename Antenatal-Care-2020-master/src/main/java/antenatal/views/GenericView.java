package antenatal.views;

import java.util.List;
import java.util.Scanner;

/**
 * 
 * A command line user interface which displays the menu of antental care options, and input/output operations
 *
 */


public class GenericView {
    
    public static final int EXIT = 0;
    public static final int ADD_VISIT = 1;
    public static final int DISPLAY_VISIT = 2;
    public static final int DISPLAY_PATIENT = 3;
    
	
	// Object to read menu choices
	protected Scanner in;
	/**
	 * Default constructor
	 */
	public GenericView() {
		this.in = new Scanner(System.in);
	}
	/**
	 * Constructor that takes in a scanner
	 * @param input: scanner to tie to this GenericView instance
	 */
	public GenericView(Scanner input)
	{
		this.in = input;
	}
	
	public void displayMenu() {
	    System.out.println();
	    System.out.println("Enter the number denoting the action to perform");
	    System.out.println("Add visit.......... "+ADD_VISIT);
	    System.out.println("Display visit.......... "+DISPLAY_VISIT);
	    System.out.println("Display patient.......... "+DISPLAY_PATIENT);
	    System.out.println("Exit.......... "+EXIT);
	    
	}
	
	public void write(String input) {
	    System.out.print(input);
	}
	
	public int readIntWithPrompt(String prompt) {
	    System.out.print(prompt);
	    System.out.flush();
	    String input = in.nextLine();
	    if(!input.matches("[0-3]")) {
	        return -1;
	    }else {
	        return Integer.parseInt(input);
	    }
	}
}
