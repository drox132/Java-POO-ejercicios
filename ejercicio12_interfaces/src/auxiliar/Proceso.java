package auxiliar;

public interface Proceso {
	void imprimir();
	void aumentar(int c);
	default void firmar(){
		System.out.println(this.toString());
	}
}
