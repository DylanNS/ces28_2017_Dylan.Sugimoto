package Q4.orig;

import java.util.Iterator;

public class RelatorioDespesas {
	public void ImprimirRelatorio(Iterator<Despesa> despesas) {
		float totalDespesa = 0.0f;
		while (despesas.hasNext()) {
			Despesa desp = despesas.next();
			float despesa = desp.getDespesa();
			totalDespesa+= despesa;
		}
		
		Calculadora calculadora = new Calculadora ();
		calculadora.imprime(totalDespesa);
	}
}