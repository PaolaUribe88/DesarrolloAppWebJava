package modelo;

public class Rectangulo {
	 private double altura;
	 private double base;

	//CONSTRUCTORES
	public Rectangulo() {
		
	}
	public Rectangulo(double altura, double base) {
		this.altura = altura;
		this.base = base;
	}
	//CALCULOS METODOS
	public double calcularArea() {
		return base * altura;
	}
	public double calcularPerimetro() {
		return (base*2)+(altura*2);
	}

	//GETTERS Y SETTERS
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}
	
	


}
