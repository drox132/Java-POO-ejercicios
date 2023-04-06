package logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import beans.Contacto;

public class GestionContactos {
	private String ruta="c:\\temporal\\contactos.txt";
	
	
	
	public boolean agregar(String nombre, int edad, String email){
		//si no existe, se añade
		boolean res=false;
		//si no existe el contacto, crea una nueva entrada en el fichero
		//con los datos del mismo, separados por |
		if(buscar(email)==null){
			try(FileOutputStream fos=new FileOutputStream(ruta,true);
				PrintStream out=new PrintStream(fos);){
				out.println(nombre+"|"+edad+"|"+email);
				res=true;
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return res;
	}
	public Contacto buscar(String email){
		Contacto c=null;	
		try(BufferedReader bf=new BufferedReader(new FileReader(ruta));){
			String s;
			//recorre todas las filas y si el campo email, que es el tercero
			//coincide con el email recibido, entonces crea un Contacto
			//y lo devuelve
			while((s=bf.readLine())!=null){
				String[] datos=s.split("[|]");
				if(datos[2].equals(email)){
					c=new Contacto(datos[0], Integer.parseInt(datos[1]),datos[2]);
					break;
				}
			}
		}
		catch(FileNotFoundException ex){
			
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
					res=true;				}
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		return res;
	}
	
	public Contacto[] recuperarContactos(){
		//recupera los contactos y los guarda en una colección
		//ArrayList que luego trasforma en array
		ArrayList<Contacto> existentes=new ArrayList<>();
		Contacto c=null;
		try(BufferedReader bf=new BufferedReader(new FileReader(ruta));){
			String s;
			while((s=bf.readLine())!=null){
				String[] datos=s.split("[|]");
				c=new Contacto(datos[0], Integer.parseInt(datos[1]),datos[2]);
				existentes.add(c);
			}
		}
		catch(FileNotFoundException ex){
			
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		//el método toArray devuelve un array con los elementos de la colección
		//requiere que se le pase como parámetro un array vacío
		return existentes.toArray(new Contacto[0]);
	}
}
