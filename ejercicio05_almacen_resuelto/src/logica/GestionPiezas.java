package logica;

import java.util.Date;
import java.util.HashSet;

import beans.Pieza;

public class GestionPiezas {
	private HashSet<Pieza> piezas;
	public GestionPiezas(){
		piezas=new HashSet<>();
	}
	public void guardarPieza(String nombre, Date fecha){
		piezas.add(new Pieza(nombre, fecha));
	}
	public void guardarPieza(String nombre){
		piezas.add(new Pieza(nombre, new Date()));
	}
	public HashSet<Pieza> obtenerAntiguas(Date fecha){
		HashSet<Pieza> resultado=new HashSet<>();
		for(Pieza p:piezas){
			//comparamos la fecha absoluta
			if(p.getFechaFabricacion().getTime()<fecha.getTime()){
				resultado.add(p);
			}
		}
		return resultado;
	}
}
