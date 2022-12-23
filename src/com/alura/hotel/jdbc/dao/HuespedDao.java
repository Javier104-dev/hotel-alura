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
	
	
	public List<Huesped> huespedEnServidor (String apellido){
		List<Huesped> resultado = new ArrayList<>();
		
		try{
			var querySelect ="SELECT "
					+ "ID, "
					+ "NOMBRE, "
					+ "APELLIDO, "
					+ "FECHA_NACIMIENTO, "
					+ "NACIONALIDAD, "
					+ "TELEFONO, "
					+ "ID_RESERVA "
					+ "FROM HUESPEDES WHERE "
					+ "APELLIDO = ?";
			
			final PreparedStatement statement = con.prepareStatement(querySelect);
			
			try(statement){
				statement.setString(1, apellido);
				statement.execute();
				
				final ResultSet resulSet = statement.getResultSet();
				
				try(resulSet){
					while(resulSet.next()) {
						Huesped fila = new Huesped(
								resulSet.getInt("ID"),
								resulSet.getString("NOMBRE"),
								resulSet.getString("APELLIDO"),
								resulSet.getDate("FECHA_NACIMIENTO"),
								resulSet.getString("NACIONALIDAD"),
								resulSet.getString("TELEFONO"),
								resulSet.getInt("ID_RESERVA"));
						resultado.add(fila);		
					}
				}
			}		
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado; 
	}
}