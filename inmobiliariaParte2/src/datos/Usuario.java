package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;



import conexion.Conexion;

public class Usuario {

	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private String clave;
	private boolean disponible;
	private int rol;
	private int id;
	
	 Conexion con =  new Conexion();
	    Connection conexion = con.conectar();
	    PreparedStatement stmt;
	
	public Usuario(String nombre, String apellido, String dni, String email, String clave,boolean disponible,int rol, int id) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.clave = clave;
		this.disponible = disponible;
		this.rol = rol;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
 
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", email=" + email + ", clave="
				+ clave + ", disponible=" + disponible + ", rol=" + rol + ", id=" + id + "\n";
	}

	public boolean guardarUsuario(){
		 
		String sql = "INSERT INTO `usuario` (`nombre`, `apellido`, `dni`, `email`, `clave`, `disponible`, `rol`) VALUES (?, ?, ?, ?, ?, ?, ?)";

				
			try {
			      stmt = conexion.prepareStatement(sql);
		          stmt.setString(1, this.getNombre());
		          stmt.setString(2, this.getApellido());
		          stmt.setString(3, this.getDni());
		          stmt.setString(4, this.getEmail());
		          stmt.setString(5, this.getClave());
		          stmt.setBoolean(6, this.disponible);
		          stmt.setInt(7, this.getRol());
		          stmt.executeUpdate();

		          return true;
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
		
				return false;		
			}		
		}
	
	public LinkedList<Usuario> traerUsuario(){
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();  
		
String sql = "SELECT * FROM `usuario` ";
		String[] datos =  new String[8];
	try {
	      stmt = conexion.prepareStatement(sql);
         ResultSet result = stmt.executeQuery();
         while (result.next()) {
           datos[0] = result.getString(1);
           datos[1] = result.getString(2);
           datos[2] = result.getString(3);
           datos[3] = result.getString(4);
           datos[4] = result.getString(5);
           datos[5] = String.valueOf(result.getBoolean(6));    
           datos[6] = String.valueOf(result.getInt(7));
           datos[7] = String.valueOf(result.getInt(8));
           
           usuarios.add(new Usuario(datos[0],datos[1],datos[2],datos[3],datos[4],Boolean.parseBoolean(datos[5]),Integer.parseInt(datos[6]),Integer.parseInt(datos[7])));
        	 
		}
         return usuarios;

		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return null;		
	}	
	}
	
	public LinkedList<Usuario> traerUsuarioPorId(int id) {
	    LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	    String sql = "SELECT * FROM `usuario` WHERE id = ?";
	    String[] datos = new String[8];
	    try {
	        stmt = conexion.prepareStatement(sql);
	        stmt.setInt(1, id); // aca va el id que queremos buscar
	        ResultSet result = stmt.executeQuery();
	        while (result.next()) {
	            datos[0] = result.getString(1);
	            datos[1] = result.getString(2);
	            datos[2] = result.getString(3);
	            datos[3] = result.getString(4);
	            datos[4] = result.getString(5);
	            datos[5] = String.valueOf(result.getBoolean(6));
	            datos[6] = String.valueOf(result.getInt(7));
	            datos[7] = String.valueOf(result.getInt(8));

	            usuarios.add(new Usuario(
	                datos[0], datos[1], datos[2], datos[3], datos[4],
	                Boolean.parseBoolean(datos[5]), Integer.parseInt(datos[6]), Integer.parseInt(datos[7])
	            ));
	        }
	        return usuarios;
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        return null;
	    }
	}

	
	
	public boolean eliminarUsuario(int id){
		 
		String sql = "	DELETE FROM `usuario` WHERE id = ? ";		
			try {
			      stmt = conexion.prepareStatement(sql);
		          stmt.setInt(1, id);;
		          stmt.executeUpdate();
		          return true;			
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;				
			 }		
			}
	
	public boolean editarUsuario(int id){
		 
		String sql = "	UPDATE `usuario` SET `nombre`=?,`apellido`=?,`dni`=?,`email`=?,`clave`=?,`disponible`=?,`rol`=? WHERE id = ? ";		
			try {
			      stmt = conexion.prepareStatement(sql);
		          stmt.setString(1, this.getNombre());
		          stmt.setString(2, this.getApellido());
		          stmt.setString(3, this.getDni());
		          stmt.setString(4, this.getEmail());
		          stmt.setString(5, this.getClave());
		          stmt.setBoolean(6, this.isDisponible());
		          stmt.setInt(7, this.getRol());
		          stmt.setInt(8, id);
		          stmt.executeUpdate();
		          return true;			
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;				
			 }		
			}
	
	
	
}
