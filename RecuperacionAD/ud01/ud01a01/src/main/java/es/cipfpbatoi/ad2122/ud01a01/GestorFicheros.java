package es.cipfpbatoi.ad2122.ud01a01;

import java.io.File;
import java.io.FileFilter;

public class GestorFicheros {

	public boolean printIsFileOrDir(String path) {
		
		File f = new File(path);
		
		if(!f.exists()) {
			System.out.println(path + " no existe en el disco.");
			return false;
		}
		
		if(f.isFile()) {
			System.out.println(path + " es un fichero.");
			return true;
		}
		
		if(f.isDirectory()) {
			System.out.println(path + " es un directorio.");
			return false;
		}
		
		return false;
	}

	public File getCurrentPath() {
		return new File("");
	}
	
	public void printPaths(File file) {
		System.out.println("Ruta absoluta: " + file.getAbsolutePath());
		
		File padre = file.getParentFile();
		System.out.println("Directorio padre: " + padre.getAbsolutePath());
	}

	public boolean isHidden(String path) {
		
		File f = new File(path);
		
		if(!f.exists()) {
			System.out.println(path + " no existe en el disco.");
			return false;
		}
		
		if(f.isHidden()) {
			System.out.println(path + " está oculto.");
			return true;
		}
		
		System.out.println(path + " es visible.");
		return false;
		
	}

	public void getPermission(String path) {

		File file = new File(path);
		
		System.out.println("Podemos leer: " + file.canRead());
		System.out.println("Podemos escribir: " + file.canWrite());
		System.out.println("Podemis ejecutar: " + file.canExecute());

	}

	public void listDir(String path) {
		
		File file = new File(path);
		for(String pathHijo : file.list()) {
			
			File fileHijo = new File(pathHijo);
			
			if(fileHijo.isFile()) {
				System.out.println(pathHijo + " es un fichero.");
			}
			if(fileHijo.isDirectory()) {
				System.out.println(pathHijo + " es un directorio.");
			}
			
		}
	}
	
	public void listHiddenFilesInDir(String path) {
		
		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File fileFiltered) {
				if(!fileFiltered.isFile()) {
					return false;
				}
				if(!fileFiltered.isHidden()) {
					return false;
				}
				return true;
			}
		};
		
		File file = new File(path);
		for(File pathHijo : file.listFiles(fileFilter)) {
			System.out.println(pathHijo.getAbsolutePath());
		}
	}
	
	public void doDemo(String[] args) {
		this.listHiddenFilesInDir("");
	}
}
