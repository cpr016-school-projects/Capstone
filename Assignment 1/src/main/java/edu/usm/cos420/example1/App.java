package edu.usm.cos420.example1;

import edu.usm.cos420.example1.controller.Controller;
import edu.usm.cos420.example1.service.ExampleService;
import edu.usm.cos420.example1.service.impl.Service1;
import edu.usm.cos420.example1.view.impl.View;

/**
 * Top level application class that coordinates the calls to view and Controller
 *
 */
public class App {
  /**
   * Entry point for application : calls {@link #provideAccess()}
   * 
   * @param args main program arguments, currently not used
   */
  public static void main(String[] args)
    {
		ExampleService service = new Service1();
		View view = new View();
		Controller controller = new Controller(view,service);		
		controller.provideAccess();
    }
}
