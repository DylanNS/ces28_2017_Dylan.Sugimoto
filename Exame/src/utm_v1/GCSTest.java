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
import org.mockito.MockitoAnnotations;

/**
 * @author Dylan N. Sugimoto
 *
 */
class GCSTest {

	private GCS _gcs;
	private HashMap<Integer,Integer> _map;
	
	@Mock Presenter p;
	@Mock Observable o;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		_gcs = new GCS(p);
		_map = new HashMap<Integer,Integer>();
	}

	@Test
	void EhPossivelInstanciarGCS() {
		assertNotNull(_gcs);
	}
	
	@Test
	void enviaMapaUTMPedeParaPresenterEnviarOMapaPassaOMapaEaSiglagcs() {
		_gcs.enviaMapaUTM();
		
		Mockito.verify(p, Mockito.times(1)).sendMap(_map,"gcs");
	}
	
	@Test
	void updateVerificaASiglautmEChamaOMetodoAtualizaMapaSePassandoComoArgumento() {
		_gcs.update(o,"utm");
		
		Mockito.verify(p, Mockito.times(1)).atualizaMapa(_gcs);
	}

	@Test
	void mudarPosicaoDroneChamaOPresenterParaMudarAPosicaoDoDronePassaANovaPosicaoEIdDoDrone() {
		Mockito.when(p.registerDrone()).thenReturn(10);
		_gcs = new GCS(p);
		_gcs.mudarPosicaoDrone(10);
		
		Mockito.verify(p, Mockito.times(1)).mudarPosicaoDrone(10,10);
	}
}
