package logica;

import java.util.Collection;
import java.util.HashMap;

import beans.Contacto;

public class GestionContactos {
	private HashMap<String,Contacto> contactos;
	
	public GestionContactos(){
		contactos=new HashMap<>();
	
	}
	
	public boolean agregar(String nombre, int edad, String email){
		//si no existe, se añade
		if(!contactos.containsKey(email)){
			Contacto c=new Contacto(nombre, edad, email);
			contactos.put(email, c);
			return true;
		}else{
			return false;
		}
	}
	public Contacto buscar(String email){
		Contacto c=null;
		if(contactos.containsKey(email)){
			c=contactos.get(email);
		}
		//devuelve el contacto encontrado, y sino null
		return c;
	}
	public boolean eliminar(String email){
		if(contactos.containsKey(email)){
			contactos.remove(email);
			return true;
		}else{
			return false;
		}
	}
	public Contacto[] recuperarContactos(){
		//crea un array con el tamaño de los existentes
		//y vuelca en el los contactos almacenados
		Contacto[] existentes=new Contacto[contactos.size()];
		int i=0;
		Collection<Contacto> valores=contactos.values();
		for(Contacto con:valores){
			existentes[i]=con;
			i++;
		}
		return existentes;
	}
}
