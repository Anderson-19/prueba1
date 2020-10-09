package controllers;

import java.security.MessageDigest;

import helpers.*;

public class RegisterController {
    private static PropertiesReader prop = new PropertiesReader();
    private static ConnectionDB DB = new ConnectionDB();
     		
    public RegisterController() {
    	prop.properties();
    	DB.conexion();	
    }
    
   static public String register(String name, String email, String pass) {
	   
		String Password = pass ; 
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		    md.update(Password.getBytes());
		    byte[] hashPassword = md.digest();
	
	        Object[] obj = {name, email, hashPassword.toString()};
        	DB.dbPrepareStatement(prop.getValue("q1"), obj);
        	
            return "{\"message\": \"user created\", \"status\": 200 }";
        }catch (Exception e) {
        	System.out.println("Conexion NO Exitosa"+e.getMessage());
        	e.printStackTrace();
            return"{\"message\": \"user already exist\", \"status\": 503 }";
        }
    }

}
