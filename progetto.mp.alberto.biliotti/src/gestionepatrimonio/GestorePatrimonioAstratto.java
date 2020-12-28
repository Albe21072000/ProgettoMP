package gestionepatrimonio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class GestorePatrimonioAstratto {
	private ArrayList<FonteProfitto> fontiProfitto= new ArrayList<FonteProfitto>();
	private ArrayList<OsservatorePatrimonio> osservatori= new ArrayList<>();

	ArrayList<FonteProfitto> restituisciFontiProfitto() {
		return fontiProfitto;
	}

	public double restituisciValorePatrimonioTotale() {
		Iterator<FonteProfitto> iterator= fontiProfitto.iterator();
		double valtot=0;
		while(iterator.hasNext()) {
			valtot+=iterator.next().getValoretot();
		}
		return valtot;
	}

	public abstract Boolean aggiungiFonteProfitto(FonteProfitto fontep);
	
	public abstract Boolean rimuoviFonteProfitto(FonteProfitto fontep);
	
	public Boolean attaccaOsservatore(OsservatorePatrimonio oss) {
		return osservatori.add(oss);
	}
	
	public Boolean rimuoviOsservatore(OsservatorePatrimonio oss) {
		return osservatori.remove(oss);
	}
	
	public void notifica() {
		osservatori.forEach((x)->x.aggiorna());
	}
	
	public Boolean aggiungiCollezioneFP(Collection<FonteProfitto> coll) {
		if(coll.isEmpty())
			return false;
		ArrayList<FonteProfitto> copia=fontiProfitto;
		coll.forEach((x)->this.aggiungiFonteProfitto(x));
		return !fontiProfitto.equals(copia);
	}
	
	public Boolean rimuoviCollezioneFP(Collection<FonteProfitto> coll) {
		int numfp=fontiProfitto.size();
		if(coll.isEmpty())
			return false;
		coll.forEach((x)->this.rimuoviFonteProfitto(x));
		return fontiProfitto.size()<numfp;
	}
	
	public Boolean controllaPatrimonioVuoto() {
		return fontiProfitto.isEmpty();
	}
	
	public String restituisciRicevutaFP() {
		String ricevuta="Ricevuta delle fonti di profitto: ";
		Iterator<FonteProfitto> iterator= fontiProfitto.iterator();
		while (iterator.hasNext()) {
			ricevuta+=iterator.next().accept(new VisitorDescrizioneFP());
			if(iterator.hasNext())
				ricevuta+=" ";
		}
		return ricevuta;
	}
	
	public Iterator<FonteProfitto> iterator(){
		return new Iterator<FonteProfitto>() {
			private int cont=0;
			
			private ArrayList<FonteProfitto> fp=fontiProfitto;

			@Override
			public boolean hasNext() {
				return cont<fontiProfitto.size();
			}

			@Override
			public FonteProfitto next() {
			FonteProfitto max= fp.stream()
					.max((x,y)->-1*x.getName()
					.compareToIgnoreCase(y.getName())) //ordine alfabetico
					.orElseThrow(()->new UnsupportedOperationException("Iteratore terminato!")); 
			fp.remove(max);
				return max;
			}
		};
		
	}

}
