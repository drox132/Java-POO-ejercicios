package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Lector extends BufferedReader{
	public Lector(Reader in){
		super(in);
	}
	public Lector(){
		super(new InputStreamReader(System.in));
	}
	public int readInt() throws IOException{
		return Integer.parseInt(super.readLine());
	}
}
