package modelo;

public class Electrodomestico {
	private int id;
	private String nombre;
	private String tipo;
	private String descripcionProblema;
	private Cliente cliente_id;
	
	//CONSTRUCTOR VACIO
	public Electrodomestico() {
	
	}
	//CONSTRUCTOR SIN CLIENTE
	public Electrodomestico(int id, String nombre, String tipo, String descripcionProblema) {
		
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcionProblema = descripcionProblema;
	}

	//CONSTRUCTOR COMPLETO
	public Electrodomestico(int id, String nombre, String tipo, String descripcionProblema, Cliente cliente_id) {
		
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcionProblema = descripcionProblema;
		this.cliente_id = cliente_id;
	}
	
	public Electrodomestico(String nombreE, String tipo, String descripcionProblema, Cliente cliente) {
		this.nombre = nombreE;
		this.tipo = tipo;
		this.descripcionProblema = descripcionProblema;
		this.cliente_id = cliente_id;
	}
	//GETTER AND SETTERS
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcionProblema() {
		return descripcionProblema;
	}
	public void setDescripcionProblema(String descripcionProblema) {
		this.descripcionProblema = descripcionProblema;
	}
	public Cliente getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Cliente cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	
}
