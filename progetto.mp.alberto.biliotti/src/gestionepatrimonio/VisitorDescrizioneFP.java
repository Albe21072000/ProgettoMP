package gestionepatrimonio;

public class VisitorDescrizioneFP implements VisitorFontiProfitto<String> {

	@Override
	public String visitImmobile(Immobile im) {
		return "Immobile: "+im.getName()+", che misura: "+im.getMetriQuadrati()+"mq ed ha un valore totale di: "+im.getValoretot()+"€";
	}

	@Override
	public String visitRiservaAurea(RiservaAurea au) {
		return "Riserva aurea: "+au.getName()+", che pesa: "+au.getGrammioro()+"gr ed ha un valore totale di: "+au.getValoretot()+"€";
	}

	@Override
	public String visitContantiEuro(ContantiEuro eur) {
		return "Riserva di contanti: "+eur.getName()+", che ha un valore totale di: "+eur.getValoretot()+"€";
	}
}
