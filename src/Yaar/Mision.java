package Yaar;

public abstract class Mision {
	
	

	public boolean esRealizablePor(Barco unBarco) {
		return unBarco.tieneSuficienteTripulacion();
	}
	
	
	 abstract boolean esUtil(Pirata unPirata);

}
