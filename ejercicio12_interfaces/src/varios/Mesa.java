package varios;

import auxiliar.Proceso;

public class Mesa implements Proceso {
	private int ancho, largo;
	
	public Mesa(int ancho, int largo) {
		super();
		this.ancho = ancho;
		this.largo = largo;
	}

	@Override
	public void imprimir() {
		System.out.println("El ancho es "+ancho+" el largo es "+largo);

	}

	@Override
	public void aumentar(int c) {
		ancho+=c;
		largo+=c;

	}

}
