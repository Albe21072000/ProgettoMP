package gestionepatrimonio;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestObserverMock {
	private GestorePatrimonioAstratto patrimonio;
	private OsservatoreMock obs;
	@Before
	public void instanziapatrimonio() {
		patrimonio=new GestorePatrimonioSenzaDoppi();
		obs=new OsservatoreMock(patrimonio);
		patrimonio.attaccaOsservatore(obs);
	}

	@Test
	public void testAssegnamentoOsservatorePatrimonio() {
		assertThat(obs.getValoreTot()).isEqualTo(0);
		assertThat(obs.getPatr()).isEqualTo(patrimonio);
	}
	@Test
	public void testOsservatoreAggiuntaFonteProfitto() {
		patrimonio.aggiungiFonteProfitto(new Immobile(200, 2000, "prova"));
		patrimonio.aggiungiFonteProfitto(new ContantiEuro(2000, "Contanti prova"));
		assertThat(obs.getValoreUltimaFP()).isEqualTo(2000);
		assertThat(obs.getValoreTot()).isEqualTo(200*2000+2000);
	}
	@Test
	public void testOsservatoreAggiuntaCollezioneFonteProfitto() {
		Immobile casa= new Immobile(200, 2000, "Casa");
		FonteProfitto eur = new ContantiEuro(2000, "Contanti prova");
		FonteProfitto oro = new RiservaAurea(1000, "Riserva prova");
		List<FonteProfitto> fp=new ArrayList<>();
		fp.add(casa);
		fp.add(eur);
		fp.add(oro);
		patrimonio.aggiungiCollezioneFP(fp);
		assertThat(obs.getValoreUltimaFP()).isEqualTo(50000);
		assertThat(obs.getValoreTot()).isEqualTo(400000+2000+50000);
	}
	@Test
	public void testOsservatoreRimuoviFonteProfitto() {
		Immobile casa= new Immobile(200, 2000, "Casa");
		FonteProfitto eur = new ContantiEuro(2000, "Contanti prova");
		FonteProfitto oro = new RiservaAurea(1000, "Riserva prova");
		patrimonio.restituisciFontiProfitto().add(casa);
		patrimonio.restituisciFontiProfitto().add(eur);
		patrimonio.restituisciFontiProfitto().add(oro);
		patrimonio.rimuoviFonteProfitto(casa);
		assertThat(obs.getValoreTot()).isEqualTo(52000);
		assertThat(obs.getValoreUltimaFP()).isEqualTo(50000);
	}

}
