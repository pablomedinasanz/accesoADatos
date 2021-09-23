package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ficheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fichero = null;
		crearFicheroYEscribir(fichero);
	}
	
	public static void crearFicheroYEscribir(File file) {
		
		
		
		try {
//			 crea un fichero, salvo que exista y sea de solo lectura.
			FileOutputStream archivo = new FileOutputStream("fichero.doc"); 
//			texto a escribir
			String texto = "OLE OLE";
//			guardamos el String el un array codigo
			byte codigo[] = texto.getBytes();
//			se escribe lo guardado en el array
			archivo.write(codigo);
			archivo.close();
			
		} catch (IOException e ) {
			e.printStackTrace();
		}
		
	}

}
