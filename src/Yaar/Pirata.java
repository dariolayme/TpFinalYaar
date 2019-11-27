package Yaar;

import java.util.ArrayList;

public class Pirata {
	
	private ArrayList<String> items;
	private Pirata invitante;
	private int nivelEbriedad;
	private int cantidadMonedas =0;

	protected ArrayList<String> items(){
		return items;
	}
	
	protected Pirata invitante() {
		return invitante;
	}
	protected int nivelEbriedad() {
		return nivelEbriedad;
	}
	protected int cantidadMonedas() {
		return cantidadMonedas;
	}
	
	protected boolean tiene(String unItem) {
		return items.contains(unItem);
	}
	protected int cantidadItems() {
		return items.size();
	}
	
	public boolean pasadoDeGrog() {
		return nivelEbriedad >= 90;
	}
	
	protected void tomarGrog() {
		nivelEbriedad += 5;
		this.gastarMoneda();
	}
	protected void gastarMoneda() {
		//this.validarGastarMonedas();
		cantidadMonedas--;
	}
	/*
	void validarGastarMonedas() {
		if (cantidadMonedas == 0) {
			throw new TripulanteException(message = "Cantidad de monedas insuficientes... insert coin!");
		}
	}*/
	
	protected boolean podesSaquear(Victima unaVictima) {
		return unaVictima.sosSaqueablePor(this);
	}
	
	protected int cantidadInvitadosPara(Barco unBarco) {
		return unBarco.cantidadInvitadosPor(this);
	}
	
	protected boolean fuisteInvitadoPor(Pirata unTripulante) { 
		return invitante.equals(unTripulante);
	}
	

	

	
	

}
