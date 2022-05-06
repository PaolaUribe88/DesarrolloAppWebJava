package modelo;

import java.time.LocalDate;

public class Orden {
	private int id;
	private String estado;
	private LocalDate fechaSolicitud;
	private LocalDate fechaUltimaActualizacion;
	private Electrodomestico electrodomestico_id;
	
	
	
	//CONSTRUCTOR VACIO
	public Orden() {
	
	}
	
	//CONSTRUCTOR COMPLETO
	public Orden(int id, String estado, LocalDate fechaSolicitud,
			LocalDate fechaUltimaActualizacion) {
		
		this.id = id;
		this.estado = estado;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;

	}
	public Orden(int id, String estado, LocalDate fechaSolicitud, LocalDate fechaUltimaActualizacion,
			Electrodomestico electrodomestico_id) {
		this.id 					 = id;
		this.estado					 = estado;
		this.fechaSolicitud 		 = fechaSolicitud;
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
		this.electrodomestico_id 	 = electrodomestico_id;
	}
	//GETERS AND SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public LocalDate getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(LocalDate fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public Electrodomestico getElectrodomestico_id() {
		return electrodomestico_id;
	}

	public void setElectrodomestico_id(Electrodomestico electrodomestico_id) {
		this.electrodomestico_id = electrodomestico_id;
	}



	
	
	

}
