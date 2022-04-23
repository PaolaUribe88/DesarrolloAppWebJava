package modelo;


public class Circulo {

	private double diametro;
	
	//CONSTRUCTORES
	public Circulo() {
		
	}
	public Circulo(double diametro) {
		
		this.diametro = diametro;
	}
	
		//METODOS EN CLASE
	public double calcularAreaC() {
		double radio = this.calcularRadio();
		return Math.PI * Math.pow(radio,2);
	}
	public double calcularRadio() {
		return this.diametro / 2;
	}
	public double calcularPerimetro() {
		return Math.PI * this.diametro;
	}

	//GETTERS Y SETTERS

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	

	
	
}
