package gestionepatrimonio;

import java.util.Iterator;

public class OsservatorCatasto implements OsservatorePatrimonio {

	private GestorePatrimonioAstratto patr;

	private int mqtotali=0;

	public OsservatorCatasto(GestorePatrimonioAstratto patr) {
		this.patr = patr;
		patr.restituisciFontiProfitto().forEach((x)->x.accept(new Aggiungimq()));
	}

	GestorePatrimonioAstratto getPatr() {
		return patr;
	}
	private class Aggiungimq implements VisitorFontiProfitto<Integer>{
		@Override
		public Integer visitImmobile(Immobile im) {
			return mqtotali+=im.getMetriQuadrati();
		}

		@Override
		public Integer visitRiservaAurea(RiservaAurea au) {
			return null;
		}

		@Override
		public Integer visitContantiEuro(ContantiEuro eur) {
			return null;
		}

	}

	int getMqtotali() {
		return mqtotali;
	}

	@Override
	public void aggiorna() {
		Iterator<FonteProfitto> iterator=patr.iterator();
		while(iterator.hasNext()) {
			iterator.next().accept(new Aggiungimq());
		}

	}

}
