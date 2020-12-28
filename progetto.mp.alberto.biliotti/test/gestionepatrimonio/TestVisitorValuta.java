package gestionepatrimonio;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class TestVisitorValuta {

	@Test
	public void testVisitorValutaImmobile() {
		FonteProfitto casa= new Immobile(200, 2500, "casa di prova");
		assertThat(casa.accept(new VisitorCambioValuta(1.8))).isEqualTo(200*2500*1.8);
	}
	@Test
	public void testVisitorValutaRiservaAurea() {
		FonteProfitto oro= new RiservaAurea(200, "riserva di prova");
		assertThat(oro.accept(new VisitorCambioValuta(1.8))).isEqualTo(200*50*1.8);
	}
	@Test
	public void testVisitorContante() {
		FonteProfitto soldi= new ContantiEuro(2000, "riserva di prova");
		assertThat(soldi.accept(new VisitorCambioValuta(1.8))).isEqualTo(2000*1.8);
	}

}
