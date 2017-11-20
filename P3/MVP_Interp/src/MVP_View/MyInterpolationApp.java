package MVP_View;

import java.io.File;
import java.util.Observable;
import MVP_Presenter.Presenter;
import java.util.Observer;

import MVP_Models.InterpolationMethod;
/**
 * 
 * @author Dylan N. Sugimoto
 * MyInterpolationApp virou a view que implementa a interface IView.
 * Logo, MyInterpolationApp é um Observer de Presenter.
 * MyInterpolationApp tem um ponteiro para Presenter (camada de baixo).
 *  RESPONSABILITY: IMPRIMIR RESULTADOS
 *  DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
 *  DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO)
 */
public class MyInterpolationApp  implements Observer{
    
	private Presenter _myPresenter;

    public MyInterpolationApp() {
        _myPresenter = new Presenter();
        _myPresenter.addObserver(this);
        
     }


  
//RESPONSABILITY: DEFINIR QUAL EH O ARQUIVO COM DADOS DE PONTOS DA FUNCAO (LEITURA ENTRADA DE USUARIO HUMANO)
    private void askUserFile(File file) {
    	if(file == null)
            return;
         else _myPresenter.setFile(file);
    }
  //RESPONSABILITY:DEFINIR PONTO DE INTERPOLACAO (LEITURA ENTRADA DE USUARIO HUMANO)
    private void askUserInterpolationPoint(float point) {
    	_myPresenter.calculateResult(point);
    }
  //RESPONSABILITY:DEFINIR Method (LEITURA ENTRADA DE USUARIO HUMANO)
    private void askUserMethod(String method) {
    	_myPresenter.setMethod(method);
    }
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
		   System.out.println("FIM");
	    }

	//Sempre que o Presenter notificar alguma alteração para View, vai ser para View imprimir algo.
   // RESPONSABILITY: IMPRIMIR RESULTADOS, AVISOS E CASOS DE ERROS.
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println(arg1);
	}
	
	//Deixa o Usuario criar a sua classe Model que deve implementar a Interface do Model
	//E ele define o novo metodo criando uma instancia da classe que ele criou e
	//passando como parametro para esta funcao que delega para o presenter.
	public void defineNewInterpolationCalculate(InterpolationMethod myMethod) {
		_myPresenter.defineNewMethod(myMethod);
	}
	
}//class
