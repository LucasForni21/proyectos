package conexion;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {

	Connection con;
public Connection conectar(){

	try {
          Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inmobiliaria","root","");
		System.out.println("Se conecto");
	} catch (Exception e) {
	  System.out.println("Hubo un error al conectarse a la base de datos" +  e.getMessage());
	}
	
     return con;
}

}