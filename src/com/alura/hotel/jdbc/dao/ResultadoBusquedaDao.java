package com.alura.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.jdbc.modelo.Huesped;
import com.alura.hotel.jdbc.modelo.HuespedReserva;
import com.alura.hotel.jdbc.modelo.Reservas;

public class ResultadoBusquedaDao {
	final private Connection con;
	
	public ResultadoBusquedaDao(Connection con) {
		this.con = con;
	}
	
	
	public List<HuespedReserva> huespedEnServidor (Object parametroBusqueda){
		
		List<HuespedReserva> resultado = new ArrayList<>();	
		
		try{
			var querySelect ="SELECT "
					+ "H.ID, "
					+ "H.NOMBRE, "
					+ "H.APELLIDO, "
					+ "H.FECHA_NACIMIENTO, "
					+ "H.NACIONALIDAD, "
					+ "H.TELEFONO, "
					+ "H.ID_RESERVA, "
					+ "R.ID, "
					+ "R.FECHA_ENTRADA, "
					+ "R.FECHA_SALIDA, "
					+ "R.VALOR, "
					+ "R.FORMA_PAGO "
					+ "FROM HUESPEDES H INNER JOIN RESERVAS R "
					+ "ON H.ID_RESERVA = R.ID "
					+ "WHERE (H.APELLIDO = ? || R.ID = ?)";
			
			final PreparedStatement statement = con.prepareStatement(querySelect);
			
			try(statement){
				
				if(parametroBusqueda instanceof String) {
				statement.setString(1, (String) parametroBusqueda);
				statement.setString(2, (String) parametroBusqueda);
				
				}else if(parametroBusqueda instanceof Integer) {
					statement.setInt(1, (int) parametroBusqueda);
					statement.setInt(2, (int) parametroBusqueda);
				}
				
				statement.execute();
				
				final ResultSet resultSet = statement.getResultSet();
				
				try(resultSet){
					while(resultSet.next()) {
						Huesped huesped = new Huesped(
								resultSet.getInt("H.ID"),
								resultSet.getString("H.NOMBRE"),
								resultSet.getString("H.APELLIDO"),
								resultSet.getDate("H.FECHA_NACIMIENTO"),
								resultSet.getString("H.NACIONALIDAD"),
								resultSet.getString("H.TELEFONO"),
								resultSet.getInt("H.ID_RESERVA"));
						
				          Reservas reserva = new Reservas(
				                  resultSet.getInt("R.ID"),
				                  resultSet.getDate("R.FECHA_ENTRADA"),
				                  resultSet.getDate("R.FECHA_SALIDA"),
				                  resultSet.getDouble("R.VALOR"),
				                  resultSet.getString("R.FORMA_PAGO")
				                );
				          HuespedReserva huespedReserva = new HuespedReserva(huesped, reserva);
				          resultado.add(huespedReserva);
					}
				}
			}		
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado; 
	}
	
	public void eliminarReserva(Integer id) {
		 try {
			 
			 final PreparedStatement statement = con.prepareStatement(
					 //"DELETE FROM RESERVAS WHERE ID = ?");
					 
					 "DELETE RESERVAS, HUESPEDES "
					 + "FROM HUESPEDES "
					 + "JOIN reservas ON HUESPEDES.ID_RESERVA = RESERVAS.ID "
					 + "WHERE (RESERVAS.ID = ? && HUESPEDES.ID_RESERVA = ?)"
					 );
					 
			 try(statement){
				 statement.setInt(1, id);
				 statement.setInt(2, id);
				 statement.execute();
			 }

		 }catch(SQLException e) {
			 throw new RuntimeException(e);
			}
	 }
}
