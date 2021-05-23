package edu.usm.cos420.example1.view.impl;

import java.util.Date;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

/* 
 * View class 
 *    A Command line User Interface which displays menu of Customer options to user and collects 
 *    the user choice.  
 * 
 */

public class View{
 
	  /** {@value}  : no choice selected by user */
    public static final int NO_CHOICE = 0;

  	/** {@value #ADDCUS}  : Add customer */
    public static final int ADDCUS = 1;
    /** {@value #ADDITEM}  : Add item */
    public static final int ADDITEM = 2;
    /** {@value #ADDSTOCK}  : Add stock to item */
    public static final int ADDSTOCK = 3;
    /** {@value #PLACEORD}  : Place an order */
    public static final int PLACEORD = 4;
    /** {@value #DISPLAYORD}  : Display Orders */
    public static final int DISPLAYORD = 5;
    /** {@value #DISPLAYINV}  : Display inventory */
    public static final int DISPLAYINV = 6;
    /** {@value #DISPLAYCUS}  : Display Customers */
    public static final int DISPLAYCUS = 7;
    /** {@value #EXIT}  : Exit */
    public static final int EXIT = 9;

    /** {@value #ADD_ORDER_ITEM}  : Add item to order */
    public static final int ADD_ORDER_ITEM = 10;
    /** {@value #ENDORDER}  : End the order */
    public static final int ENDORDER = 11;


    private Scanner in; 
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
 
    /**
     * Default constructor for the view
     */
    public View()
  {
	  in = new Scanner(System.in);  
  }
  /**
   * Constructor with input scanner
   * @param input scanner
   */
   public View(Scanner input)
   {
	  this.in = input;
   }
   
  /**
   * Display top level menu.
   */
  public void displayMenu () {
    System.out.println();
    System.out.println("Enter the number denoting the action " +
                       "to perform:");
    System.out.println("ADD Customer................" + ADDCUS);
    System.out.println("ADD Inventory..............." + ADDITEM);
    System.out.println("ADD Stock..................." + ADDSTOCK);
    System.out.println("PLACE Order................." + PLACEORD);
    System.out.println("DISPLAY Orders for Customer." + DISPLAYORD);
    System.out.println("DISPLAY Inventory..........." + DISPLAYINV);
    System.out.println("DISPLAY Customers..........." + DISPLAYCUS);
    System.out.println("Exit........................" + EXIT);
  }
  /**
   * Display Order menu
   */
  public void menuOrder () {
    System.out.println();
    System.out.println("Enter the number denoting the action " +
                       "to perform:");
    System.out.println("ADD Order Item.............." + ADD_ORDER_ITEM);
    System.out.println("End Order..................." + ENDORDER);           
  }
  

  /**
   * Read in an int
   * @param prompt Text asking user to enter int
   * @return int
   *  
   */
  public int readIntWithPrompt (String prompt) {
    System.out.print(prompt); 
    System.out.flush();
    while (!in.hasNextInt()) {
      System.out.println("Wrong format: Numbers only.");
      in.next();
      System.out.print(prompt); 
      System.out.flush();
    }
    int choice = in.nextInt();
    //consume newline char
    in.nextLine();
    return choice;
  }
  /**
   * Read in a Long
   * @param prompt text asking user to input a long
   * @return long
   */
  public Long readIDWithPrompt (String prompt) {
    System.out.print(prompt); 
    System.out.flush();
    Long id = 0L;
    boolean passed = false;

    //input validation
    //also check that the ID isn't negative
    while (passed == false) {
      if (in.hasNextLong()) {
        id = in.nextLong();
        if (id <= 0) {
          System.out.println("Wrong format: Non-negative numbers only.");
          System.out.print(prompt); 
          System.out.flush();
        } else {
          passed = true;
        }
      } else {
        System.out.println("Wrong format: Non-negative numbers only.");
        in.next();
        System.out.print(prompt); 
        System.out.flush();
      }
    }

    //consume newline char
    in.nextLine();
    return id;
  }

  /**
   * Read in a single word
   * @param prompt text asking user to input a word
   * @return word
   */
  public String readStringWithPrompt (String prompt) {
    System.out.print(prompt); 
    System.out.flush();
    String str = in.next();
    while (!(Pattern.matches("^[a-zA-Z0-9]*$", str)) || (str.isEmpty() || str.isBlank())) {
      System.out.println("Wrong format: Alphanumeric only.");
      System.out.print(prompt); 
      System.out.flush();
      str = in.next();
    }

    //consume newline char
    in.nextLine();
    return str;
  }

  /**
   * Read in a date 
   * @param prompt text asking user for a date
   * @return date
   */
  public Date readDateWithPrompt (String prompt) {
    System.out.print(prompt); 
    System.out.flush();
    Date temp = null;
    String str = in.next();
    boolean passed = false;

    //input validation
    do {
      try {
        temp = sdf.parse(str);
        passed = true;
      } catch (ParseException e) {
        System.out.println("Please enter a valid date. Format: yyyy-MM-dd");
        str = in.next(); 
        System.out.flush();
      }
    } while (passed == false);

    //consume newline char
    in.nextLine();
    return temp;
  }

  /**
   * Read in a full line of text 
   * @param prompt ask user to inut text
   * @return line
   */
  public String readLineWithPrompt (String prompt) {
    System.out.print(prompt); 
    System.out.flush();
    String str = in.nextLine();

    while ((str.isEmpty() || str.isBlank())) {
      System.out.println("Please input text.");
      System.out.print(prompt); 
      System.out.flush();
      str = in.nextLine();
    }
    return str;
  }
  
}
