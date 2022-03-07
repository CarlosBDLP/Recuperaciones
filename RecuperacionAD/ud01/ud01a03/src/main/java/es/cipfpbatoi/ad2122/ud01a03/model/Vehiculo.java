package es.cipfpbatoi.ad2122.ud01a03.model;

import java.io.Serializable;

public class Vehiculo implements Serializable {
	
	private static final long serialVersionUID = 4440446657094288952L;

	// Tamaño de un registro vehiculo
	public static final int BYTES_LENGHT_VEHICULO = 220;
	
	// Tamaño de los diferentes atributos StringBuilder
	public static final int CHAR_LENGHT_MARCA = 25;  // -> 50bytes 	
	public static final int CHAR_LENGHT_MODELO = 25; // -> 50bytes
	public static final int CHAR_LENGHT_VERSION = 50;// -> 100bytes
	
	// Un atributo entero ocupa 4 bytes
	private int idVehiculo;
	
	private StringBuilder marca;
	private StringBuilder modelo;
	private StringBuilder version;
	
	// Un atributo long ocupa 8 bytes
	private long cilindrada;
	
	// Un atributo double ocupa 8 bytes
	private double potencia;
	
	public Vehiculo() {
		this.marca = new StringBuilder(Vehiculo.CHAR_LENGHT_MARCA);
		this.modelo = new StringBuilder(Vehiculo.CHAR_LENGHT_MODELO);
		this.version = new StringBuilder(Vehiculo.CHAR_LENGHT_VERSION);
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public StringBuilder getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca.insert(0, marca);
		this.marca.setLength(Vehiculo.CHAR_LENGHT_MODELO);
	}

	public StringBuilder getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo.insert(0, modelo);
		this.modelo.setLength(Vehiculo.CHAR_LENGHT_MODELO);
	}

	public StringBuilder getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version.insert(0, version);
		this.version.setLength(Vehiculo.CHAR_LENGHT_VERSION);
	}

	public long getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(long cilindrada) {
		this.cilindrada = cilindrada;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public String prettyPrint() {
		return "id: " + this.idVehiculo + 
				". Producto: " + this.marca + 
				" - " + this.modelo + 
				" - " + this.version;
	}
}

