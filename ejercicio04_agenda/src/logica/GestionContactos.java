package logica;

import java.util.Collection;
import java.util.HashMap;

import beans.Contacto;

public class GestionContactos {
	HashMap<String,Contacto> agenda;
	public GestionContactos(){
		agenda=new HashMap<>();
	}
	public boolean agregar(String nombre, int edad, String email){
		//si no existe, se añade
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
		//crea un array con el tamaño de los existentes
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




}
