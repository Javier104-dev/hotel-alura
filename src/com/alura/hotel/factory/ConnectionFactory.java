package com.alura.hotel.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/hotel_alura_latam?useTimeZone=true&serverTimeZone=UTC",
				"root",
				"gumboundx100");
		System.out.println("conectado");
		con.close();
	}
}
