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
			FileOutputStream archivo = new FileOutputStream("fichero.doc");
			
			String texto = "OLE OLE";
			
			byte codigo[] = texto.getBytes();
			
			archivo.write(codigo);
			archivo.close();
			
		} catch (IOException e ) {
			e.printStackTrace();
		}
		
	}

}
