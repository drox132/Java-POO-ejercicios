package presentacion;

import java.util.HashSet;

import beans.Movimiento;
import logica.CuentaMovimientos;

public class Test {

	public static void main(String[] args) {
		CuentaMovimientos cm=new CuentaMovimientos(200, 100);
		cm.ingresar(50);
		cm.extraer(70);
		System.out.println(cm.getSaldo());
		HashSet<Movimiento> movimientos=cm.getMovimientos();
		for(Movimiento m:movimientos){
			System.out.println("Cantidad: "+m.getCantidad()+" Tipo: "+m.getTipo());
		}
	}

}
