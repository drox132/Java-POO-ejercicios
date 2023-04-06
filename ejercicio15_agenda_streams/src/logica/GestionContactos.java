package logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import beans.Contacto;

public class GestionContactos {
	HashMap<String,Contacto> agenda;
	int i=0;
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

	public Contacto[] recuperarPorEdadMaxima(int edad){
		/*ArrayList<Contacto> auxiliar=new ArrayList<>();
		agenda.forEach((k,v)->{
			if(v.getEdad()<=edad){
				auxiliar.add(v);
			}
		});
		return auxiliar.toArray(new Contacto[0]);*/
		Stream<Contacto> st=agenda.values().stream();
		return st.filter(c->c.getEdad()<=edad).toArray(t->new Contacto[t]);
		
	}
	//indica si existe un contacto con ese nombre
	public boolean existeContacto(String nombre){
		Stream<Contacto> st=agenda.values().stream();
		return st.anyMatch(c->c.getNombre().equals(nombre));
	}
	//devuelve el contacto con más edad
	public Contacto contactoMayor(){
		Stream<Contacto> st=agenda.values().stream();
		return st.max((c1,c2)->c1.getEdad()-c2.getEdad()).get();
	}
	//devuelve el primer contacto que coincida con el nombre
	public Contacto buscarPorNombre(String nombre){
		Stream<Contacto> st=agenda.values().stream();
		return st.filter(c->c.getNombre().equals(nombre)).findFirst().get();
	}
	//devuelve la lista de nombres
	public List<String> recuperarNombres(){
		Stream<Contacto> st=agenda.values().stream();
		return st.map(c->c.getNombre()).collect(Collectors.toList());
	}
	//devuelve la edad media de todos los contactos
	public double edadMedia(){
		Stream<Contacto> st=agenda.values().stream();
		return st.mapToInt(c->c.getEdad()).average().getAsDouble();
	}

}
