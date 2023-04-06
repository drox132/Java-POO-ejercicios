package logica;

import java.util.ArrayList;

public class GestionNotas {
	ArrayList<Double> notas;
	public GestionNotas(){
		notas=new ArrayList<>();
	}
	public void guardarNota(double n){
		notas.add(n);
	}
	public double media(){
		double media=0;
		for(double d:notas){
			media+=d;
		}
		return media/notas.size();
	}
	public int aprobados(){
		int ap=0;
		for(double d:notas){
			if(d>=5){
				ap++;
			}
		}
		return ap;
	}
	public Double[] recuperarNotas(){
		notas.sort((a,b)->(int)(a-b));
		return notas.toArray(new Double[0]);	
	}
	public void eliminarSuspensos(){
		notas.removeIf(n->n<5);
	}
}
