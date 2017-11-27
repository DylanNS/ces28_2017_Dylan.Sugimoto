/**
 * @author Dylan N. Sugimoto
 * Data:27/11/2017
 * Q6 do exame CES-28/2017
 */
package utm_v1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Observable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class PresenterTest {

	private Presenter p;
	private Presenter _pSpy;
	private HashMap<Integer,Integer> _map;
	@Mock Observable o;
	@BeforeEach
	void setUp() throws Exception {
	
		p = new Presenter();
		_pSpy = Mockito.spy(p);
		_map = new HashMap<Integer,Integer>();
		}

	@Test
	void EhPossivelInstanciar() {
		assertNotNull(p);
	}

	@Test
	void registrarDroneCriaDroneEretornaID() {
		
		assertEquals(0,p.registerDrone());
		assertEquals(1,p.registerDrone());
		assertEquals(2,p.registerDrone());
	}
	
	@Test
	void updateGuardaOIDEAvisaObserversPassandoSiglaCorreta() {
		
		_pSpy.update(o,10);
		
		Mockito.verify(_pSpy,Mockito.times(1)).notifyObservers("posicao");;
	}
	
	@Test
	void sendMapGuardaOmapaEAvisaObserversPassandoSiglaCorreta() {
		
		_pSpy.sendMap(_map,"gcs");
		
		Mockito.verify(_pSpy,Mockito.times(1)).notifyObservers("gcs");
	}
}
