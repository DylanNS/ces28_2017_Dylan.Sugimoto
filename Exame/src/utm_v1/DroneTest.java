/**
 * @author Dylan N. Sugimoto
 * Data:27/11/2017
 * Q6 do exame CES-28/2017
 */
package utm_v1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

/**
 * 
 *
 */
class DroneTest {

	private Drone _drone;
	private Drone _droneSpy;
	private int _Id;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		_Id = 10;
		_drone = new Drone(_Id);
		_droneSpy = Mockito.spy(_drone);
	}

	@Test
	void EhPossivelInstanciarDrone() {
		assertNotNull(_drone);
	}
	
	//Testar os metodos de alterar posicao e pegar posicao
	@Test
	void alterarPosicaoAlteraPosicaoDoAtributoQueEhPegoEmgetPos() {
		
		_droneSpy.alterarPosicao(0);
		assertEquals(0,_droneSpy.getPos());
		
		_droneSpy.alterarPosicao(10);
		assertEquals(10,_droneSpy.getPos());
	}

	//Testar os metodos de alterar posicao e pegar posicao
		@Test
		void enviaPosUTMChamaFuncaoDeNotificacaoDeObserverEPassaOID() {
			
			_droneSpy.enviaPosUTM();
			//Notifica o Presenter e envia o id.
			Mockito.verify(_droneSpy, Mockito.times(1)).notifyObservers(_Id);
		}
}
