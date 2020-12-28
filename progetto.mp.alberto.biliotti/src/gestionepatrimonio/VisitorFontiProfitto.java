package gestionepatrimonio;

public interface VisitorFontiProfitto<T> {
	
	T visitImmobile(Immobile im);
	
	T visitRiservaAurea(RiservaAurea au);
	
	T visitContantiEuro(ContantiEuro eur);

}
