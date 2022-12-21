package com.alura.hotel.jdbc;

import javax.swing.JFrame;

import com.alure.hotel.jdbc.views.MenuPrincipal;


public class HotelAluraMain {

	public static void main(String[] args) {
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.setVisible(true);
	}
}
