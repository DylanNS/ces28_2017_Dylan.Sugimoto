/**
 * P2_Q3-Ces-28
 * 02/20/2017
 *  @author Dylan N. Sugimoto
 */
package Q3;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;

import Q3.TireMonitor.Sensor;
import Q3.TireMonitor.Alarm;
/**
 * @author Dylan N. Sugimoto
 *
 */
public class TestarAlarme {
	
	@Mock private Sensor sensor;
	private double limiteSup = 21;
	private double limiteInf = 17;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	
	}
	
	//item b
	//Verificar se pode instanciar Alarm
	//Refatorado devido ao item c
	@Test
	public void PossivelInstanciarAlarm() {
		Alarm alarme = new Alarm(sensor,limiteInf,limiteSup);
	}
	//item b
	//Verificar quando a pressao eh normal, o alarme nao dispara
	//Refatorado devido ao item c
	@Test
	public void PressaoNormalNaoDispara() {
		Alarm alarme = new Alarm(sensor,limiteInf,limiteSup);
		when(sensor.popNextPressurePsiValue()).thenReturn((limiteSup+limiteInf)/2);
		alarme.check();
		assertFalse(alarme.isAlarmOn());
		
	}
	//item b
	//Verificar quando a pressao eh maior, o alarme dispara
	//Refatorado devido ao item c
	@Test
	public void PressaoMaiorqueNormalDispara() {
		Alarm alarme = new Alarm(sensor,limiteInf,limiteSup);
		when(sensor.popNextPressurePsiValue()).thenReturn(limiteSup+1);
		alarme.check();
		assertTrue(alarme.isAlarmOn());
		
	}
	//item b
	//Verificar quando a pressao eh menor, o alarme dispara
	//Refatorado devido ao item c
	@Test
	public void PressaoMenorQueNormalDispara() {
		Alarm alarme = new Alarm(sensor,limiteInf,limiteSup);
		when(sensor.popNextPressurePsiValue()).thenReturn(limiteInf-1);
		alarme.check();
		assertTrue(alarme.isAlarmOn());
		
	}
	//item b
	//verificar se o alarme chama o metodo do sensor para verificar a pressao
	//Refatorado devido ao item c.
	@Test
	public void ParaVerificarPressaoAlarmeChamaSensorUmaVez() {
		Alarm alarme = new Alarm(sensor,limiteInf,limiteSup);
		when(sensor.popNextPressurePsiValue()).thenReturn((limiteSup+limiteInf)/2);
		alarme.check();
		verify(sensor,times(1)).popNextPressurePsiValue();
		
	}
}
