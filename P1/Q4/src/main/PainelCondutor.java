package main;
/**
 * 
 * @author Dylan N. Sugimoto
 * interface para poder criar objetos falsos para o test double.
 */
public interface PainelCondutor {
	public boolean imprimirAviso(String msg, int prioridade);
	public void diminuiVelocidadeTrem(double valor);
	public void aceleraVelocidadeTrem(double valor);
}
