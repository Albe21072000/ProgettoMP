package gestionepatrimonio;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class TestGestorePatrimonioAstratto {
	private GestorePatrimonioAstratto patrimonio;
	@Before
	public void instanziapatrimonio() {
		patrimonio=new GestorePatrimonioSenzaDoppi();
	}

	@Test
	public void testPatrimonioVuoto() {
		assertThat(patrimonio.controllaPatrimonioVuoto()).isTrue();
	}

	@Test
	public void testDescrizioneFP() {
		Immobile casa= new Immobile(200, 2000, "prova");
		RiservaAurea oro=new RiservaAurea(100, "provaoro");
		ContantiEuro euro=new ContantiEuro(2000, "provaeu");
		patrimonio.restituisciFontiProfitto().add(casa);
		patrimonio.restituisciFontiProfitto().add(oro);
		patrimonio.restituisciFontiProfitto().add(euro);
		assertThat(patrimonio.restituisciRicevutaFP()).isEqualTo("Ricevuta delle fonti di profitto: Immobile: prova, che misura: 200mq ed ha un valore totale di: 400000.0€ Riserva aurea: provaoro, che pesa: 100.0gr ed ha un valore totale di: 5000.0€ Riserva di contanti: provaeu, che ha un valore totale di: 2000.0€");
	}
	@Test
	public void testIteratore() {
		FonteProfitto casa = new Immobile(200, 2000, "Casa");
		patrimonio.restituisciFontiProfitto().add(casa);
		FonteProfitto eur = new ContantiEuro(2000, "Contanti prova");
		patrimonio.restituisciFontiProfitto().add(eur);
		FonteProfitto oro = new RiservaAurea(2000, "Riserva prova");
		patrimonio.restituisciFontiProfitto().add(oro);
		assertThat(patrimonio.iterator())
		.toIterable()
		.containsExactly(casa,eur,oro);
	}
	@Test
	public void testIteratoreVuoto() {
		assertThat(patrimonio.iterator()).toIterable().isEmpty();
		assertThat(patrimonio.iterator().hasNext())
		.isFalse();
		try {
			patrimonio.iterator().next();
		} catch (UnsupportedOperationException e) {
			assertThat(e).hasMessage("Iteratore terminato!");
		}
	}

}
