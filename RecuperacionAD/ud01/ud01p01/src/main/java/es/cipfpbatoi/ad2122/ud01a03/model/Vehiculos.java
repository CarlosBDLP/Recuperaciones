package es.cipfpbatoi.ad2122.ud01a03.model;

import java.io.Serializable;
import java.util.List;

public class Vehiculos implements Serializable{
	
	private static final long serialVersionUID = 662104049253026740L;
	
	private List<Vehiculo> vehiculos;
	
	public Vehiculos() {
		
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
}
