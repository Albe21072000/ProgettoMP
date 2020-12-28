package gestionepatrimonio;

public final class VisitorCambioValuta implements VisitorFontiProfitto<Double>{
	
	private double tassocambio;

	public VisitorCambioValuta(double tassocambio) {
		this.tassocambio = tassocambio;
	}

	@Override
	public Double visitImmobile(Immobile im) {
		
		return this.converti(im.getValoretot());
	}

	@Override
	public Double visitRiservaAurea(RiservaAurea au) {
		return this.converti(au.getValoretot());
	}

	@Override
	public Double visitContantiEuro(ContantiEuro eur) {
		return eur.getValoretot()*tassocambio;
	}
	private  double converti(double euro) {
		return euro*tassocambio;
		
	}

}
