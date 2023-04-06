package principal;

public class Primitiva {

	public static void main(String[] args) {
        int[] numeros=new int[6];
        int generados=0;
        do{
            //generamos un numero aleatorio entre 1 y 49
            int num=(int)(Math.random()*49+1);
            //si el numero no est� repetido
            //lo guardamos en la posici�n que le corresponde
            if(!repetido(numeros,num,generados)){
                numeros[generados++]=num;               
            }
        }while(generados<numeros.length);//repetimos la operaci�n mientras haya sitio en el array
        ordenar(numeros);
        mostrar(numeros);
    }
    
    private static boolean repetido(int[] valores, int num,int generados){
        boolean resultado=false;
        for(int i=0;i<generados;i++){
            //si encontramos el n�mero en el array, dejamos de comprobar
            //porque significa que est� repetido
            if(num==valores[i]){
                resultado=true;
                break;
            }
        }
        return resultado;
    }
    //ordena el array de menor a mayor siguiendo el m�todo
    //de la burbuja
    private static void ordenar(int[] valores){
    	int aux;
    	
    	for(int i=0;i<valores.length;i++){
    		for(int k=i;k<valores.length;k++){
    			if(valores[k]<valores[i]){
    				//sustituci�n o intercambio
    				aux=valores[i];
    				valores[i]=valores[k];
    				valores[k]=aux;
    			}
    		}
    	}

    }
    private static void mostrar(int[] valores){
        for(int num:valores){
            System.out.print(num+", ");
        }
    }


}
