package Yaar;

public class ConvertirseEnLeyenda extends Mision{
	
	String itemObligatorio;
	
	public boolean esUtil(Pirata unPirata) {
		return unPirata.cantidadItems() >= 10 && unPirata.tiene(itemObligatorio);
	}
}
