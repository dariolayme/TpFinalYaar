package Yaar;

public class PirataEspiaDeLaCorona extends Pirata{
	
	@Override
	public boolean pasadoDeGrog() {
		return false;
	}
	
	@Override
	public boolean podesSaquear(Victima unaVictima) {
		return super.podesSaquear(unaVictima) && this.tiene("permiso de la corona");
	}	
}