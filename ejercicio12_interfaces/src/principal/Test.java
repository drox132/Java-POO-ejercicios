package principal;


import java.util.ArrayList;

import auxiliar.Proceso;
import logica.Circulo;
import varios.Mesa;

public class Test {

	public static void main(String[] args) {
		operarObjeto(new Circulo("verde",3));
		operarObjeto(new Mesa(2,9));
		

	}
	static void m(int[] a, int ...b){
		
	}
	static void operarObjeto(Proceso pr){
		pr.aumentar(9);
		pr.imprimir();
		pr.firmar();
		
	}
}
