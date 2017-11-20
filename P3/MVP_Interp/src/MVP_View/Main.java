/**
 * 
 */
package MVP_View;

import java.io.File;

/**
 * @author Dylan N. Sugimoto
 *
 */
public class Main {

	//DEIXAMOS A MAIN AQUI NO VIEW SÓ PARA NÃO PRECISAR CRIAR OUTRO PKG, SÓ PARA RODAR A MAIN.
	   public static void main(String[] args) {
		   // RESPONSABILITY: CREATE APP
		   MyInterpolationApp myInterp = new MyInterpolationApp();

        // ENTRADA DE USUARIO HUMANO: ESCOLHA DO METODO DE INTERPOLACAO   
        // RESPONSABILITY: LEITURA DO NOME DO METODO DE INTERPOLACAO
		   myInterp.askUserMethod("Lagrange");
		// ENTRADA DE USUARIO HUMANO: PONTO DE INTERPOLACAO E NOME DO ARQUIVO DE DADOS.   
		// RESPONSABILITY: DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO) 
		// RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
		   myInterp.askUserFile(new File("./data.dat"));
		   myInterp.askUserInterpolationPoint(10.3f);
		   System.out.println("FIM");//Só para saber que terminou.
	    }
}
