package interfaz;

import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;

import conexion.Verifica;
import datos.Administrador;
import datos.Cliente;
import datos.Propietario;
import datos.Publicacion;
import datos.Resena;
import datos.Transaccion;
import datos.Usuario;

public class Main {

	public static void main(String[] args) {
	

		// INGRESAR DATO A LA BASE DE DATO
		Verifica verifica = new Verifica();
	
		
		
	   
//	  	ACA EMPIEZA EL PROGRAMA 
	
					String bienvenida;
		do {
		
		
		    String[] bien = {"Iniciar Sesion","Crear Usuario","Salir del sistema"}; 
			bienvenida = (String)JOptionPane.showInputDialog(null,"Opciones de menu","Bienvenido a HouseHunters",JOptionPane.DEFAULT_OPTION,null,bien,bien[0]);
		
			switch (bienvenida) {
			case "Iniciar Sesion": // SISTEMA
	  
				if (verifica.verificarLista().isEmpty()) {
				    JOptionPane.showMessageDialog(null, "La lista se encuentra vacía");
				} else {
				    boolean validacionLogin = false;
				     Usuario usuarioLogueado = null;

				    do {
				        String email = JOptionPane.showInputDialog("Ingrese mail");
				        String clave = JOptionPane.showInputDialog("Ingresar clave");
				        for (Usuario usuario : verifica.verificarLista()) {
				            if (usuario.getEmail().equals(email) && usuario.getClave().equals(clave)) {
				            	validacionLogin = true;	                
				            	usuarioLogueado = usuario;
				            }
				        }
				        if (!validacionLogin) {
				            JOptionPane.showMessageDialog(null, "El email o la clave es incorrecta, ingrese nuevamente");
				        }
				       
				    } while (!validacionLogin);
				    
				    String rol = null; //Verifica el rol 
				    if (usuarioLogueado.getRol() == 1) {
						rol = "Administrador";
					} else if (usuarioLogueado.getRol() == 2) {
						rol = "Propietario";
					} else if (usuarioLogueado.getRol() == 3) {
						rol = "Cliente";
					}
				    
				    JOptionPane.showMessageDialog(null, "Ha ingresado correctamente" + "\nID: " + usuarioLogueado.getId() +"\nNombre: " + usuarioLogueado.getNombre() + " " + usuarioLogueado.getApellido() + "\nRol: " + rol );
				 
			  
				   switch(usuarioLogueado.getRol()){
				   case 1:   // ROL ADMIN
					   JOptionPane.showMessageDialog(null, "Ingreso el administrador: " + usuarioLogueado.getNombre());
					   String[] panelAdmin = {"Eliminar usuario","Editar usuario","Visualizar usuario","Cerrar sesion"};
					   String opcionesAdmin;
					   do {
						opcionesAdmin = (String)JOptionPane.showInputDialog(null,"Opciones administrador"," Panel administrador ",JOptionPane.DEFAULT_OPTION,null,panelAdmin,panelAdmin[0]);
						   switch(opcionesAdmin){
						   case "Eliminar usuario":  // ELIMINAR USUARIO ADMIN
							   
							   
							   JOptionPane.showMessageDialog(null, "Eliminar");
							   boolean userEncontrado = false;
							   do {
								 if (verifica.verificarLista().isEmpty()) {
		 						JOptionPane.showMessageDialog(null, "No se puede eliminar usuarios porque la lista esta vacia");
								
								 }else {
										int id = Integer.parseInt(JOptionPane.showInputDialog("Escriba el ID que desea eliminar"));
									  for (Usuario usuario : verifica.verificarLista()) {
										Usuario buscado =  usuario;
									
										if(buscado.getId() == id){
											userEncontrado = true;
											JOptionPane.showMessageDialog(null, "Usuario que desea eliminar: " + "\n " + buscado);  
											int aceptar = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
											if (aceptar == JOptionPane.YES_OPTION) {
												verifica.eliminarUsuario(id);
												JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
												
											} else if (aceptar == JOptionPane.NO_OPTION) {
												JOptionPane.showMessageDialog(null, "No se ha eliminado");
											}
											break;
										}
									}
									}
									  if (!userEncontrado) {
											JOptionPane.showMessageDialog(null, "El id no existe en la base de datos");		
										}
									}while(userEncontrado == false);
							   break;
							   
						   case "Editar usuario":
							    JOptionPane.showMessageDialog(null, "Editar Usuario"); // EDITAR USUARIO ADMIN
							    boolean usuarioEncontrado;
							    do {
							        int id = Integer.parseInt(JOptionPane.showInputDialog("Escriba el ID que desea editar"));
							        usuarioEncontrado = false;
							        for (Usuario usuario : verifica.verificarLista()) {
							            if (usuario.getId() == id) {
							                usuarioEncontrado = true;
							                verifica.editarUsuario(id);
							            }
							        }
							        if (!usuarioEncontrado) {
							            JOptionPane.showMessageDialog(null, "El ID no existe en la base de datos");
							        }
							    } while (!usuarioEncontrado);
							    break;

						   case "Visualizar usuario":  // VISUALIZAR USUARIO ADMIN
							   JOptionPane.showMessageDialog(null, "visualizar");
							   
								boolean teEncontre;
								do {
							     int id = Integer.parseInt(JOptionPane.showInputDialog("Ingresar id: "));
							       teEncontre = false;
							      for (Usuario usuario: verifica.traerIndiv(id)) {
							    	  Usuario buscado = usuario; // esto crea un objeto de la persona que ingresamos el id, y se puede usar get y set
									if (usuario.getId() == id) {
										teEncontre = true;
								
										JOptionPane.showMessageDialog(null,  verifica.traerIndiv(id) + buscado.getNombre());	
									};
							      };	
										if(!teEncontre) {
											JOptionPane.showMessageDialog(null, "El id no existe en la base de datos");			
										}
								}while(teEncontre == false );
								
							   break;
						   
						   };
						   
					} while (!opcionesAdmin.equals("Cerrar sesion"));
					   break;
				   case 2: //ROL PROPIETARIO
					   JOptionPane.showMessageDialog(null, "Ingreso el propietario: " + usuarioLogueado.getNombre());
					   break;
				   case 3: //ROL CLIENTE
					   JOptionPane.showMessageDialog(null, "Ingreso el cliente: " + usuarioLogueado.getNombre());
					   break;
				   }
				
	
				}


			   
				break;
			   
			
			case "Crear Usuario":
				String crearNombre = JOptionPane.showInputDialog("Ingresar el nombre");
				String crearApellido = JOptionPane.showInputDialog("Ingresar el Apellido");
				String crearDni = JOptionPane.showInputDialog("Ingresar Dni ");
				String crearEmail = JOptionPane.showInputDialog("Ingresar  email");
				String crearClave = JOptionPane.showInputDialog("Ingresar su clave");
				int crearRol = Integer.parseInt(JOptionPane.showInputDialog("Ingresar su rol: " + "\n1-Admin 2-propietario 3-Cliente"));
				verifica.verificarUsuario( crearNombre, crearApellido, crearDni, crearEmail, crearClave, crearRol);		
				break;
			}

				
		}while(!bienvenida.equals("Salir del sistema"));

					
					
					
						
						
						
	}

}
