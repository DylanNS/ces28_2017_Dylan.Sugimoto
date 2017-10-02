package Q4.orig;

import java.util.Iterator;

public class Calculadora {
	
	
	public float calcularDespesa(Iterator<Despesa> listaDespesa) {
		float totalDespesa = 0.0f;
		while (listaDespesa.hasNext()) { //Realizado troca de nome para melhor leitura.
			Despesa desp = listaDespesa.next();//Realizado troca de nome para melhor leitura.
			float valorGasto = desp.getValorGasto();//Realizado troca de nome para melhor leitura.
			totalDespesa+= valorGasto;
		}
		return totalDespesa;
	}
}
