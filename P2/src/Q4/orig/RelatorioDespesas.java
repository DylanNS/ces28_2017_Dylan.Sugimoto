package Q4.orig;

import java.util.Iterator;

public class RelatorioDespesas {
	public void ImprimirRelatorio(Iterator<Despesa> listaDespesa) {//Realizado troca de nome para melhor leitura.
		
		float totalGasto = 0.0f;
		String conteudo = "";
		Impressora imp;
		Calculadora calculadora = new Calculadora ();
		totalGasto = calculadora.calcularDespesa(listaDespesa);
		conteudo = criarConteudo(totalGasto);
		imp = getImpressora();
		imp.Imprimir(conteudo);
	}
	private String criarConteudo(float totalDespesa) {
		String conteudo = "Relat�rio de Despesas";
		conteudo+=("\n Total das despesas:" + totalDespesa);
		
		return conteudo;
	}
	private Impressora getImpressora() {
		SistemaOperacional so = new SistemaOperacional();
		return so.getDriverImpressao();
	}
}