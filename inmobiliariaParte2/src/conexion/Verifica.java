package conexion;

import java.util.LinkedList;
import javax.swing.JOptionPane;


import datos.Usuario;



public class Verifica {
//
	Usuario nuevoUsuario = new Usuario("","","","","",true,1, 0);  //roles -1admin -2propietario -3cliente.
//	
//	
	public LinkedList<Usuario> traerIndiv(int id){
		return nuevoUsuario.traerUsuarioPorId(id);
	}

	public boolean verificarUsuario(String nombre, String apellido, String dni, String email, String clave, int rol){
		int flag = 0;
		do {
			if (dni.length() == 8) {
				if (nombre.length() >= 3 && nombre.length() < 15) {
					if (apellido.length() >= 3 && apellido.length() < 20 ) {
						if (email.contains("@") && email.length() < 60) {
							if (clave.matches(".*[A-Z].*") && clave.matches(".*\\d.*")) { // SI LA CLAVE NO TIENE POR LO MENOS UNA MAYUS Y UN NUMERO, NO FUNCA
								if (rol >= 1 && rol <= 3) {
									
						nuevoUsuario.setNombre(nombre);
						nuevoUsuario.setApellido(apellido);
						nuevoUsuario.setDni(dni);
						nuevoUsuario.setClave(clave);
						nuevoUsuario.setEmail(email);
						nuevoUsuario.setRol(rol);
						JOptionPane.showMessageDialog(null, "Usuario guardado con exito");
						return nuevoUsuario.guardarUsuario();
								} else {
									rol = Integer.parseInt(JOptionPane.showInputDialog("Numero de rol equivocado" + "\nroles:-1admin -2propietario -3cliente."));
									flag++;
								}
							} else {
								clave = JOptionPane.showInputDialog("La clave es incorrecta, Debe tener una letra mayuscula y un numero");
								flag++;
							}
						} else {
							email = JOptionPane.showInputDialog("Error al ingresar el mail, Ingrese un mail valido.");
							flag++;
						}
					} else {
						apellido = JOptionPane.showInputDialog("Error al ingresar el apellido" + "\ndebe tener mas de 3 caracteres");
						flag++;
					}
				} else{
					nombre = JOptionPane.showInputDialog("Error al ingresar el nombre" + "\ndebe tener entre 3 y 15 caracteres");
					flag++;
				}
			} else {
				dni = JOptionPane.showInputDialog("Error al ingresar el dni" + "\ndebe tener 8 o mas numeros.");
				flag++;
				
			}
			
		} while (flag!=0);
		return false;
	}

	
	public LinkedList<Usuario> verificarLista(){
	
	return nuevoUsuario.traerUsuario();
}
	
	
	public boolean eliminarUsuario(int id) {
		
			return nuevoUsuario.eliminarUsuario(id);
		
		}

	public boolean editarUsuario(int id) {
		int flag = 0;
		do {
			String[] editar = {"Editar nombre", "Editar apellido","Editar dni","Editar email","Editar clave","Editar rol","Editar todo","Salir"};
			String opcion = (String)JOptionPane.showInputDialog(null,"Que desea editar","Editar Usuario",JOptionPane.DEFAULT_OPTION,null,editar,editar[0]);
           
			for (Usuario encontrado : nuevoUsuario.traerUsuario()) {
				if (encontrado.getId() == id) {
					Usuario user =  encontrado;
					
			
		 JOptionPane.showMessageDialog(null, user.getNombre() + user.getApellido() + user.getId());
			if (user.getId() > 0) {	
			switch (opcion) {
			case "Editar nombre":  
			String nombre = JOptionPane.showInputDialog("Ingresar el nuevo nombre");
			int conteo = 0;
			do {
			if (nombre.length() >= 3 && nombre.length() < 15) {
				user.setNombre(nombre);
		
				JOptionPane.showMessageDialog(null, "Nombre del usuario Actualizado con exito");
				conteo++;
			} else{
				nombre = JOptionPane.showInputDialog("Error al ingresar el nombre" + "\ndebe tener entre 3 y 15 caracteres");
			}
			}while(conteo == 0);
				break;
			case "Editar apellido":
				String apellido = JOptionPane.showInputDialog("Ingresar el nuevo apellido");
				 conteo = 0;
				do {
					if (apellido.length() >= 3 && apellido.length() < 20 ) {
						user.setApellido(apellido);		
						JOptionPane.showMessageDialog(null, "Apellido de usuario Actualizado con exito");
						conteo++;
					}else { 
						apellido = JOptionPane.showInputDialog("Error al ingresar el apellido" + "\ndebe tener mas de 3 caracteres");
					}
					
				} while (conteo==0);
				break;
				
			case "Editar dni":
				String 	dni = JOptionPane.showInputDialog("Ingresar el nuevo Dni ");
		        conteo = 0;
			 do {
				if(dni.length() == 8) {
					user.setDni(dni);
					JOptionPane.showMessageDialog(null, "Dni del usuario Actualizado con exito");	
					
					conteo++;
				} else {
					dni = JOptionPane.showInputDialog("Error al ingresar el dni" + "\ndebe tener 8 o mas numeros.");
				}
			 }while(conteo == 0);
				break;
			case "Editar email":
				String 	 email = JOptionPane.showInputDialog("Ingresar el nuevo email");
				conteo = 0 ;
				do {
				if (email.contains("@") && email.length() < 60) {
					user.setEmail(email);					
					JOptionPane.showMessageDialog(null, "Email del usuario Actualizado con exito");
					conteo++;
				}else {
					email = JOptionPane.showInputDialog("Error al ingresar el mail, Ingrese un mail valido.");
				}
				}while(conteo == 0);
				break;
			case "Editar clave":
				String  clave = JOptionPane.showInputDialog("Ingresar su nueva clave");
				conteo = 0;
				do {
				if (clave.matches(".*[A-Z].*") && clave.matches(".*\\d.*")) {
					user.setClave(clave);				
					JOptionPane.showMessageDialog(null, "Usuario Actualizado con exito");
					conteo++;
				} else {
					clave = JOptionPane.showInputDialog("La clave es incorrecta, Debe tener una letra mayuscula y un numero");
				}
				}while(conteo == 0);
				break;
			case "Editar rol":
				conteo = 0;
				int rol = Integer.parseInt(JOptionPane.showInputDialog("Ingresar su nuevo rol: " + "\n1-Admin 2-propietario 3-Cliente"));
				do {
				if (rol >= 1 && rol <= 3) {
					user.setRol(rol);				
					JOptionPane.showMessageDialog(null, "Usuario Actualizado con exito");
				conteo++;
				} else {	
					rol = Integer.parseInt(JOptionPane.showInputDialog("Numero de rol equivocado" + "\nroles:-1admin -2propietario -3cliente."));
				}
				}while(conteo == 0);
				break;
			case "Editar todo":
				conteo = 0;
				 String nuevoNombre = JOptionPane.showInputDialog("Ingresar el nuevo nombre");
                 String nuevoApellido = JOptionPane.showInputDialog("Ingresar el nuevo apellido");
                 String nuevoDni = JOptionPane.showInputDialog("Ingresar el nuevo DNI");
                 String nuevoEmail = JOptionPane.showInputDialog("Ingresar el nuevo email");
                 String nuevaClave = JOptionPane.showInputDialog("Ingresar la nueva clave");
                 int nuevoRol = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el nuevo rol:\n1-Admin 2-Propietario 3-Cliente"));
                 do {
                 if (nuevoNombre.length() >= 3 && nuevoNombre.length() < 15
                         && nuevoApellido.length() >= 3 && nuevoApellido.length() < 20
                         && nuevoDni.length() == 8
                         && nuevoEmail.contains("@") && nuevoEmail.length() < 60
                         && nuevaClave.matches(".*[A-Z].*") && nuevaClave.matches(".*\\d.*")
                         && nuevoRol >= 1 && nuevoRol <= 3) {
                	 user.setNombre(nuevoNombre);
                	 user.setApellido(nuevoApellido);
                	 user.setDni(nuevoDni);
                	 user.setEmail(nuevoEmail);
                	 user.setClave(nuevaClave);
                	 user.setRol(nuevoRol);
                    
                     JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito");
                     conteo++;
                 } else {
                     JOptionPane.showMessageDialog(null, "Error en los datos ingresados. Revise las condiciones de cada campo.");
                 }
                 
                 }while(conteo == 0);
				break;
			}
			
			}
			return user.editarUsuario(id);
			 }
			}
			return false;
		
		} while (flag==0);
	
		
	}
	
		
		
	
	}
	
