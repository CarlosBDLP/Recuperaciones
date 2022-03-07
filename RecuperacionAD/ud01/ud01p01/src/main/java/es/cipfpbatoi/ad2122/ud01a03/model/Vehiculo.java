package es.cipfpbatoi.ad2122.ud01a03.model;

import java.io.Serializable;

public class Vehiculo implements Serializable {
	
	private static final long serialVersionUID = 8532798861414954907L;

	private int idVehiculo;
	
	private String marca;
	private String modelo;
	private String version;
	
	private long cilindrada;
	private double potencia;
	
	public Vehiculo() {
	}

	public int getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public long getCilindrada() {
		return this.cilindrada;
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

