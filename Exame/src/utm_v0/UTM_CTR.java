/**
 *  @author Dylan N. Sugimoto
 *  Data: 27/11/2017
 *  Este pacote representa a questão 5 do exame de CES-28/2017
 */
package utm_v0;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe UTM-CTR implementa todas as funcionalidades de uma UTM-CTR
 * É um Singleton para cumprir o requisito de única instância.
 */
public class UTM_CTR implements IView{

	//_INSTANCE guarda a instancia unica de UTM
	//static garante que seja unica por classe
	private static UTM_CTR _INSTANCE;
	private HashMap<Integer,Integer> _mapa;
	private Presenter _myPresenter;
	
	private Timer _timer;
	private int _delay=0;
	private int _interval = 2000;//2 segundos
	
	//Construtor privado para evitar deixar usar new
	private UTM_CTR() {
		this._mapa = new HashMap<Integer,Integer>();
		_timer = new Timer();
		this._timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	        	enviaMapaGCS();
	        }
	    }, this._delay, this._interval);
	}
	public void setPresenter(Presenter p) {
		_myPresenter = p;
		p.addObserver(this);
	}
	
	//Metodo publico para pegar a instancia de UTM
	public static UTM_CTR getINSTANCE() {
		if( _INSTANCE == null) {
			_INSTANCE = new UTM_CTR();
		}
		return _INSTANCE;
	}
	
	public HashMap<Integer,Integer> getMapa() {
		System.out.println("MAP"+_mapa);//Apenas para ver o mapa para conferir os valores
		return this._mapa;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1=="posicao") {
			_myPresenter.atualizaPosicao(this);
			System.out.println("UTM recebeu posicao de Drone");
		}
		else if(arg1 =="gcs") {
			_myPresenter.atualizaMapa(this);
			System.out.println("UTM recebeu mapa de GCS");
		}
		
	}
	//Recebeu mapa do GCS pelo CLOUD
	public void setMap(HashMap<Integer,Integer> map) {
		
		this._mapa = map;
	}
	
	//ENvia Mapa pro GCS de tempos em tempos
	public void enviaMapaGCS() {
		_myPresenter.sendMap(this._mapa,"utm");
	}
}
