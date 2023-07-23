package ar.com.codoacodo.domain;

public class Empleado {

	private Long dni;
	private String nombre;
	private String apellido;
	private Long dptoId;
	
	public Empleado(Long dni, String nombre, String apellido, Long dptoId) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dptoId = dptoId;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
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

	public Long getDptoId() {
		return dptoId;
	}

	public void setDptoId(Long dptoId) {
		this.dptoId = dptoId;
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", depto=" + dptoId + "]";
	}
}
