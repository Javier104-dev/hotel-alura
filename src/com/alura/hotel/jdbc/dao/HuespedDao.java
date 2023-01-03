package com.alura.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.hotel.jdbc.modelo.Huesped;


public class HuespedDao {
	final private Connection con;
	
	public HuespedDao (Connection con) {
		this.con = con;
	}

	public void guardarHuesped(Huesped huesped) {
		try {
			
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO HUESPEDES "
					+ "(nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva)"
					+ " VALUES (?, ?, ? ,? , ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setDate(3, huesped.getFecha_nacimiento());
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5, huesped.getTelefono());
				statement.setInt(6, huesped.getId_reserva());
				statement.execute();
				
				final ResultSet resultSet = statement.getGeneratedKeys();	
				
				try(resultSet){
					while(resultSet.next()) {
						huesped.setId(resultSet.getInt(1));
					}
				}
			}
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int modificarHuesped(Integer id, String nombre, String apellido, Date fecha_nacimiento, String nacionalidad, String telefono){	
		try {
			final PreparedStatement statement = con.prepareStatement(
					"UPDATE HUESPEDES SET "
					+ "NOMBRE = ?, "
					+ "APELLIDO = ?, "
					+ "FECHA_NACIMIENTO = ?, "
					+ "NACIONALIDAD = ?, "
					+ "TELEFONO = ? "
					+ "WHERE ID = ?");
			
			try(statement){
				
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setDate(3, fecha_nacimiento);
				statement.setString(4, nacionalidad);
				statement.setString(5, telefono);
				statement.setInt(6, id);				
				statement.execute();
				
				int updateCount = statement.getUpdateCount();
				return updateCount;
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public List<Huesped> listarHuespedes(){
		List<Huesped> resultado = new ArrayList<>();
		
		try {
			 final PreparedStatement statement = con.prepareStatement(
					 "SELECT "
					 + "ID, "
					 + "NOMBRE, "
					 + "APELLIDO, "
					 + "FECHA_NACIMIENTO, "
					 + "NACIONALIDAD, "
					 + "TELEFONO, "
					 + "ID_RESERVA "
					 + "FROM HUESPEDES");
			 
			 try(statement){
				 statement.execute();
				 
				 final ResultSet resultSet = statement.getResultSet();
				 
				 try(resultSet){
					 
					 while(resultSet.next()) {
						 Huesped fila = new Huesped(
								 resultSet.getInt("ID"),
								 resultSet.getString("NOMBRE"),
								 resultSet.getString("APELLIDO"),
								 resultSet.getDate("FECHA_NACIMIENTO"),
								 resultSet.getString("NACIONALIDAD"),
								 resultSet.getString("TELEFONO"),
								 resultSet.getInt("ID_RESERVA"));
						 resultado.add(fila);
					 }
				 }
			 }
		} catch(SQLException e) {
			throw new RuntimeException(e);//tratamos el error aqui para no pasarlo mas
		}
		return resultado;
	}
}