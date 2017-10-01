package compilador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import analizador.Lexico;

public class Principal {


	private String pathSalida = "";
	private ArrayList<String> lineas = new ArrayList<String>();

	public static void main(String args[]) throws IOException {
		Principal programa = new Principal();
		programa.cargarArchivo("D:\\USB\\Analizador Lexico\\Ejemplo\\texto.txt");
	}

	public Principal() {
		
	}
	
	public void cargarArchivo(String archivoEntrada) throws IOException {
		FileReader reader = new FileReader(archivoEntrada);
		BufferedReader bufferedReader = new BufferedReader(reader);
		while (bufferedReader.ready()) {
			this.lineas.add(bufferedReader.readLine());
		}
		String textEntrada = "";
		int index = 0;
		for (String linea : this.lineas) {
			//System.out.println(index + " " + linea + "\n");
			index++;
		}
		analizar();
	}

	public void analizar() throws IOException{
		lexico();
	}

	private void lexico() {
		Lexico lexico = new Lexico();
		int index = 0;
		for (String linea : this.lineas) {
		//	System.out.println("////////////////////////////////////////////////////////");
		//	System.out.println("Linea numero " + index + " --> " + linea + "\n");//linea
		//	System.out.println("LEXEMA		" + "TOKEN");
		//	System.out.println("________________________"+"\n");
			lexico.analizarLinea(linea);
			index++;
		}
	}
}
