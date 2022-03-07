package es.cipfpbatoi.ad2122.ud01a02.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import es.cipfpbatoi.ad2122.ud01a02.model.Vehiculo;

@TestMethodOrder(OrderAnnotation.class)
class DAOVehiculoIOStreamTest {
	
	private final static String FICHERO_GRUPO_1 = "src/test/resources/vehiculos-grupo-1.dat";
	private final static String FICHERO_GRUPO_2 = "src/test/resources/vehiculos-grupo-2.dat";
	
	@BeforeAll
	static void setUp() {
		File ficheroGrupo1 = new File(DAOVehiculoIOStreamTest.FICHERO_GRUPO_1);
		if(ficheroGrupo1.exists()) {
			ficheroGrupo1.delete();
		}
		
		File ficheroGrupo2 = new File(DAOVehiculoIOStreamTest.FICHERO_GRUPO_2);
		if(ficheroGrupo2.exists()) {
			ficheroGrupo2.delete();
		}
	}

	@Test
	@Order(1)
	void testPersistirUnVehiculo() {

		Vehiculo vehiculo = new Vehiculo();
    	vehiculo.setIdVehiculo(1);
    	vehiculo.setMarca("Citroen");
    	vehiculo.setModelo("C4");
    	vehiculo.setVersion("Cool");
    	vehiculo.setCilindrada(1500);
    	vehiculo.setPotencia(92.0);

    	VehiculoDAODataStream daoVehiculo = new VehiculoDAODataStream(DAOVehiculoIOStreamTest.FICHERO_GRUPO_1);
    	try {
			daoVehiculo.save(vehiculo);
		} catch (IOException e) {
			fail("El test debería haber almacenado el vehiculo");
		}
	}
	
	@Test
	@Order(2)
	void testLeerUnVehiculo() {
		
		VehiculoDAODataStream daoVehiculo = new VehiculoDAODataStream(DAOVehiculoIOStreamTest.FICHERO_GRUPO_1);
    	
    	Vehiculo vehiculo = null;
		try {
			vehiculo = daoVehiculo.findById(1);
		} catch (IOException e1) {
			fail("El test debería haber leido el vehiculo");
		}
		
		assertEquals(vehiculo.getIdVehiculo(), 1);
		assertEquals(vehiculo.getMarca(), "Citroen");
		assertEquals(vehiculo.getModelo(), "C4");
		assertEquals(vehiculo.getVersion(), "Cool");
		assertEquals(vehiculo.getCilindrada(), 1500);
		assertEquals(vehiculo.getPotencia(), 92.0);
	}
	
	@Test
	@Order(3)
	void testPersistirVariosVehiculos() {
		
		List<Vehiculo> vehiculos = new ArrayList<>();
		
		Vehiculo vehiculo = new Vehiculo();
    	vehiculo.setIdVehiculo(1);
    	vehiculo.setMarca("Citroen");
    	vehiculo.setModelo("C4");
    	vehiculo.setVersion("Cool");
    	vehiculo.setCilindrada(1500);
    	vehiculo.setPotencia(92.0);
    	
    	vehiculos.add(vehiculo);

    	vehiculo = new Vehiculo();
    	vehiculo.setIdVehiculo(2);
    	vehiculo.setMarca("Seat");
    	vehiculo.setModelo("Leon");
    	vehiculo.setVersion("Sport");
    	vehiculo.setCilindrada(1900);
    	vehiculo.setPotencia(150.0);

    	vehiculos.add(vehiculo);
    	
    	VehiculoDAODataStream daoVehiculo = new VehiculoDAODataStream(DAOVehiculoIOStreamTest.FICHERO_GRUPO_2);
    	try {
			daoVehiculo.save(vehiculos);
		} catch (IOException e) {
			fail("El test debería haber almacenado el vehiculo");
		}
	}
	
	@Test
	@Order(4)
	void testLeerVariosVehiculo() {
		VehiculoDAODataStream daoVehiculo = new VehiculoDAODataStream(DAOVehiculoIOStreamTest.FICHERO_GRUPO_2);
    	
		Vehiculo vehiculo = null;
		try {
			vehiculo = daoVehiculo.findById(1);
		} catch (IOException e1) {
			fail("El test debería haber leido el vehiculo");
		}
		
		assertEquals(vehiculo.getIdVehiculo(), 1);
		assertEquals(vehiculo.getMarca(), "Citroen");
		assertEquals(vehiculo.getModelo(), "C4");
		assertEquals(vehiculo.getVersion(), "Cool");
		assertEquals(vehiculo.getCilindrada(), 1500);
		assertEquals(vehiculo.getPotencia(), 92.0);
		
		try {
			vehiculo = daoVehiculo.findById(2);
		} catch (IOException e1) {
			fail("El test debería haber leido el vehiculo 2s");
		}
		
		assertEquals(vehiculo.getIdVehiculo(), 2);
		assertEquals(vehiculo.getMarca(), "Seat");
		assertEquals(vehiculo.getModelo(), "Leon");
		assertEquals(vehiculo.getVersion(), "Sport");
		assertEquals(vehiculo.getCilindrada(), 1900);
		assertEquals(vehiculo.getPotencia(), 150.0);
	}
}
