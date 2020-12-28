package gestionepatrimonio;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class TestOsservatoreEntrate {
	private GestorePatrimonioAstratto patrimonio;
	private OsservatoreEntrate obs;
	@Before
	public void instanziapatrimonio() {
		patrimonio=new GestorePatrimonioSenzaDoppi();
		obs=new OsservatoreEntrate(patrimonio);
		patrimonio.attaccaOsservatore(obs);
	}

	@Test
	public void testPatrimonioVuoto() {
		assertThat(obs.calcolaIvaUltimaEntrata(20)).isEqualTo(0);
		assertThat(obs.calcolaFlatTax(20)).isEqualTo(0);
	}
	@Test
	public void testIvaUltimaEntrata() {
		patrimonio.aggiungiFonteProfitto(new Immobile(200, 1000, "prova"));
		assertThat(obs.calcolaIvaUltimaEntrata(10)).isEqualTo(20000);
		patrimonio.aggiungiFonteProfitto(new RiservaAurea(200, "prova"));
		assertThat(obs.calcolaIvaUltimaEntrata(10)).isEqualTo(1000);
		patrimonio.aggiungiFonteProfitto(new ContantiEuro(2000, "prova"));
		assertThat(obs.calcolaIvaUltimaEntrata(10)).isEqualTo(200);
	}
	@Test
	public void testFlatTax() {
		patrimonio.aggiungiFonteProfitto(new Immobile(200, 1000, "prova"));
		patrimonio.aggiungiFonteProfitto(new RiservaAurea(200, "prova"));
		patrimonio.aggiungiFonteProfitto(new ContantiEuro(2000, "prova"));
		assertThat(obs.calcolaFlatTax(10)).isEqualTo(21200);
	}

}
