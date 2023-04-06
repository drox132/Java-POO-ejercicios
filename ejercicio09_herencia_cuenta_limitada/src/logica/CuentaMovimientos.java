package logica;

import java.util.HashSet;

import beans.Movimiento;

public class CuentaMovimientos extends CuentaLimitada {
	private HashSet<Movimiento> movs;
	public CuentaMovimientos(double saldo, double limite){
		super(saldo,limite);
		movs=new HashSet<>();
	}
	@Override
	public void extraer(double cantidad) {
		movs.add(new Movimiento(cantidad,"extracción"));
		super.extraer(cantidad);
	}
	@Override
	public void ingresar(double cantidad) {
		movs.add(new Movimiento(cantidad,"ingresar"));
		super.ingresar(cantidad);
	}
	public HashSet<Movimiento> getMovimientos(){
		return movs;
	}
}
