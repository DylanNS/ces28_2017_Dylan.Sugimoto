package Q4.orig;

import java.util.Iterator;

public class RelatorioDespesas {
	private Calculadora calculadora;
	private SistemaOperacional so;
	public RelatorioDespesas(Calculadora calc, SistemaOperacional sio) {
		calculadora = calc;
		so = sio;
	}
	public void ImprimirRelatorio(Iterator<Despesa> listaDespesa) {//Realizado troca de nome para melhor leitura.
		
		float totalGasto = 0.0f;
		String conteudo = "";
		Impressora imp;
		totalGasto = calculadora.calcularDespesa(listaDespesa);
		conteudo = criarConteudo(totalGasto);
		so.imprimir(conteudo);
	}
	private String criarConteudo(float totalDespesa) {
		String conteudo = "Relat�rio de Despesas";
		conteudo+=("\n Total das despesas:" + totalDespesa);
		
		return conteudo;
	}
}