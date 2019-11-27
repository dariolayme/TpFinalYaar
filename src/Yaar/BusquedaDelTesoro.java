package Yaar;

import java.util.ArrayList;
import java.util.stream.Stream;

public class BusquedaDelTesoro extends Mision {
	
	private ArrayList<String> obligatorios;
	
	public boolean esUtil(Pirata unPirata) {
		return this.tieneAlgunItemObligatorio(unPirata) && unPirata.cantidadMonedas() <= 5;
	}
	
	public boolean tieneAlgunItemObligatorio(Pirata unPirata) {
		//obliigatorios ['brújula', 'mapa', 'grogXD']
		return obligatorios.stream().anyMatch(item-> unPirata.tiene(item));
				
	}
	
	@Override
	public boolean esRealizablePor(Barco unBarco) {
		return super.esRealizablePor(unBarco) && unBarco.tiene("llave de cofre");
	}

	
}
