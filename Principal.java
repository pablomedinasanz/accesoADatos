package LeerFicheros;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Principal {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
//			 crea un fichero, salvo que exista y sea de solo lectura.
			FileOutputStream archivo = new FileOutputStream("fichero.dat"); 
//			texto a escribir
			String texto = "OLE OLE";
//			guardamos el String el un array codigo
			byte codigo[] = texto.getBytes();
			Integer.toBinaryString(codigo[0]);
//			se escribe lo guardado en el array
			archivo.write(codigo);
			archivo.close();
			File fichero = new File("fichero.dat");
			System.out.println("Nombre: " + fichero.getName());
			System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
			System.out.println("Ruta relativa: " + fichero.getPath());
			
		} catch (IOException e ) {
			e.printStackTrace();
		}
		
		metodoEscribirBinariosPrimitivos();
		metodoLeerBinarioPrimitivos();
		
//		Pasar de objeto a bytes
		Persona persona1 = new Persona("Pedro", 11);
		
		File fichero = new File("fichero.dat");
		FileOutputStream fos = new FileOutputStream(fichero);
		ObjectOutputStream os = new ObjectOutputStream (fos);
		
		os.writeObject(persona1);  
		os.close();
		
		FileInputStream fis = new FileInputStream(fichero);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Persona objeto = (Persona) ois.readObject();
		System.out.println(objeto.getEdad());
		System.out.println(objeto.getNombre());
		ois.close();
		
			
		
	
	}
	
	private static void metodoEscribirBinariosPrimitivos() {
		String[] nombres = {"ANA", "ALBERTO"};
		int[] edades = {20, 14};
		File fichero = new File("fichero.dat");
		FileOutputStream fos;
		
		
		try {
			fos = new FileOutputStream(fichero);
			DataOutputStream dos = new DataOutputStream(fos);
			
			for (int i = 0; i < edades.length; i++) {
				dos.writeUTF(nombres[i]);
				dos.writeInt(edades[i]);
				
			}
			dos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void metodoLeerBinarioPrimitivos() throws IOException  {
		File fichero = new File("fichero.dat");
		
		FileInputStream fis = new FileInputStream(fichero);
		DataInputStream dis = new DataInputStream(fis);
		String n;
		int e;
		try {
			while(true) { // Se ejecuta siempre hasta que no hay mas info y entonces salta la excepción
				n = dis.readUTF();
				e= dis.readInt();
				System.out.println("Nombre: " + n + " Edad: " + e);
			}
			
		} catch (EOFException ex) {
//			ex.printStackTrace(); NO SE PONE PORQUE VA A SALTAR LA EXCEPCIÓN SI O SI
		
			
		} 
		dis.close();
		
	}
	
	
	
	
	
	

}
