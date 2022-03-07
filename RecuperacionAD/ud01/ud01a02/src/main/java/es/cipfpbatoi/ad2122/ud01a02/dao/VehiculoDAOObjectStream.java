package es.cipfpbatoi.ad2122.ud01a02.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import es.cipfpbatoi.ad2122.ud01a02.model.Vehiculo;

import javax.xml.crypto.Data;

public class VehiculoDAOObjectStream {
	
	private File ficheroVehiculos;

	public VehiculoDAOObjectStream(String filePath) {
		this.ficheroVehiculos = new File(filePath);
	}
	
	public void save(Vehiculo vehiculo) throws IOException  {
		
	}
	
	public void save(List<Vehiculo> vehiculos) throws IOException  {
		
	}

	public Vehiculo findById(int idVehiculo) throws IOException {
		
		return null;
	}
	
	public List<Vehiculo> findAll() throws IOException {
		
		List<Vehiculo> vehiculos = new ArrayList<>();
		
		return vehiculos;	
	}

	public List<Vehiculo> findAll2(String marca) throws IOException {

		List<Vehiculo> vehiculos = new ArrayList<>();

		try {
			InputStream inputStream = new FileInputStream(this.ficheroVehiculos);
				DataInputStream dataInputStream = new DataInputStream(inputStream);
			while (dataInputStream.available() > 0){

				Vehiculo vehiculo = new Vehiculo();
				vehiculo.setIdVehiculo(dataInputStream.readInt());
				vehiculo.setMarca(dataInputStream.readUTF());
				vehiculo.setModelo(dataInputStream.readUTF());
				vehiculo.setVersion(dataInputStream.readUTF());
				vehiculo.setCilindrada(dataInputStream.readLong());
				vehiculo.setPotencia(dataInputStream.readDouble());

				if (vehiculo.getMarca().equals(marca))
				vehiculos.add(vehiculo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return vehiculos;
	}



}
