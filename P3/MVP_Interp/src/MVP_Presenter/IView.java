/**
 * @author Dylan N. Sugimoto
 * Data: 20/11/2017
 */
package MVP_Presenter;
import java.util.Observer;
/**
 * Interface da view.
 * O Presenter possui um ponteiro para a abstração da View. Baixo acoplamento.
 * A View vai ser um Observer para ser notificada pelo Presenter, assim que algo
 * de baixo (model) for alterado.
 */
public interface IView extends Observer{

}
