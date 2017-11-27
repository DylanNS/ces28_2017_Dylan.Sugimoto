/**
 * @author Dylan N. Sugimoto
 * Data: 27/11/2017
 * Este pacote representa a questão 5 do exame de CES-28/2017
 */
package utm_v0;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe Drone implementa as responsabilidades de Drone.
 * Na verdade, não vamos implementar realisticamente o Drone, pois
 * o Drone usa uma I.A. embarcada e não vamos fazer isso.
 * Vamos fazer varias funções fakes que representam essas ações.
 */
public class Drone extends Observable{

	//atributo que guarda a posicao do drone.
	private int _posicao;
	//Um atributo id para o Presenter associar o drone a sua GCS
	private final int _ID;
	private Timer _timer;
	private int _delay=0;
	private int _interval = 1000;//1 segundo
	
	public Drone(int id) {
		
		this._ID = id;
		this._posicao = 19;
		_timer = new Timer();
		this._timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	        	enviaPosUTM();
	        }
	    }, this._delay, this._interval);
	}
	
	//Sabe desviar dos outros drones.
	//Supoe-se que a posicao dos drones por perto
	//venha de um sensor que detecta objetos
	private void avoidColision(ISensor sensor) {
		//DependencyInjection para o sensor afinal é um elemento externo. Hardware.
		//O metodo do sensor ObjetosProximos diz True se o drone está proximo de um objeto
		//Dai o drone realiza a manobra de desvio
		//Ou Finge que realizou a manobra
		//Afinal nao vamos implementar uma I.A. aqui =)
		if(sensor.ObjetosProximos()) {
			System.out.println("MANOBRA DE DESVIO REALIZADA!!!");
		}
	}
	
	//Envia posicao para UTM
	//Envia de 10 em 10 segundos
	//Na verdade de 1 em 1 segundo
	private void enviaPosUTM() {
		this.setChanged();
		this.notifyObservers(this._ID);
		System.out.println("Drone"+this._ID+ "envia posicao"+this._posicao+"para UTM");
	}
	
	public int getPos() {
		return this._posicao;
	}
	
	public void alterarPosicao(int posicao) {
		
		this._posicao = posicao;
		System.out.println("Drone recebeu comandos de voo de GCS");
	}
}
