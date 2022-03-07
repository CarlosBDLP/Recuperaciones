package es.cipfpbatoi.ad2122.ud01a03.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import es.cipfpbatoi.ad2122.ud01a03.model.Vehiculo;

@TestMethodOrder(OrderAnnotation.class)
class Practica1Test {

	private final static String FICHERO_GRUPO_1 = "src/test/resources/vehiculos-grupo-1.json";
	private final static String FICHERO_GRUPO_2 = "src/test/resources/vehiculos-grupo-2.json";
	private final static String FICHERO_GRUPO_3 = "src/test/resources/vehiculos-grupo-3.xml";
	private final static String FICHERO_GRUPO_4 = "src/test/resources/vehiculos-grupo-4.xml";

	@BeforeAll
	static void setUp() {
		File ficheroGrupo2 = new File(Practica1Test.FICHERO_GRUPO_2);
		if (ficheroGrupo2.exists()) {
			ficheroGrupo2.delete();
		}

		File ficheroGrupo3 = new File(Practica1Test.FICHERO_GRUPO_3);
		if (ficheroGrupo3.exists()) {
			ficheroGrupo3.delete();
		}

		File ficheroGrupo4 = new File(Practica1Test.FICHERO_GRUPO_4);
		if (ficheroGrupo4.exists()) {
			ficheroGrupo4.delete();
		}
	}

	@Test
	@Order(1)
	void testLoadAndSaveJSon() {
		List<Vehiculo> listaVehiculos = null;

		DAOVehiculoJSonFile daoVehiculoJSonFile = new DAOVehiculoJSonFile(FICHERO_GRUPO_1);
		try {
			listaVehiculos = daoVehiculoJSonFile.findAll();
		} catch (JsonParseException e) {
			fail();
		} catch (JsonMappingException e) {
			fail();
		} catch (IOException e) {
			fail();
		}

		assertEquals(listaVehiculos.size(), 3);

		daoVehiculoJSonFile = new DAOVehiculoJSonFile(FICHERO_GRUPO_2);
		try {
			daoVehiculoJSonFile.save(listaVehiculos);
		} catch (JsonParseException e) {
			fail();
		} catch (JsonMappingException e) {
			fail();
		} catch (IOException e) {
			fail();
		}

		DAOVehiculoXMLFile daoVehiculoXMLFile = new DAOVehiculoXMLFile(FICHERO_GRUPO_3);
		try {
			daoVehiculoXMLFile.save(listaVehiculos);
		} catch (JsonGenerationException e) {
			fail();
		} catch (JsonMappingException e) {
			fail();
		} catch (IOException e) {
			fail();
		}

		try {
			listaVehiculos = daoVehiculoXMLFile.findAll();
		} catch (JsonParseException e) {
			fail();
		} catch (JsonMappingException e) {
			fail();
		} catch (IOException e) {
			fail();
		}

		assertEquals(listaVehiculos.size(), 3);
	}

}
