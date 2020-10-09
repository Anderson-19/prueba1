package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDB {
	
	private PropertiesReader pr = new PropertiesReader();
	
	//Conexion con la base dates
	private  Connection connect = null;
								
	//Datos para la conexion
	private String driver,url,usuario,pass;
	
	//CONSULTA
	private PreparedStatement query = null;
	
	public ConnectionDB() {
		pr.properties();	
		driver = pr.getValue("driver");
		url = pr.getValue("url");
		pass = pr.getValue("pass");
		usuario = pr.getValue("usuario");
	}
	
	public Connection conexion() {
		try {
			Class.forName(driver);
			connect = DriverManager.getConnection(url, usuario,pass);
		} catch (SQLException | ClassNotFoundException e) {
			return null;
		}
		return  connect ;	}

	public void dbPrepareStatement(String value, Object[]obj) {
		try {
			query = connect.prepareStatement(value);
			query.setString(1, (String) obj[0]);
			query.setString(2, (String) obj[1]);
			query.setString(3, (String) obj[2]);
			query.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
