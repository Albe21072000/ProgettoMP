package gestionepatrimonio;

public class OsservatoreEntrate implements OsservatorePatrimonio {
	
	private double valorepatrimonio;
	
	private GestorePatrimonioAstratto patrimonio;
	
	private double ultimaentrata;

	public OsservatoreEntrate(GestorePatrimonioAstratto patrimonio) {
		this.patrimonio = patrimonio;
		this.valorepatrimonio=patrimonio.restituisciValorePatrimonioTotale();
	}

	@Override
	public void aggiorna() {
	if(patrimonio.restituisciValorePatrimonioTotale()>valorepatrimonio)
		ultimaentrata=patrimonio.restituisciValorePatrimonioTotale()-valorepatrimonio;
	valorepatrimonio=patrimonio.restituisciValorePatrimonioTotale();
	}
	
	public double calcolaFlatTax(double percentuale) {
		return (percentuale/100)*valorepatrimonio;
	}
	
	public double calcolaIvaUltimaEntrata(double percentuale) {
		return ultimaentrata*(percentuale/100);
		
	}

}
