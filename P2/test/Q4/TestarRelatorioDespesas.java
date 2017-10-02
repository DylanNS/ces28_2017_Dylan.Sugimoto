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
	
	@InjectMocks RelatorioDespesas rela;
	@Mock Calculadora calc;
	@Mock Despesa des1;
	@Mock Despesa des2;
	@Mock Despesa des3;
	@Mock Impressora imp;
	@Mock SistemaOperacional sio;
	
	private float gastoTotal = 0.0f;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ArrayList<Despesa> listDespesa = new ArrayList<Despesa>();
		gastoTotal = 10.12345f;
		String resposta = "Relat�rio de Despesas"+("\n Total das despesas:" + gastoTotal);
		listDespesa.add(des1);
		listDespesa.add(des2);
		listDespesa.add(des3);
		Iterator<Despesa> IteDespesa = listDespesa.iterator();
		when(calc.calcularDespesa(IteDespesa)).thenReturn(gastoTotal);
		when(sio.getDriverImpressao()).thenReturn(imp);
		when(imp.Imprimir(resposta)).thenReturn("Ok");
	
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
