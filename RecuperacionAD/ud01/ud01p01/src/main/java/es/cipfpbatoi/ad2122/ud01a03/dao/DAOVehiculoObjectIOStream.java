package es.cipfpbatoi.ad2122.ud01a03.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import es.cipfpbatoi.ad2122.ud01a03.model.Vehiculo;


public class DAOVehiculoObjectIOStream {
	
	private File file ;

	public DAOVehiculoObjectIOStream(String path) throws FileNotFoundException {
		this.file = new File(path);
	}
	
	public void save(List<Vehiculo> vehiculo) throws IOException {
		
		
	}

	public List<Vehiculo> findAll() throws IOException {

		return null;
	}

}
