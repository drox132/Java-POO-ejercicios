package presentacion;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

import beans.Pieza;
import logica.GestionPiezas;

public class Principal {

	public static void main(String[] args) {
		GestionPiezas gestor=new GestionPiezas();
		Scanner sc=new Scanner(System.in);
		int op, dia, mes, ano;
		String nombre;
		do{
			System.out.println("1.- Anadir pieza");
	        System.out.println("2.- Piezas antiguas");
	        System.out.println("3.- Salir");
	        op=Integer.parseInt(sc.nextLine());
	        switch(op){
		        case 1:
		        	System.out.println("Nombre pieza:");
		        	nombre=sc.nextLine();
		        	System.out.println("Año fabricación:");
		        	ano=Integer.parseInt(sc.nextLine());
		        	System.out.println("Mes fabricación(1-12):");
		        	mes=Integer.parseInt(sc.nextLine());
		        	System.out.println("Día fabricación:");
		        	dia=Integer.parseInt(sc.nextLine());
		        	//creamos un Calendar con los datos de fecha 
		        	//introducidos
		        	Calendar cal=Calendar.getInstance();
		        	cal.set(ano, mes-1, dia);
		        	//pasamos la fecha al método como un objeto Date
		        	gestor.agregarPieza(nombre, cal.getTime());
		        	break;
		        case 2:
		        	System.out.println("Año fabricación:");
		        	ano=Integer.parseInt(sc.nextLine());
		        	System.out.println("Mes fabricación(1-12):");
		        	mes=Integer.parseInt(sc.nextLine());
		        	System.out.println("Día fabricación:");
		        	dia=Integer.parseInt(sc.nextLine());
		        	//creamos un Calendar con los datos de fecha 
		        	//introducidos
		        	Calendar cal2=Calendar.getInstance();
		        	//Se resta 1 en el mes porque van de 0 a 11
		        	cal2.set(ano, mes-1, dia);
		        	HashSet<Pieza> piezas=gestor.obtenerAntiguas(cal2.getTime());
		        	//recorremos las piezas recuperadas y mostramos la fecha 
		        	//formateada
		        	for(Pieza p:piezas){
		        		DateFormat df=DateFormat.getDateInstance(DateFormat.FULL, new Locale("ES","es"));
		        		System.out.println(p.getNombre()+" - "+df.format(p.getFechaFabricacion()));
		        	}
		        	break;
		        	
	        }
		}while(op!=3);


	}

}
