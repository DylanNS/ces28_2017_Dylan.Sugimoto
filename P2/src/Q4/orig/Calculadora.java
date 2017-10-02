package Q4.orig;

public class Calculadora {
	public void imprime(float totalDespesa) {
		String conteudo = "Relatório de Despesas";
		conteudo+=("\n Total das despesas:" + totalDespesa);

		SistemaOperacional so = new SistemaOperacional();
		so.getDriverImpressao().Imprimir(conteudo);
	}
}
