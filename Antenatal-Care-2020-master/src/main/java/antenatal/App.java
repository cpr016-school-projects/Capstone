package antenatal;

import java.text.ParseException;

import antenatal.controllers.MenuController;

public class App{
    
    //Entry point for application
    
    public static void main(String[] args) throws ParseException {
    	
    	MenuController homeMenu = new MenuController();
        homeMenu.start();
    }
    
}