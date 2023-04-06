package presentacion;

import logica.CuentaLimitada;

public class Test {

	public static void main(String[] args) {
		CuentaLimitada cl=new CuentaLimitada(100, 70);
		cl.extraer(90);
		System.out.println(cl.getSaldo());
	}

}
