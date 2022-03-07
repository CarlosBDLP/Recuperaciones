package es.cipfpbatoi.ad2122.ud01a02.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import es.cipfpbatoi.ad2122.ud01a02.model.Vehiculo;

public class VehiculoDAODataStream {
	
	private File ficheroVehiculos;

	public VehiculoDAODataStream(String filePath) {
		this.ficheroVehiculos = new File(filePath);
	}
	
	public void save(Vehiculo vehiculo) throws IOException  {
		
		try 
		(
			OutputStream outputStream = new FileOutputStream(this.ficheroVehiculos, true);
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		)
		{
			dataOutputStream.writeInt(vehiculo.getIdVehiculo());
			dataOutputStream.writeUTF(vehiculo.getMarca());
			dataOutputStream.writeUTF(vehiculo.getModelo());
			dataOutputStream.writeUTF(vehiculo.getVersion());
			dataOutputStream.writeLong(vehiculo.getCilindrada());
			dataOutputStream.writeDouble(vehiculo.getPotencia());
		}
		
	}
	
	public void save(List<Vehiculo> vehiculos) throws IOException  {
		
		try 
		(
			OutputStream outputStream = new FileOutputStream(this.ficheroVehiculos, true);
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		)
		{
			for(Vehiculo vehiculo: vehiculos){
				dataOutputStream.writeInt(vehiculo.getIdVehiculo());
				dataOutputStream.writeUTF(vehiculo.getMarca());
				dataOutputStream.writeUTF(vehiculo.getModelo());
				dataOutputStream.writeUTF(vehiculo.getVersion());
				dataOutputStream.writeLong(vehiculo.getCilindrada());
				dataOutputStream.writeDouble(vehiculo.getPotencia());
			}
		}
		
	}
	


	public Vehiculo findById(int idVehiculo) throws IOException {
		
		try 
		(
			InputStream inputStream = new FileInputStream(this.ficheroVehiculos);
			DataInputStream dataInputStream = new DataInputStream(inputStream);
		)
		{
		
			while (dataInputStream.available() > 0) {
				
				Vehiculo vehiculo = new Vehiculo();
				
				vehiculo.setIdVehiculo(dataInputStream.readInt());
				vehiculo.setMarca(dataInputStream.readUTF());
				vehiculo.setModelo(dataInputStream.readUTF());
				vehiculo.setVersion(dataInputStream.readUTF());
				vehiculo.setCilindrada(dataInputStream.readLong());
				vehiculo.setPotencia(dataInputStream.readDouble());
				
				if (vehiculo.getIdVehiculo() == idVehiculo) {
					return vehiculo;	
				}
			}
			
			return null;
			
		}	
	}
	
	public List<Vehiculo> findAll() throws IOException {
		
		List<Vehiculo> vehiculos = new ArrayList<>();
		
		try 
		(
			InputStream inputStream = new FileInputStream(this.ficheroVehiculos);
			DataInputStream dataInputStream = new DataInputStream(inputStream);
		)
		{
			while (dataInputStream.available() > 0) {
				
				Vehiculo vehiculo = new Vehiculo();
				
				vehiculo.setIdVehiculo(dataInputStream.readInt());
				vehiculo.setMarca(dataInputStream.readUTF());
				vehiculo.setModelo(dataInputStream.readUTF());
				vehiculo.setVersion(dataInputStream.readUTF());
				vehiculo.setCilindrada(dataInputStream.readLong());
				vehiculo.setPotencia(dataInputStream.readDouble());
				
				vehiculos.add(vehiculo);
			}

			return vehiculos;	
		}	
	}
	public List<Vehiculo> findAll2(String marca) throws IOException {

		List<Vehiculo> vehiculosConMarca = new ArrayList<>();

		try
				(
						InputStream inputStream = new FileInputStream(this.ficheroVehiculos);
						DataInputStream dataInputStream = new DataInputStream(inputStream);
				)
		{
			while (dataInputStream.available() > 0) {

				Vehiculo vehiculo = new Vehiculo();

				vehiculo.setIdVehiculo(dataInputStream.readInt());
				vehiculo.setMarca(dataInputStream.readUTF());
				vehiculo.setModelo(dataInputStream.readUTF());
				vehiculo.setVersion(dataInputStream.readUTF());
				vehiculo.setCilindrada(dataInputStream.readLong());
				vehiculo.setPotencia(dataInputStream.readDouble());

				if(vehiculo.getMarca().equals(marca))
				vehiculosConMarca.add(vehiculo);
			}

			return vehiculosConMarca;
		}
	}
}
