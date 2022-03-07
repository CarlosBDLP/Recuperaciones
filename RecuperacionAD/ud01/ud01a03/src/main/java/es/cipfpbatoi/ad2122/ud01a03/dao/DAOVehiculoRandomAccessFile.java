package es.cipfpbatoi.ad2122.ud01a03.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import es.cipfpbatoi.ad2122.ud01a03.model.Vehiculo;


public class DAOVehiculoRandomAccessFile {

    private File file;

    public DAOVehiculoRandomAccessFile(String path) throws FileNotFoundException {
        this.file = new File(path);
    }

    public void save(Vehiculo vehiculo) throws IOException {

        try
                (
                        RandomAccessFile randomAccessFile = new RandomAccessFile(this.file, "rw");
                ) {
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.writeInt(vehiculo.getIdVehiculo());
            randomAccessFile.writeChars(vehiculo.getMarca().toString());
            randomAccessFile.writeChars(vehiculo.getModelo().toString());
            randomAccessFile.writeChars(vehiculo.getVersion().toString());
            randomAccessFile.writeLong(vehiculo.getCilindrada());
            randomAccessFile.writeDouble(vehiculo.getPotencia());
        }
    }

    public Vehiculo findById(int idVehiculo) throws IOException {

        try
                (
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                ) {
            while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {

                Vehiculo vehiculo = new Vehiculo();

                vehiculo.setIdVehiculo(randomAccessFile.readInt());

                // Si el identificador del vehiculo no se corresponde con el del vehiculo que buscamos
                // saltamos al siguiente registro, sin leer todos los datos del vehiculo
                if (vehiculo.getIdVehiculo() != idVehiculo) {
                    randomAccessFile.skipBytes(Vehiculo.BYTES_LENGHT_VEHICULO - 4);
                    continue;
                }

                String marca = "";
                for (int i = 0; i < Vehiculo.CHAR_LENGHT_MARCA; i++) {
                    marca = marca + randomAccessFile.readChar();
                }
                vehiculo.setMarca(marca);

                String modelo = "";
                for (int i = 0; i < Vehiculo.CHAR_LENGHT_MODELO; i++) {
                    modelo = modelo + randomAccessFile.readChar();
                }
                vehiculo.setModelo(modelo);

                String version = "";
                for (int i = 0; i < Vehiculo.CHAR_LENGHT_VERSION; i++) {
                    version = version + randomAccessFile.readChar();
                }
                vehiculo.setVersion(version);

                vehiculo.setCilindrada(randomAccessFile.readLong());
                vehiculo.setPotencia(randomAccessFile.readDouble());

                // Como hemos encontrado el vehiculo con el identificador buscado,
                // y hemos leido todos sus datos, lo devolvemos.
                return vehiculo;
            }

            // Si hemos recorrido todo el fichero y no hemos encontrado el vehiculo,
            // devolvemos null
            return null;

        }

    }

    public List<Vehiculo> findByMarca(String marcaBuscada) throws IOException {

        List<Vehiculo> vehiculosconMarca = new ArrayList<>();

        try
                (
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                ) {
            while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {

                Vehiculo vehiculo = new Vehiculo();

                vehiculo.setIdVehiculo(randomAccessFile.readInt());

                // Si el identificador del vehiculo no se corresponde con el del vehiculo que buscamos
                // saltamos al siguiente registro, sin leer todos los datos del vehiculo


                String marcaEncontrada = "";
                for (int i = 0; i < Vehiculo.CHAR_LENGHT_MARCA; i++) {
                    marcaEncontrada += randomAccessFile.readChar();
                }

                if (!marcaEncontrada.trim().equals(marcaBuscada)) {
                    randomAccessFile.skipBytes(Vehiculo.BYTES_LENGHT_VEHICULO - 54);
                    continue;
                }
                vehiculo.setMarca(marcaEncontrada);

                String modelo = "";
                for (int i = 0; i < Vehiculo.CHAR_LENGHT_MODELO; i++) {
                    modelo = modelo + randomAccessFile.readChar();
                }
                vehiculo.setModelo(modelo);

                String version = "";
                for (int i = 0; i < Vehiculo.CHAR_LENGHT_VERSION; i++) {
                    version = version + randomAccessFile.readChar();
                }
                vehiculo.setVersion(version);

                vehiculo.setCilindrada(randomAccessFile.readLong());
                vehiculo.setPotencia(randomAccessFile.readDouble());
                vehiculosconMarca.add(vehiculo);
            }

            return vehiculosconMarca;
        }

    }

    public List<Vehiculo> findByModelo(String modeloAbuscar) throws IOException {

        List<Vehiculo> vehiculosconModelo = new ArrayList<>();

        try
                (
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                ) {


            while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {

                Vehiculo vehiculo = new Vehiculo();

                vehiculo.setIdVehiculo(randomAccessFile.readInt());

                // Si el identificador del vehiculo no se corresponde con el del vehiculo que buscamos
                // saltamos al siguiente registro, sin leer todos los datos del vehiculo


                String marca= "";
                for (int i = 0; i < Vehiculo.CHAR_LENGHT_MARCA; i++) {
                    marca += randomAccessFile.readChar();
                }
                vehiculo.setMarca(marca);


                String modeloEncontrado = "";
                for (int i = 0; i < Vehiculo.CHAR_LENGHT_MODELO; i++) {
                    modeloEncontrado += randomAccessFile.readChar();
                }
                if (!modeloEncontrado.trim().equals(modeloAbuscar)) {
                    randomAccessFile.skipBytes(Vehiculo.BYTES_LENGHT_VEHICULO -104);
                    continue;
                }
                vehiculo.setModelo(modeloEncontrado);

                String version = "";
                for (int i = 0; i < Vehiculo.CHAR_LENGHT_VERSION; i++) {
                    version = version + randomAccessFile.readChar();
                }
                vehiculo.setVersion(version);

                vehiculo.setCilindrada(randomAccessFile.readLong());
                vehiculo.setPotencia(randomAccessFile.readDouble());
                vehiculosconModelo.add(vehiculo);
            }

            return vehiculosconModelo;
        }

    }

    public List<Vehiculo> findByVersion(String versionAbuscar) throws IOException {

        List<Vehiculo> vehiculosconVersion = new ArrayList<>();

        try
                (
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                ) {


            while (randomAccessFile.getFilePointer() < randomAccessFile.length()) {

                Vehiculo vehiculo = new Vehiculo();

                vehiculo.setIdVehiculo(randomAccessFile.readInt());

                // Si el identificador del vehiculo no se corresponde con el del vehiculo que buscamos
                // saltamos al siguiente registro, sin leer todos los datos del vehiculo


                String marca= "";
                for (int i = 0; i < Vehiculo.CHAR_LENGHT_MARCA; i++) {
                    marca += randomAccessFile.readChar();
                }
                vehiculo.setMarca(marca);


                String modelo = "";
                for (int i = 0; i < Vehiculo.CHAR_LENGHT_MODELO; i++) {
                    modelo += randomAccessFile.readChar();
                }
                vehiculo.setModelo(modelo);

                String versionaEncontrar = "";
                for (int i = 0; i < Vehiculo.CHAR_LENGHT_VERSION; i++) {
                    versionaEncontrar += randomAccessFile.readChar();
                }

                if (!versionAbuscar.trim().equals(versionaEncontrar)){
                    randomAccessFile.skipBytes(Vehiculo.BYTES_LENGHT_VEHICULO -154);
                    continue;
                }
                vehiculo.setVersion(versionaEncontrar);

                vehiculo.setCilindrada(randomAccessFile.readLong());
                vehiculo.setPotencia(randomAccessFile.readDouble());
                vehiculosconVersion.add(vehiculo);
            }

            return vehiculosconVersion;
        }

    }
}
