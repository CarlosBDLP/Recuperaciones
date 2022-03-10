package es.cipfpbatoi.ad2122.ud01a03.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import es.cipfpbatoi.ad2122.ud01a03.model.Vehiculo;

@TestMethodOrder(OrderAnnotation.class)
class DAOVehiculoRandomAccessFileTest {

    // TODO hacer los test

    private final static String FICHERO_GRUPO_1 = "src/test/resources/vehiculos-grupo-1.dat";

    @BeforeAll
    static void setUp() {
        File ficheroGrupo1 = new File(DAOVehiculoRandomAccessFileTest.FICHERO_GRUPO_1);
        if (ficheroGrupo1.exists()) {
            ficheroGrupo1.delete();
        }

        // RandomAccessFile espera que el fichero exista.
        try {
            ficheroGrupo1.createNewFile();
        } catch (IOException e) {
            fail();
        }
    }


    @Test
    @Order(1)
    void testPersistirUnVehiculo() {

        try {
            DAOVehiculoRandomAccessFile daoVehiculo = new DAOVehiculoRandomAccessFile(DAOVehiculoRandomAccessFileTest.FICHERO_GRUPO_1);
            daoVehiculo.save(this.crearVehiculo(1, "Citroen", "C2", "cool", 1500, 92.0));
            daoVehiculo.save(this.crearVehiculo(2, "Citroen", "C3", "cool", 1500, 92.0));
            daoVehiculo.save(this.crearVehiculo(3, "Citroen", "C4", "cool", 1500, 92.0));
            daoVehiculo.save(this.crearVehiculo(4, "Citroen", "C5", "cool", 1500, 92.0));
            daoVehiculo.save(this.crearVehiculo(5, "Citroen", "C6", "cool", 1500, 92.0));
            daoVehiculo.save(this.crearVehiculo(6, "Seat", "Ibiza", "cool", 1500, 92.0));
            daoVehiculo.save(this.crearVehiculo(7, "Seat", "Leon", "cool", 1500, 92.0));
            daoVehiculo.save(this.crearVehiculo(8, "Seat", "Panda", "cool", 1500, 92.0));
            daoVehiculo.save(this.crearVehiculo(9, "Seat", "Arola", "cool", 1500, 92.0));
            daoVehiculo.save(this.crearVehiculo(10, "Dacia", "loga", "cool", 1500, 92.0));

        } catch (IOException e) {
            fail("El test debería haber almacenado el vehiculo");
        }
    }


    private Vehiculo crearVehiculo(int id, String marca, String modelo, String version, long cilindrada, double potencia) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setIdVehiculo(id);
        vehiculo.setMarca(marca);
        vehiculo.setModelo(modelo);
        vehiculo.setVersion(version);
        vehiculo.setCilindrada(cilindrada);
        vehiculo.setPotencia(potencia);
        return vehiculo;
    }

    @Test
    @Order(2)
    void testLeerUnVehiculo() {

        Vehiculo vehiculo = null;

        DAOVehiculoRandomAccessFile daoVehiculo = null;
        try {
            daoVehiculo = new DAOVehiculoRandomAccessFile(DAOVehiculoRandomAccessFileTest.FICHERO_GRUPO_1);
        } catch (FileNotFoundException e) {
            fail("El test debería haber leido el vehiculo");
        }

        try {
            vehiculo = daoVehiculo.findById(1);
        }  catch (IOException e) {
            fail("El test debería haber leido el vehiculo");
        }

        assertEquals(vehiculo.getIdVehiculo(), 1);
        assertEquals(vehiculo.getMarca().toString().trim(), "Citroen");
        assertEquals(vehiculo.getModelo().toString().trim(), "C2");
        assertEquals(vehiculo.getVersion().toString().trim(), "cool");
        assertEquals(vehiculo.getCilindrada(), 1500);
        assertEquals(vehiculo.getPotencia(), 92.0);

        try {
           vehiculo = daoVehiculo.findById(2);
        } catch (FileNotFoundException e) {
            fail("El test debería haber leido el vehiculo");
        } catch (IOException e) {
            fail("El test debería haber leido el vehiculo");
        }


        assertEquals(vehiculo.getIdVehiculo(), 2);
        assertEquals(vehiculo.getMarca().toString().trim(), "Citroen");
        assertEquals(vehiculo.getModelo().toString().trim(), "C3");
        assertEquals(vehiculo.getVersion().toString().trim(), "cool");
        assertEquals(vehiculo.getCilindrada(), 1500);
        assertEquals(vehiculo.getPotencia(), 92.0);

        try {
            vehiculo = daoVehiculo.findById(100);
        } catch (FileNotFoundException e) {
            fail("El test debería haber leido el vehiculo");
        } catch (IOException e) {
            fail("El test debería haber leido el vehiculo");
        }

        assertNull(vehiculo);
    }

    @Test
    @Order(3)
    void comparamarca() {

        List<Vehiculo> vehiculosconMarca = null;

        DAOVehiculoRandomAccessFile daoVehiculo = null;
        try {
            daoVehiculo = new DAOVehiculoRandomAccessFile(DAOVehiculoRandomAccessFileTest.FICHERO_GRUPO_1);
        } catch (FileNotFoundException e) {
            fail("El test debería haber leido el vehiculo");
        }


        try {
            vehiculosconMarca = daoVehiculo.findByMarca("Citroen");
        } catch (IOException e) {
            fail("El test debería haber leido el vehiculo");
        }

        //TODO
        // busca como ejercicios de como recorrer arrays


        assertEquals(vehiculosconMarca.size(), 4);

//        assertEquals(vehiculo.getIdVehiculo(), 2);
//        assertEquals(vehiculo.getMarca().toString().trim(), "Citroen");
//        assertEquals(vehiculo.getModelo().toString().trim(), "C3");
//        assertEquals(vehiculo.getVersion().toString().trim(), "cool");
//        assertEquals(vehiculo.getCilindrada(), 1500);
//        assertEquals(vehiculo.getPotencia(), 92.0);


    }


}
