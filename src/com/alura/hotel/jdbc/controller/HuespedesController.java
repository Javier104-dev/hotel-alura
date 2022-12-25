package com.alura.hotel.jdbc.controller;

import java.sql.Date;

import com.alura.hotel.jdbc.dao.HuespedDao;
import com.alura.hotel.jdbc.factory.ConnectionFactory;
import com.alura.hotel.jdbc.modelo.Huesped;


public class HuespedesController {
	
	private HuespedDao huespedDao;
	
	public HuespedesController() {
		var factory = new ConnectionFactory();
		this.huespedDao = new HuespedDao(factory.recuperaConexion());
	}
	
	public void guardarHuesped(Huesped huesped) {
		//huesped.setId_reserva(id_reserva);
		huespedDao.guardarHuesped(huesped);
	}
	
	public int modificarHuesped(Integer id, String nombre, String apellido, Date fecha_nacimiento, String nacionalidad, String telefono) {
		return huespedDao.modificarHuesped(id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono);
	}
}