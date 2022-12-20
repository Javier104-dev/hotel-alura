package com.alura.hotel;

import javax.swing.JFrame;

import views.MenuPrincipal;


public class HotelAluraMain {

	public static void main(String[] args) {
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.setVisible(true);
	}
}
