package datos;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Cliente extends Usuario {

	private String id_cliente;

	public Cliente(String nombre, String apellido, String dni, String email, String clave, boolean disponible, int rol,
			String id_cliente, int id) {
		super(nombre, apellido, dni, email, clave, disponible, rol, id);
		this.id_cliente = id_cliente;
	}

	public String getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}

	public void verPublicaciones(LinkedList<Publicacion> listaPublicacion) {

		for (Publicacion publicacion : listaPublicacion) {

			JOptionPane.showMessageDialog(null, this.getNombre() + " " + this.getApellido()
					+ " estas son las publicaciones disponibles: " + publicacion);

		}

	}

	public void crearReserva(LinkedList<Publicacion> listaPublicacion, Publicacion publicacion,LinkedList<Transaccion> listaTarjeta ,Transaccion transaccion) {
		int nro; 
		int clave;
		String nombre;
		int imp;
		
		String zona;
		zona = JOptionPane.showInputDialog("Ingrese zona");

		double precio;
		precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio"));

		int ambientes;
		ambientes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nro de ambientes"));

		if (publicacion.getZona().equalsIgnoreCase(zona) && publicacion.getPrecio() == precio
				&& publicacion.getAmbientes() == ambientes) {

			JOptionPane.showMessageDialog(null, publicacion);

			String crearReserva;

			crearReserva = JOptionPane.showInputDialog("Desea realizar transaccion para poder reservar?");

			switch (crearReserva.toLowerCase()) {
			case "si":
				nro = Integer.parseInt(JOptionPane.showInputDialog("Ingresar numero de tarjeta"));
				clave = Integer.parseInt(JOptionPane.showInputDialog("Ingresar clave"));
				nombre = JOptionPane.showInputDialog("Ingresar nombre que figura en la tarjeta");
				imp = Integer.parseInt(JOptionPane.showInputDialog("Cuanto seria el importe a pagar?"));
				if (nro == transaccion.getNro_tarjeta() && clave == transaccion.getClave_seguridad() && transaccion.getNombre().equalsIgnoreCase(nombre) && imp == publicacion.getPrecio()) {
					
					JOptionPane.showMessageDialog(null, "transaccion Realizada");
					JOptionPane.showMessageDialog(null, "Se ha creado la reserva");
					publicacion.setEstado("Ocupado");
				
			
			}else {
				
				JOptionPane.showMessageDialog(null, "Alsguno de los datos ingresados no son correctos, no se realizo la reserva");
				publicacion.setEstado("Disponible");
				}
				
				break;
			case "no":
				JOptionPane.showMessageDialog(null, "No se ha creado la reserva, hasta luego");
				break;

			default:
				JOptionPane.showMessageDialog(null, "La opcion no es valida");
				break;
			}

			JOptionPane.showMessageDialog(null, publicacion);

		} else {
			JOptionPane.showMessageDialog(null, "No se encontro ninguna publicacion");

		}

	}
	
	public void realizarResena(LinkedList<Resena> listaResena, Cliente cliente) {
		    int calificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la calificaci�n del 1 al 5:"));
		    String comentario = JOptionPane.showInputDialog("Ingrese un comentario: ");
		    
		    Resena resena = new Resena(calificacion, comentario, cliente);
		    listaResena.add(resena);
		}
	
	
	public void verResenas(LinkedList<Resena> listaResena) {

		for (Resena resena : listaResena) {

			JOptionPane.showMessageDialog(null, "estas son las ultimas rese�as realizadas: " + resena);

		}

	}

	
	
	
	}

	


