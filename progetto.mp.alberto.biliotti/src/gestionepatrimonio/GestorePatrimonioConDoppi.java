package gestionepatrimonio;

public class GestorePatrimonioConDoppi extends GestorePatrimonioAstratto {

	@Override
	public Boolean aggiungiFonteProfitto(FonteProfitto fontep) {
		boolean aggiunto= super.restituisciFontiProfitto().add(fontep);
		super.notifica();
		return aggiunto;
	}

	@Override
	public Boolean rimuoviFonteProfitto(FonteProfitto fontep) {
		Boolean eseguito=super.restituisciFontiProfitto().remove(fontep);
		if(eseguito) {
			super.notifica();
		}
		return eseguito;
	}

}
