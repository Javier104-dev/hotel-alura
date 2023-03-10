package com.alura.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.alura.hotel.jdbc.modelo.Reservas;

public class ReservasDao {

	final private Connection con;
	
	public ReservasDao(Connection con) {
		this.con = con;
	}
	
	
	 public Integer guardarReserva(Reservas reservas){
		 try {
			 final PreparedStatement statement = con.prepareStatement(
					 "INSERT INTO RESERVAS (fecha_entrada, fecha_salida, valor, forma_pago) VALUES (?, ?, ?, ?)", 
					 Statement.RETURN_GENERATED_KEYS);
			 
			 try(statement){
				 statement.setDate(1, reservas.getFecha_entrada());
				 statement.setDate(2, reservas.getFecha_salida());
				 statement.setDouble(3, reservas.getValor());
				 statement.setString(4, reservas.getForma_pago());
				 statement.execute();
				 
				 final ResultSet resultSet = statement.getGeneratedKeys();
				 
				 try (resultSet) {
	                    while (resultSet.next()) {
	                    	reservas.setId(resultSet.getInt(1));
	                    }
	                }
			 }		  
		 }catch (SQLException e) {
			 throw new RuntimeException(e);
		 }
		 return reservas.getId();
	 }
	 
	 
	 public int modificarReserva(Integer id, Date fecha_entrada, Date fecha_salida, Double valor, String forma_pago) {		 
		 try {
			 final PreparedStatement statement = con.prepareStatement(
					 "UPDATE RESERVAS SET "
			 		+ "FECHA_ENTRADA = ?, "
			 		+ "FECHA_SALIDA = ?, "
			 		+ "VALOR = ?, "
			 		+ "FORMA_PAGO = ? "
			 		+ "WHERE ID = ?");
			
			 try(statement){
				 
				 statement.setDate(1, fecha_entrada);
				 statement.setDate(2, fecha_salida);
				 statement.setDouble(3, valor);
				 statement.setString(4, forma_pago);
				 statement.setInt(5, id);
				 statement.execute();
				 
				 int updateCount = statement.getUpdateCount();
				 return updateCount;
			 }
		 }catch(SQLException e) { //tratamos la bomba con SQLException
				throw new RuntimeException(e);//tratamos el error aqui para no pasarlo mas
			}
	 }
	 
	 
	 public List<Reservas> listarReservas(){
		 List<Reservas> resultado = new ArrayList<>();
		 
		 try {
			 final PreparedStatement statement = con.prepareStatement(
					 "SELECT "
					 + "ID, "
					 + "FECHA_SALIDA, "
					 + "FECHA_ENTRADA, "
					 + "VALOR, "
					 + "FORMA_PAGO "
					 + "FROM RESERVAS");
			 
			 try(statement){
				 statement.execute();
				 
				 final ResultSet resultSet = statement.getResultSet();
				 
				 try(resultSet){
					 
					 while(resultSet.next()) {
						 
						 Reservas fila = new Reservas(
								 resultSet.getInt("ID"),
								 resultSet.getDate("FECHA_ENTRADA"),
								 resultSet.getDate("FECHA_SALIDA"),
								 resultSet.getDouble("VALOR"),
								 resultSet.getString("FORMA_PAGO"));
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

/*CODIGO SIN USO, SE HACE TODO EN RESULTADOSdAO
	 public List<Reservas> reservasEnServidor (Integer nReserva){
		 List<Reservas> resultado = new ArrayList<>();
		 
		 try {
			 var querySelect = "SELECT "
			 		+ "ID, "
			 		+ "FECHA_ENTRADA, "
			 		+ "FECHA_SALIDA, "
			 		+ "VALOR, "
			 		+ "FORMA_PAGO "
			 		+ "FROM RESERVAS WHERE "
			 		+ "ID = ?";
			 final PreparedStatement statement = con.prepareStatement(querySelect);
			 
			 try(statement){
				 statement.setInt(1, nReserva);
				 statement.execute();
				 
				 final ResultSet resultSet = statement.getResultSet();
				 
				 try(resultSet){
					 while(resultSet.next()) {
						 Reservas fila = new Reservas(
								 resultSet.getInt("ID"),
								 resultSet.getDate("FECHA_ENTRADA"),
								 resultSet.getDate("FECHA_SALIDA"),
								 resultSet.getDouble("VALOR"),
								 resultSet.getString("FORMA_PAGO"));
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

