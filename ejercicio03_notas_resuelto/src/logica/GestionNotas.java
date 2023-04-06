package logica;

import java.util.ArrayList;

public class GestionNotas {
    private ArrayList<Double> notas;
    
    public GestionNotas(){
        notas=new ArrayList<>();
    }
    public void agregarNota(double d){
    	notas.add(d);
    }
    public  double media(){
        double m=0;
        for(Double n:notas){
            m+=n;
        }
        return m/notas.size();
    }
    public int aprobados(){
        int ap=0;
        for(Double n:notas){
            if(n>=5){
            	ap++;
            }
        }
        return ap;
    }    
}
