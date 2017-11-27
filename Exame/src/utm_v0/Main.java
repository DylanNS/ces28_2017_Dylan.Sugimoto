/**
 * 
 */
package utm_v0;

/**
 * @author Dylan N. Sugimoto
 * Classe Main que serve para rodar um codigo exemplo.
 */
public class Main {

	public static void main(String[] args) {
		
		Presenter p = new Presenter();
		UTM_CTR utm = UTM_CTR.getINSTANCE();
		utm.setPresenter(p);
		GCS gcs1 = new GCS(p);
		GCS gcs2 = new GCS(p);
		GCS gcs3 = new GCS(p);
		gcs1.mudarPosicaoDrone(10);
		gcs3.mudarPosicaoDrone(99);
}
	}
