package com.alura.hotel.jdbc.controller;


import com.alura.hotel.jdbc.dao.ReservasDao;
import com.alura.hotel.jdbc.factory.ConnectionFactory;
import com.alura.hotel.jdbc.modelo.Reservas;


public class ReservasController {
	
	private ReservasDao reservasDao;
	
	public ReservasController() {
		this.reservasDao = new ReservasDao(new ConnectionFactory().recuperaConexion());
	}
	
	public int guardar(Reservas reservas){
		return reservasDao.guardarReserva(reservas);
	}
}
