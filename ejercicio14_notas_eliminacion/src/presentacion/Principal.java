package presentacion;

import java.util.Scanner;

import logica.GestionNotas;

public class Principal {

	public static void main(String[] args) {
		GestionNotas gnotas=new GestionNotas();
		int op; //opción elegida por el usuario
		Scanner sc=new Scanner(System.in);
		double nota;
		do{
			//presentamos menú
			System.out.println("1.- Añadir nota");
			System.out.println("2.- Ver media");
			System.out.println("3.- Ver aprobados");
			System.out.println("4.- Mostrar ordenados");
			System.out.println("5.- Borrar suspensos");
			System.out.println("6.- Salir");
			op=Integer.parseInt(sc.nextLine());
			switch(op){
				case 1:
					System.out.println("Introduce nota:");
					nota=Double.parseDouble(sc.nextLine());
					gnotas.guardarNota(nota);
					break;
				case 2:
					System.out.println("Media actual: "+gnotas.media());
					break;
				case 3:
					System.out.println("Aprobados: "+gnotas.aprobados());
					break;
				case 4:
					Double[] todas=gnotas.recuperarNotas();
					for(Double d:todas){
						System.out.print(d+",");
					}
					System.out.println("");
					break;
				case 5:
					gnotas.eliminarSuspensos();
			}
			
		}while(op!=6);

	}

}
