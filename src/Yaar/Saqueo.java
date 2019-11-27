package Yaar;

public class Saqueo extends Mision{
	
	private int limiteMonedasParaSaquear = 0;
	private Victima victima;
	
	
	boolean esUtil(Pirata unPirata) {
		return (unPirata.cantidadMonedas() < limiteMonedasParaSaquear) && victima.sosSaqueablePor(unPirata);
	}
	
	
}
