package com.alura.hotel.jdbc.controller;

import java.sql.Date;
import java.util.List;

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
	
	public int modificarReserva(Integer id, Date fecha_entrada, Date fecha_salida, Double valor, String forma_pago) {
		return reservasDao.modificarReserva(id, fecha_entrada, fecha_salida, valor, forma_pago);
	}
	
	public List<Reservas> listarReservas(){
		return reservasDao.listarReservas();
	}
}
