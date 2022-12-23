package com.alura.hotel.jdbc.modelo;

public class HuespedReserva {
	
	private Huesped huesped;
	private Reservas reserva;

	public HuespedReserva(Huesped huesped, Reservas reserva) {
		this.huesped = huesped;
		this.reserva = reserva;
	}
	public Huesped getHuesped() {
		return huesped;
	}
	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}
	public Reservas getReserva() {
		return reserva;
	}
	public void setReserva(Reservas reserva) {
		this.reserva = reserva;
	}

}
