package gestionepatrimonio;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class TestVisitorDescrizioneFP {
	

	@Test
	public void testVisitorValutaImmobile() {
		FonteProfitto casa= new Immobile(200, 2500, "casa di prova");
		assertThat(casa.accept(new VisitorDescrizioneFP())).isEqualTo("Immobile: casa di prova, che misura: 200mq ed ha un valore totale di: 500000.0€");
	}
	@Test
	public void testVisitorValutaRiservaAurea() {
		FonteProfitto oro= new RiservaAurea(200, "riserva di prova");
		assertThat(oro.accept(new VisitorDescrizioneFP())).isEqualTo("Riserva aurea: riserva di prova, che pesa: 200.0gr ed ha un valore totale di: 10000.0€");
	}
	@Test
	public void testVisitorContante() {
		FonteProfitto soldi= new ContantiEuro(2000, "riserva di prova");
		assertThat(soldi.accept(new VisitorDescrizioneFP())).isEqualTo("Riserva di contanti: riserva di prova, che ha un valore totale di: 2000.0€");
	}
	
}
