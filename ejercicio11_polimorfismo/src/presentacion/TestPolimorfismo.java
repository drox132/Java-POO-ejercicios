package presentacion;

import logica.Circulo;
import logica.Figura;
import logica.Triangulo;

public class TestPolimorfismo {

	public static void main(String[] args) {
		mostrarDatosFiguras(new Triangulo("amarillo",4,8));
		mostrarDatosFiguras(new Circulo("azul",3));

	}
	
	private static void mostrarDatosFiguras(Figura f){
		System.out.println("Color "+f.getColor());
		System.out.println("Superficie "+f.superfice());
	}

}
