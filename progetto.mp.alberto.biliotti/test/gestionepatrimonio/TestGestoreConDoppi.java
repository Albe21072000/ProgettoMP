package gestionepatrimonio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestGestoreConDoppi {
	
	private GestorePatrimonioAstratto patrimonio;

	@Before
	public void instanziapatrimonio() {
		patrimonio=new GestorePatrimonioConDoppi();
	}
	@Test
	public void testAggiungiFonteProfitto() {
		Immobile casa= new Immobile(200, 2000, "prova");
		patrimonio.aggiungiFonteProfitto(casa);
		assertThat(patrimonio
				.restituisciFontiProfitto().
				get(0))
			    .isSameAs(casa);
	}
	@Test
	public void testAggiungiFonteProfittoDuplicata() {
		Immobile casa= new Immobile(200, 2000, "prova");
		patrimonio.aggiungiFonteProfitto(casa);
		assertThat(patrimonio.aggiungiFonteProfitto(casa)).isTrue();
		assertThat(patrimonio.restituisciFontiProfitto()).containsExactly(casa, casa);
	}
	@Test
	public void testRimuoviFonteProfitto() {
		Immobile casa= new Immobile(200, 2000, "prova");
		patrimonio.restituisciFontiProfitto().add(casa);
		patrimonio.rimuoviFonteProfitto(casa);
		assertThat(patrimonio.restituisciFontiProfitto()).isEmpty();
	}
	@Test
	public void testAggiungiCollezioneVuota() {
		ArrayList<FonteProfitto> fp= new ArrayList<>();
		assertThat(patrimonio.aggiungiCollezioneFP(fp)).isFalse();
		assertThat(patrimonio.restituisciFontiProfitto()).isEmpty();
	}
	@Test
	public void testAggiungiCollezioni() {
		Immobile casa= new Immobile(200, 2000, "prova");
		RiservaAurea oro=new RiservaAurea(100, "provaoro");
		ContantiEuro euro=new ContantiEuro(2000, "provaeu");
		ArrayList<FonteProfitto> fp= new ArrayList<>();
		fp.add(casa);
		fp.add(oro);
		fp.add(euro);
		fp.add(casa);
		patrimonio.aggiungiCollezioneFP(fp);
		assertThat(patrimonio.restituisciFontiProfitto()).containsExactly(casa, oro, euro,casa);
	}
	@Test
	public void testAggiungiCollezioneDuplicata() {
		Immobile casa= new Immobile(200, 2000, "prova");
		RiservaAurea oro=new RiservaAurea(100, "provaoro");
		ContantiEuro euro=new ContantiEuro(2000, "provaeu");
		ArrayList<FonteProfitto> fp= new ArrayList<>();
		fp.add(casa);
		fp.add(oro);
		fp.add(euro);
		patrimonio.aggiungiCollezioneFP(fp);
		patrimonio.aggiungiCollezioneFP(fp);
		assertThat(patrimonio.restituisciFontiProfitto()).containsExactly(casa, oro, euro,casa, oro, euro);
	}
	@Test
	public void testRimuoviCollezioni() {
		Immobile casa= new Immobile(200, 2000, "prova");
		RiservaAurea oro=new RiservaAurea(100, "provaoro");
		ContantiEuro euro=new ContantiEuro(2000, "provaeu");
		ArrayList<FonteProfitto> fp= new ArrayList<>();
		fp.add(casa);
		fp.add(oro);
		fp.add(euro);
		patrimonio.restituisciFontiProfitto().addAll(fp);
		fp.remove(oro);
		patrimonio.rimuoviCollezioneFP(fp);
		assertThat(patrimonio.restituisciFontiProfitto()).containsExactly(oro);
	}

}
