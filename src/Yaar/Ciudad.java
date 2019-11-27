package Yaar;

public class Ciudad implements Victima{
	
	
	private int cantidadHabitantes = 0;
	
	public void sumarHabitante() {
		cantidadHabitantes++;
	}

	@Override
	public boolean sosSaqueablePor(Pirata unPirata) {
		return unPirata.nivelEbriedad() >= 50;
	}

	@Override
	public boolean esVulnerableA(Barco OtroBarco) {
		return OtroBarco.cantidadTripulantes() >= cantidadHabitantes * 0.4 || OtroBarco.todosPasadosDeGrog();
	}

}
