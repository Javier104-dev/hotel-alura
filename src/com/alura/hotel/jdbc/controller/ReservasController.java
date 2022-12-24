package com.alura.hotel.jdbc.controller;

import com.alura.hotel.jdbc.dao.ReservasDao;
import com.alura.hotel.jdbc.factory.ConnectionFactory;
import com.alura.hotel.jdbc.modelo.Reservas;


public class ReservasController {
	
	private ReservasDao reservasDao;
	
	public ReservasController() {
		var factory = new ConnectionFactory();
		this.reservasDao = new ReservasDao(factory.recuperaConexion());
	}
	
	public int guardarReserva(Reservas reservas){
		return reservasDao.guardarReserva(reservas);
	}
	
	public void eliminarReserva(Integer id) {
		reservasDao.eliminarReserva(id);
	}
	
}
