package com.alura.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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

	
	/*
	 *
	public List<Huesped> huespedEnServidor (Object parametroBusqueda){
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
					+ "(APELLIDO = ? or ID_RESERVA = ?)";
			
			final PreparedStatement statement = con.prepareStatement(querySelect);
			
			try(statement){
				//con esto depende el resultado si es un strin o un in
				if(parametroBusqueda instanceof String) {
				statement.setString(1, (String) parametroBusqueda);
				statement.setString(2, (String) parametroBusqueda);
				
				}else if(parametroBusqueda instanceof Integer) {
					statement.setInt(1, (int) parametroBusqueda);
					statement.setInt(2, (int) parametroBusqueda);
				}
				
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
	 */
}