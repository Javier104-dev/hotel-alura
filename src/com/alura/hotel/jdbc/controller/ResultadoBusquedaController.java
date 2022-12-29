package com.alura.hotel.jdbc.controller;

import java.util.List;

import com.alura.hotel.jdbc.dao.ResultadoBusquedaDao;
import com.alura.hotel.jdbc.factory.ConnectionFactory;
import com.alura.hotel.jdbc.modelo.HuespedReserva;

public class ResultadoBusquedaController {
	
	private ResultadoBusquedaDao resultadoBusquedaDao;
	
	public ResultadoBusquedaController() {
		var factory = new ConnectionFactory();
		this.resultadoBusquedaDao = new ResultadoBusquedaDao(factory.recuperaConexion());
	}
	
	
	public List <HuespedReserva> resultadoBusqueda(Object parametroBusqueda){
		
		return resultadoBusquedaDao.huespedEnServidor(parametroBusqueda);
	}

	public void eliminarReservaYHuesped(Integer id) {
		resultadoBusquedaDao.eliminarReserva(id);
	}
}
