/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import main.Sensor;
import main.Datacenter;
import main.PainelCondutor;
import main.controladorPTC;
/**
 * @author Dylan N. Sugimoto
 *
 */
public class testeControladorPTC {

	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		
	}
	@Mock private Sensor sensor;
	@Mock private Datacenter center;
	@Mock private PainelCondutor condutor;
	
	/**
	 * Teste para verificar inicializacao do controlador PTC
	 * Se acontecer o lançamento de uma exception falha o teste,
	 * caso contrario codigo passa no teste.
	 * Q4a
	 */
	@Test
	public void testInicializacaoControladorPTC() {
		controladorPTC control = new controladorPTC(sensor,center,condutor);
		
	}

	/**
	 * Teste para verificar run do controlador PTC
	 * quando o trem nao esta no cruzamento.
	 * Q4b
	 */
	@Test
	public void testVerificarMetodoRunSeNaoTaNoCruzamentoEnviaMsgDataCenterEnviaMsgNormalPainelUmaVezCada() {
		controladorPTC control = new controladorPTC(sensor,center,condutor);
		double velocidade = 100.0;
		String velo = new Double(velocidade).toString();
		Mockito.when(sensor.getVelocidade()).thenReturn(velocidade);
		Mockito.when(sensor.isCruzamento()).thenReturn(false);
		Mockito.when(condutor.imprimirAviso(velo, 1)).thenReturn(true);
		control.run();
		
		//Verifica o comportamento esperado
		//comportamento esparado:
		//chamar imprimirAviso de condutor
		//chamar gerarRelatorio de center
		Mockito.verify(condutor, Mockito.times(1)).imprimirAviso(velo,1);
		Mockito.verify(condutor, Mockito.times(0)).imprimirAviso("Velocidade alta",1);
		Mockito.verify(condutor, Mockito.times(0)).imprimirAviso("Velocidade Baixa",1);
		Mockito.verify(center, Mockito.times(1)).gerarRelatorio("100.0");
		Mockito.verify(condutor, Mockito.times(0)).diminuiVelocidadeTrem(velocidade);
		Mockito.verify(condutor, Mockito.times(0)).aceleraVelocidadeTrem(velocidade);
		
	}
	
	/**
	 * Teste para verificar run do controlador PTC
	 * quando o trem esta no cruzamento com velocidade maior 100 e
	 * painel controle consegue imprimir aviso.
	 * Q4c
	 */
	@Test
	public void testVerificarMetodoRunSeTaNoCruzamentoComVelocidadeMaiorQue100ApenasImprimeAvisoDuasVezDataCenterImprimeUmaVez() {
		controladorPTC control = new controladorPTC(sensor,center,condutor);
		double velocidade = 100.1;
		String velo = new Double(velocidade).toString();
		Mockito.when(sensor.getVelocidade()).thenReturn(velocidade);
		Mockito.when(sensor.isCruzamento()).thenReturn(true);
		Mockito.when(condutor.imprimirAviso("Velocidade alta", 1)).thenReturn(true);
		control.run();
		
		//Verifica o comportamento esperado
		//comportamento esparado:
		//chamar imprimirAviso de condutor
		//chamar gerarRelatorio de center
		Mockito.verify(condutor, Mockito.times(1)).imprimirAviso("Velocidade alta",1);
		Mockito.verify(condutor, Mockito.times(1)).imprimirAviso(velo,1);
		Mockito.verify(center, Mockito.times(1)).gerarRelatorio(velo);
		Mockito.verify(condutor, Mockito.times(0)).diminuiVelocidadeTrem(velocidade);
		Mockito.verify(condutor, Mockito.times(0)).aceleraVelocidadeTrem(velocidade);
		
	}
	
	/**
	 * Teste para verificar run do controlador PTC
	 * quando o trem esta no cruzamento com velocidade menor que 20
	 * e painel controle falha na leitura.
	 * Q4d
	 */
	@Test
	public void testVerificarMetodoRunSeTaNoCruzamentoComVelocidadeMenorQue20() {
		controladorPTC control = new controladorPTC(sensor,center,condutor);
		double velocidade = 19.9;
		String velo = new Double(velocidade).toString();
		Mockito.when(sensor.getVelocidade()).thenReturn(velocidade);
		Mockito.when(sensor.isCruzamento()).thenReturn(true);
		Mockito.when(condutor.imprimirAviso("Velocidade Baixa", 1)).thenReturn(false);
		control.run();
		
		//Verifica o comportamento esperado
		//comportamento esparado:
		//chamar imprimirAviso de condutor
		//chamar gerarRelatorio de center
		Mockito.verify(condutor, Mockito.times(2)).imprimirAviso("Velocidade Baixa",1);
		Mockito.verify(center, Mockito.times(0)).gerarRelatorio("100.0");
		Mockito.verify(condutor, Mockito.times(0)).diminuiVelocidadeTrem(velocidade);
		Mockito.verify(condutor, Mockito.times(1)).aceleraVelocidadeTrem(20.0);
		
	}
}
