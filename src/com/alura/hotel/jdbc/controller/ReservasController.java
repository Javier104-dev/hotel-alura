package com.alura.hotel.jdbc.controller;


import java.util.List;

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
	
	public List <Reservas> resultadoReservas(Integer nReserva){
		return reservasDao.reservasEnServidor(nReserva);
	}
}
