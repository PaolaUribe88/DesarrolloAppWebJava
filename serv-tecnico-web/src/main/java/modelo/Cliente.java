package modelo;

public class Cliente {
	private int id;
	private String nombre;
	private int telefono;
	private String direccion;
	
	//CONSTRUCTOR VACIO
	
	public Cliente() {
		
	}
	//CONSTRUCTOR SIN ID
	public Cliente(String nombre, int telefono, String direccion) {
		
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	//CONSTRUCTOR COMPLETO
	public Cliente(int id, String nombre, int telefono, String direccion) {
		
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	//GETTERS Y SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	
}
