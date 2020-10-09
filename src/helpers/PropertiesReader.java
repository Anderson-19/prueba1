package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import servlets.*;

public class PropertiesReader {
	
	private static Properties config = new Properties();
    private static InputStream configInput = null;
    
    private static String ruta = "C:/Users/Anderson/Desktop/Anderson/Cursos De Programacion/Curso De Spring/--Codigo--/ProyectoWeb_1/src/helpers/InfoDB.properties";

	public void properties() {
		try {
			configInput = new FileInputStream(ruta);
			config.load(configInput);
			
		}catch(IOException e) {
			System.out.println("ERROR EL PROPERTIER READER: "+e.getMessage());
		}
	}

	public String getValue(String valor) {
		String value;
		value = config.getProperty(valor);
		return value;
	}
}
