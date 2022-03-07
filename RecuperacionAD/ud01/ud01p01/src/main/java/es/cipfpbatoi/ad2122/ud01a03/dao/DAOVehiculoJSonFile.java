package es.cipfpbatoi.ad2122.ud01a03.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import es.cipfpbatoi.ad2122.ud01a03.model.Vehiculo;

/***
 * 
 * @author jorge
 * 
 * Clase para:
 *  La carga de datos desde ficheros JSon
 *  El almacenamiento de datos en ficheros JSon
 *  
 *  Para mas información, visitar https://www.baeldung.com/jackson-object-mapper-tutorial
 *
 */
public class DAOVehiculoJSonFile {
	
	private File file ;

	public DAOVehiculoJSonFile(String path) {
		this.file = new File(path);
	}
	
	public void save(List<Vehiculo> listaVehiculos) throws JsonGenerationException, JsonMappingException, IOException {
		
	}

	public List<Vehiculo> findAll() throws JsonParseException, JsonMappingException, IOException {
		return null;
	}

}
