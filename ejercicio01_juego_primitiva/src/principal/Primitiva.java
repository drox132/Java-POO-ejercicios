package principal;

public class Primitiva {

	public static void main(String[] args) {
		int generados=0;
		int[] nums=new int[6];
		int n;
		do{
			//generamos un numero aleatorio entre 1 y 49
			n=(int)(Math.random()*49+1);
			//si no está repetido, lo guardamos en el array
			if(!repetido(n,nums,generados)){
				nums[generados]=n;
				generados++;
			}
		}while(generados<nums.length);
		ordenar(nums);
		mostrar(nums);
	}
	private static boolean repetido(int n, int[] nums, int generados){
		boolean res=false;
		for(int i=0;i<generados;i++){
			if(n==nums[i]){
				res=true;
				break;
			}
		}
		return res;
	}
	private static void ordenar(int [] nums){
		int aux;
		for(int i=0;i<nums.length;i++){
			for(int k=i+1;k<=nums.length;k++){
				if(nums[k]<nums[i]){
					aux=nums[i];
					nums[i]=nums[k];
					nums[k]=aux;
				}
			}
		}
	}
	private static void mostrar(int[] nums){
		for(int num:nums){
			System.out.print(num+", ");
		}
	}

}
