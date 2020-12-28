package gestionepatrimonio;

public class OsservatoreMock implements OsservatorePatrimonio {
	
	private GestorePatrimonioAstratto patr;
	
	private double valoreultimafp=0;
	
	private double valoretot=0;

	OsservatoreMock(GestorePatrimonioAstratto patr) {
		this.patr = patr;
		valoretot=patr.restituisciValorePatrimonioTotale();
	}

	double getValoreUltimaFP() {
		return valoreultimafp;
	}

	double getValoreTot() {
		return valoretot;
	}

	public GestorePatrimonioAstratto getPatr() {
		return patr;
	}

	@Override
	public void aggiorna() {
		valoreultimafp=patr.restituisciFontiProfitto()
				.get(patr.restituisciFontiProfitto().size()-1)
				.getValoretot();
		this.valoretot = patr.restituisciValorePatrimonioTotale();
	
	}

}
