package gestionepatrimonio;

public final class GestorePatrimonioSenzaDoppi extends GestorePatrimonioAstratto {

	@Override
	public Boolean aggiungiFonteProfitto(FonteProfitto fontep) {
		if(super.restituisciFontiProfitto().contains(fontep))
			return false;
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
