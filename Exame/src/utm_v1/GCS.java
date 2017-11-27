/**
 * @author Dylan N. Sugimoto
 * Data: 27/11/2017
 * Este pacote representa a questão 5 do exame de CES-28/2017
 */
package utm_v1;

import java.util.HashMap;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe implementa as resposabilidades funcionais do GCS
 * GCS é uma view, por isso implementa a interface Observer.
 */
public class GCS implements IView{

	private Presenter _myPresenter;
	private int _droneID;
	private HashMap<Integer,Integer> _mapa;
	//private Timer _timer;
	//private int _delay=0;
	//private int _interval = 2000;//2 segundos
	
	public GCS(Presenter myPresenter) {
		
		_myPresenter = myPresenter;
		_myPresenter.addObserver(this);
		this._droneID = _myPresenter.registerDrone();
		
		/*this._timer = new Timer();
		this._timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	        	enviaMapaUTM();
	        }
	    }, this._delay, this._interval);
		
		Não precisa disso se queremos testar. Afinal thread nao eh possivel de ser mockado
	    e timer não interessa para o teste.*/
		_mapa = new HashMap<Integer,Integer>() ;
	}
	
	public void mudarPosicaoDrone(int pos) {
		_myPresenter.mudarPosicaoDrone(pos,this._droneID);
	}
	
	//envia de 20 em 20 segundos o mapa pro UTM
	public void enviaMapaUTM() {
		_myPresenter.sendMap(this._mapa,"gcs");
		//System.out.println("GCS envia mapa para UTM");
	}
	//Recebeu mapa do UTM pelo CLOUD
	public void setMap(HashMap<Integer,Integer> map) {
		if(map != null && !map.isEmpty())
		this._mapa = map;
	}
	@Override
	public void update(Observable o, Object arg) {
		
		if(arg == "utm") {
			this._myPresenter.atualizaMapa(this);
			//System.out.println("GCS recebeu mapa de UTM");
		}
	}

}
