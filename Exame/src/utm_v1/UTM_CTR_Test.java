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
class UTM_CTR_Test {

	private UTM_CTR _utm;
	private HashMap<Integer,Integer> _map;
	
	@Mock Presenter p;
	@Mock Observable o;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		_utm = UTM_CTR.getINSTANCE();
		_utm.setPresenter(p);
		_map = new HashMap<Integer,Integer>();
	}

	@Test
	void EhPossivelInstanciarUTM() {
		assertNotNull(_utm);
	}
	
	
	@Test
	void SoTemUmaInstanciaUTM() {
		
		UTM_CTR utm2 = UTM_CTR.getINSTANCE();
		
		assertEquals(utm2,_utm);//mesma instancia.
		//Nao tem como usar o new aparece erro de copilação.
	}
	
	@Test
	void enviaMapaGCSPedeParaPresenterEnviarOMapaPassaOMapaEaSiglagcs() {
		_utm.enviaMapaGCS();
		
		Mockito.verify(p, Mockito.times(1)).sendMap(_map,"utm");
	}
	
	@Test
	void updateVerificaASiglautmEChamaOMetododoPresenter() {
		_utm.update(o,"gcs");
		
		Mockito.verify(p, Mockito.times(1)).atualizaMapa(_utm);
		
		_utm.update(o,"posicao");
		
		Mockito.verify(p, Mockito.times(1)).atualizaPosicao(_utm);;
	}
}
