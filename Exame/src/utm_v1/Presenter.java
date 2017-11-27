/**
 * @author Dylan N. Sugimoto
 * Data: 27/11/2017
 * Este pacote representa a questão 5 do exame de CES-28/2017
 */
package utm_v1;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe Presenter deve executar as responsabilidades de uma CLOUD.
 *
 */
public class Presenter extends Observable implements Observer{

	private HashMap<Integer,Drone> _droneAtivo;
	private int _droneIds;
	private int _id;
	private HashMap<Integer,Integer> _mapa;
	
	public Presenter() {
		
		_droneAtivo = new HashMap<Integer,Drone>();
		_droneIds = 0;
	}
	
	public int registerDrone() {
		
		Drone drone = new Drone(_droneIds);
		drone.addObserver(this);
		_droneAtivo.put(_droneIds, drone);
		int id = _droneIds;
		_droneIds ++;
		return id;
		
	}
	public void mudarPosicaoDrone(int pos,int id) {
		
		Drone drone = _droneAtivo.get(id);
		if(drone == null) {
			//System.out.println("id invalido!");
		}
		else {
			drone.alterarPosicao(pos);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setChanged();
		this._id = (int) arg;
		this.notifyObservers("posicao");
		
	}
	public void atualizaPosicao(UTM_CTR utm) {
		
		HashMap<Integer,Integer> map =  utm.getMapa();
		System.out.println(map);
		Drone drone = this._droneAtivo.get(this._id);
		map.put(this._id, drone.getPos());
	}
	public void sendMap(HashMap<Integer,Integer> map,String msg) {
		//AVisar UTM que GCS enviou o mapa
		this.setChanged();
		this._mapa = map;
		this.notifyObservers(msg);
	}
	public void atualizaMapa(IView UTMouGCS) {
		//passar o mapa do GCS para o UTM
		UTMouGCS.setMap(this._mapa);
	}
}
