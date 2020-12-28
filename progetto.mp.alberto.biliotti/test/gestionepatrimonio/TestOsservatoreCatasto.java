package gestionepatrimonio;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestOsservatoreCatasto {
	private GestorePatrimonioAstratto patrimonio;
	private OsservatorCatasto obs;
	@Before
	public void instanziapatrimonio() {
		patrimonio=new GestorePatrimonioSenzaDoppi();
		obs=new OsservatorCatasto(patrimonio);
		patrimonio.attaccaOsservatore(obs);
	}

	@Test
	public void testPatrimonioVuoto() {
	assertThat(obs.getMqtotali()).isEqualTo(0);
	assertThat(obs.getPatr()).isEqualTo(patrimonio);
	}
	
	@Test
	public void testAggiungiImmobile() {
		patrimonio.aggiungiFonteProfitto(new Immobile(200, 3000, "prova"));
		assertThat(obs.getMqtotali()).isEqualTo(200);
	}
	@Test
	public void testAggiungiVarieFP() {
		patrimonio.aggiungiFonteProfitto(new Immobile(200, 3000, "prova"));
		patrimonio.aggiungiFonteProfitto(new RiservaAurea(200, "prova oro"));
		patrimonio.aggiungiFonteProfitto(new ContantiEuro(200, "prova euro"));
		assertThat(obs.getMqtotali()).isEqualTo(200);
	}
	@Test
	public void testOsservatoreImmobileAggiuntaCollezioneFonteProfitto() {
		Immobile casa= new Immobile(200, 2000, "Casa");
		FonteProfitto eur = new ContantiEuro(2000, "Contanti prova");
		FonteProfitto oro = new RiservaAurea(1000, "Riserva prova");
		List<FonteProfitto> fp=new ArrayList<>();
		fp.add(casa);
		fp.add(eur);
		fp.add(oro);
		patrimonio.aggiungiCollezioneFP(fp);
		assertThat(obs.getMqtotali()).isEqualTo(200);
	}
	@Test
	public void testOsservatoreRimuoviFonteProfitto() {
		Immobile casa= new Immobile(200, 2000, "Casa");
		FonteProfitto eur = new ContantiEuro(2000, "Contanti prova");
		patrimonio.restituisciFontiProfitto().add(casa);
		patrimonio.restituisciFontiProfitto().add(eur);
		patrimonio.rimuoviFonteProfitto(eur);
		assertThat(obs.getMqtotali()).isEqualTo(200);
	}


}
