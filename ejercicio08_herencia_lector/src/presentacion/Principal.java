package presentacion;

import java.io.IOException;

import logica.Lector;

public class Principal {

	public static void main(String[] args) {
		Lector lc=new Lector();
		try{
			

			System.out.println("Nombre: ");
			String n=lc.readLine();
			System.out.println("Edad: ");
			int edad=lc.readInt();
			System.out.println("Te llamas "+n+" tienes "+edad+" años");
		}
		catch(IOException ex){
			ex.printStackTrace();
		}


	}

}
