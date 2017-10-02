package Q4.orig;

import java.util.ArrayList;

public class SistemaOperacional {
	private ArrayList<Impressora> listImp;
	public SistemaOperacional(ArrayList ImpressoraDetectadas) {
		listImp.addAll( ImpressoraDetectadas);
	}
	public Impressora getDriverImpressao() {
		return listImp.get(0);
	}
	/* Passamos a responsabilidade de imprimir para SistemaOperacional poder delegar
	 * para a impressora. Assim, o Relatório não depende mais da impressora, apenas SistemaOperacional
	 * interage com impressora. Por causa disso foi feito uma grande mudança e os testes também mudaram.*/
	public void imprimir(String conteudo) {
		Impressora imp;
		imp = getDriverImpressao();
		if (imp != null) {
		imp.Imprimir(conteudo);
		}
		else {
			System.out.println("Sem impressoras disponiveis! Falha na Impressao!");
		}
	}
}
