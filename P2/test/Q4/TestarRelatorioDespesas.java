/**
 * P2 - CES- 28 
 * Questao 4
 * @author Dylan N. Sugimoto
 * 02/20/2017
 */
package Q4;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import Q4.orig.*;

/**
 * @author Dylan N. Sugimoto
 *
 */
public class TestarRelatorioDespesas {
	
	@Mock private Calculadora calc;
	@Mock private Despesa des1;
	@Mock private Despesa des2;
	@Mock private Despesa des3;
	@Mock private Impressora imp;
	@Mock private SistemaOperacional sio;
	
	private RelatorioDespesas rela;
	private float gastoTotal = 0.0f;
	private Iterator<Despesa> iteDespesa;
	private String resposta;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ArrayList<Despesa> listDespesa = new ArrayList<Despesa>();
		gastoTotal = 10.12345f;
		resposta = "Relat�rio de Despesas"+("\n Total das despesas:" + gastoTotal);
		listDespesa.add(des1);
		listDespesa.add(des2);
		listDespesa.add(des3);
		iteDespesa = listDespesa.iterator();
		when(calc.calcularDespesa(iteDespesa)).thenReturn(gastoTotal);
	
	}
	//item b
	@Test
	public void PossivelInstaciarObjetoDaClasseRelatorioDespesas() {
		RelatorioDespesas rela1 = new RelatorioDespesas(calc,sio);
	}
	//item b
	//Refatorado devido ao item c
	@Test
	public void VerificarSeImprimirRelatorioChamaCalculadoraPegaImpressoraEPedePraImpressoraImprimirConteudoEnlatado() {
		
		rela = new RelatorioDespesas(calc,sio);
		rela.ImprimirRelatorio(iteDespesa);
		Mockito.verify(calc, times(1)).calcularDespesa(iteDespesa);
		Mockito.verify(sio, times(1)).imprimir(resposta);
	}

}
