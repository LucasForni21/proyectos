package datos;

public class Transaccion {
	

	private int nro_tarjeta;
	private int clave_seguridad;
	private String nombre;
	public Transaccion(int nro_tarjeta, int clave_seguridad, String nombre) {
		super();
		this.nro_tarjeta = nro_tarjeta;
		this.clave_seguridad = clave_seguridad;
		this.nombre = nombre;
	}
	public int getNro_tarjeta() {
		return nro_tarjeta;
	}
	public void setNro_tarjeta(int nro_tarjeta) {
		this.nro_tarjeta = nro_tarjeta;
	}
	public int getClave_seguridad() {
		return clave_seguridad;
	}
	public void setClave_seguridad(int clave_seguridad) {
		this.clave_seguridad = clave_seguridad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Transaccion [nro_tarjeta=" + nro_tarjeta + ", clave_seguridad=" + clave_seguridad + ", nombre=" + nombre
				+ "]";
	}
	
	
	
	
	
	
	
	
}
