/**
 * 
 */
package utm_v0;

import java.util.HashMap;
import java.util.Observer;

/**
 * @author Dylan N. Sugimoto
 * Interface da View.
 * Presenter possui ponteiro para essa interface.
 * Essa interface é um Observer ou extende um Observer.
 * Essa interface serve para poder fazer polimorfismo no metodo atualizaMapa do Presenter.
 */
public interface IView extends Observer{

	public void setMap(HashMap<Integer,Integer> map);
}
