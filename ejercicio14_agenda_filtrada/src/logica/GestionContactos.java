package logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import beans.Contacto;

public class GestionContactos {
	HashMap<String,Contacto> agenda;
	int i=0;
	public GestionContactos(){
		agenda=new HashMap<>();
	}
	public boolean agregar(String nombre, int edad, String email){
		//si no existe, se a�ade
		if(!agenda.containsKey(email)){
			Contacto c=new Contacto(nombre, email, edad);
			agenda.put(email, c);
			return true;
		}else{
			return false;
		}
	}
	public Contacto buscar(String email){
		Contacto c=null;
		if(agenda.containsKey(email)){
			c=agenda.get(email);
		}
		//devuelve el contacto encontrado, y sino null
		return c;
	}
	public boolean eliminar(String email){
		if(agenda.containsKey(email)){
			agenda.remove(email);
			return true;
		}else{
			return false;
		}
	}
	public Contacto[] recuperarContactos(){
		//crea un array con el tama�o de los existentes
		//y vuelca en el los contactos almacenados
		Contacto[] existentes=new Contacto[agenda.size()];
		int i=0;
		Collection<Contacto> valores=agenda.values();
		for(Contacto con:valores){
			existentes[i]=con;
			i++;
		}
		return existentes;
	}

	public Contacto[] recuperarPorEdadMaxima(int edad){
		ArrayList<Contacto> auxiliar=new ArrayList<>();
		agenda.forEach((k,v)->{
			if(v.getEdad()<=edad){
				auxiliar.add(v);
			}
		});
		return auxiliar.toArray(new Contacto[0]);
	}

}
