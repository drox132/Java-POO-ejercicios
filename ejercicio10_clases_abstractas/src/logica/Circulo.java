package logica;

public class Circulo extends Figura {
	private int radio;
	
	public Circulo(String color, int radio) {
		super(color);
		this.radio = radio;
	}

	@Override
	public double superfice() {
		return Math.PI*radio*radio;
	}

}
