package logica;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import beans.Contacto;

public class GestionContactos {
	String ruta="c:\\temporal\\contactos.txt";
	public boolean agregar(String nombre, int edad, String email){
		//si no existe, se añade
		if(buscar(email)==null){
			Contacto c=new Contacto(nombre, email, edad);
			try(FileOutputStream fos=new FileOutputStream(ruta,true);
					PrintStream salida=new PrintStream(fos)){
				salida.println(nombre+"|"+edad+"|"+email);
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
			return true;
		}else{
			return false;
		}
	}
	public Contacto buscar(String email){
		Contacto c=null;
		Path pt=Paths.get(ruta);
		try(Stream<String> st=Files.lines(pt)){
			String [] res=st.map(s->s.split("[|]")).filter(d->d[2].equals(email)).findFirst().orElseGet(null);
			if(res!=null){
				c=new Contacto(res[0], res[2], Integer.parseInt(res[1]));
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		
		//devuelve el contacto encontrado, y sino null
		return c;
	}
	public boolean eliminar(String email){
		//recuperamos todos los contactos y volvemos aguardarlos todos
		//salvo el que queremos eliminar
		boolean res=false;
		Contacto[] todos=recuperarContactos();
		try(PrintStream out=new PrintStream(ruta);){
			for(Contacto c:todos){
				//comprueba si hay coincidencia de email antes de guardar
				if(!email.equals(c.getEmail())){
					out.println(c.getNombre()+"|"+c.getEdad()+"|"+c.getEmail());
				}
				else{
					//si hay coincidencia no se guarda, por tanto se pone
					//la variable res a true para indicar que se elimina
					res=true;				
				}
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		return res;

	}
	public Contacto[] recuperarContactos(){
		
				Contacto[] contactos=null;
				Path pt=Paths.get(ruta);
				try(Stream<String> st=Files.lines(pt)){
					contactos=st.map(s->s.split("[|]"))
							.map(d->new Contacto(d[0],d[2],Integer.parseInt(d[1]))).toArray(t->new Contacto[t]);
				}
				
				catch(IOException ex){
					ex.printStackTrace();
				}
				return contactos;

	}




}
