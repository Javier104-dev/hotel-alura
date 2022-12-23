package com.alura.hotel.jdbc.controller;

import java.util.List;

import com.alura.hotel.jdbc.dao.HuespedDao;
import com.alura.hotel.jdbc.factory.ConnectionFactory;
import com.alura.hotel.jdbc.modelo.Huesped;

public class HuespedesController {
	
	private HuespedDao huespedDao;
	
	public HuespedesController() {
		this.huespedDao = new HuespedDao(new ConnectionFactory().recuperaConexion());
	}
	
	
	public void guardarHuesped(Huesped huesped) {
		//huesped.setId_reserva(id_reserva);
		huespedDao.guardarHuesped(huesped);
	}
	
	public List <Huesped> resultadoHesped(String apellido){
		return huespedDao.huespedEnServidor(apellido);
	}
}
