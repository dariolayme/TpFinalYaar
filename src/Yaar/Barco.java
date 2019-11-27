package Yaar;
import java.awt.List;
import java.util.*;
import java.util.stream.*;;
public class Barco implements Victima{
	
	
	private Mision mision;
	private int capacidad;
	private ArrayList<Pirata> tripulantes;
	
	@Override
	public boolean sosSaqueablePor(Pirata unPirata) {
		return unPirata.pasadoDeGrog();
	}
	
	@Override
	public boolean esVulnerableA(Barco otroBarco) {
		return this.cantidadTripulantes() <= otroBarco.cantidadTripulantes() / 2;
	}
	
	int cantidadTripulantes() {
		return tripulantes.size();
	}
	
	boolean todosPasadosDeGrog() {
		return tripulantes.stream().allMatch(tripulante -> tripulante.pasadoDeGrog());
	}
	
	boolean puedeUnirse(Pirata unPirata) {
		return this.hayLugar() && mision.esUtil(unPirata);
	}
	
	boolean hayLugar() {
		return this.cantidadTripulantes() < capacidad;
	}
	
	void agregar(Pirata unTripulante) {
		if (this.puedeUnirse(unTripulante)) {
			tripulantes.add(unTripulante);
		}
	}
	/*
	void cambiarMision(Mision unaMision) {
		
		tripulantes.removeAllSuchThat { tripulante -> unaMision.esUtil(tripulante).negate() };
		mision = unaMision;
	}
	*/
	
	Optional<Pirata> pirataMasEbrio() {
		
		return tripulantes.stream().max(Comparator.comparing(tripulante -> tripulante.nivelEbriedad()));
	}
	
	void anclarEn(Ciudad unaCiudad) {
		this.todosTomanGrog();
		this.perderMasEbrioEn(unaCiudad);
	}
	
	void todosTomanGrog() {
		tripulantes.forEach ( tripulante -> tripulante.tomarGrog() );
	}
	
	void perderMasEbrioEn(Ciudad unaCiudad) {
		tripulantes.remove(this.pirataMasEbrio());
		unaCiudad.sumarHabitante();
	}
	
	boolean esTemible() {
		return mision.esRealizablePor(this);
	}
	
	boolean tieneSuficienteTripulacion() {
		return this.cantidadTripulantes() >= capacidad * 0.9;
	}
	
	boolean tiene(String unItem) {
		return tripulantes.stream().anyMatch(tripulante -> tripulante.tiene(unItem));
	}
	
	int cantidadTripulantesPasadosDeGrog() {
		return (int) this.tripulantesPasadosDeGrog().count();
	}
	
	Stream<Pirata> tripulantesPasadosDeGrog() {
		return tripulantes.stream().filter(tripulante -> tripulante.pasadoDeGrog());
	}
	
	Stream<String> itemsDistintosEntreTripulantesPasadosDeGrog() {
		return this.tripulantesPasadosDeGrog().flatMap(tripulante -> tripulante.items());
	}
	
	int cantidadItemsDistintosEntreTripulantesPasadosDeGrog() {
		return (int) this.itemsDistintosEntreTripulantesPasadosDeGrog().count();
	}
	
	Optional<Pirata> tripulantePasadoDeGrogConMasMonedas() {
		return this.tripulantesPasadosDeGrog().max(Comparator.comparing(tripulante -> tripulante.cantidadMonedas()));
	}
	
	Optional<Pirata> tripulanteMasInvitador() {
		return tripulantes.stream().max(Comparator.comparing(tripulante -> tripulante.cantidadInvitadosPara(this)));
	}
	
	int  cantidadInvitadosPor(Pirata unTripulante) {
		return (int) tripulantes.stream().map( tripulante -> tripulante.fuisteInvitadoPor(unTripulante)).filter(as->as.equals(true)).count();
	}
	
	public static void main(String[] args) { 
		System.out.println("bie9+8797n");
	}

}
