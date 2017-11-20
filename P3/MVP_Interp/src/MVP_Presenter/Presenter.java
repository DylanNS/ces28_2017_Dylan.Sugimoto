/**
 * @author Dylan N. Sugimoto
 * Data: 20/11/2017
 */
package MVP_Presenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
/**
 * Presenter possui um ponteiro para a interface da View.
 * O presenter possui ponteiro para a model (camada de baixo).
 * RESPONSABILITY: 
 * ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
 * DADO O VALOR DE X, EFETIVAMENTE LER O ARQUIVO E CHAMAR O CALCULO. 
 * LER ARQUIVO DE DADOS
 */
import java.util.Observable;
import java.util.StringTokenizer;
import java.util.Vector;

import MVP_Models.CubicSpline;
import MVP_Models.InterpolationMethod;
import MVP_Models.Lagrange;

public class Presenter extends Observable{

	private InterpolationMethod interpolationModel;
    
    private FileReader input;
    private BufferedReader bufRead;
    private StringTokenizer xy;
    private double _value, result;
    private File _file;
    private Vector<Double> x, y;
    private final String CS_METHOD = "Cubic Spline";
    private final String L_METHOD = "Lagrange";
    private DecimalFormat formatResult = new DecimalFormat("####.######");
    private final String DEFAULT_METHOD = CS_METHOD;

 
	public Presenter(){
		bind();
	}
	public void bind() {
        
       this.setMethod(DEFAULT_METHOD);
    }
	// RESPONSABILITY: ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
    public InterpolationMethod getMethod() { return interpolationModel; }
    public void setMethod(String method) {
        switch (method) {
            case L_METHOD:
                interpolationModel = new Lagrange();
                break;
            case CS_METHOD:
                interpolationModel = new CubicSpline();
                break;
            default:
            	this.notifyObservers("Unknown method " + method);
        }
    }
    
    // RESPONSABILITY: DADO O VALOR DE X, EFETIVAMENTE LER O ARQUIVO E CHAMAR O CALCULO. 
    public void calculateResult(float value) {
        _value = value;
        buildDataPoints();
        if(getMethod() != null) {
            result = getMethod().calculateResult(_value, x, y);
            printResult();
        } else {
        	this.notifyObservers("It is not defined an interpolation method.");
        }
    }
    
    // RESPONSABILITY: LER ARQUIVO DE DADOS
 	private void buildDataPoints() {

         x = new Vector<Double>();
         y = new Vector<Double>();
         try {
             input = new FileReader(_file);
 		    /* Filter FileReader through a Buffered read to read a line at a time */
             bufRead = new BufferedReader(input);
             // Read first line
             String line = bufRead.readLine();
             // Read through file one line at time.
             while (line != null){
                 xy = new StringTokenizer(line, "\t ");
                 while(xy.hasMoreTokens()) {
                     x.addElement(Double.parseDouble(xy.nextToken()));
                     y.addElement(Double.parseDouble(xy.nextToken()));
                 }
                 line = bufRead.readLine();
             }
             bufRead.close();
         } catch (IOException e) { // If another exception is generated, print a stack trace
             e.printStackTrace();
         }
     }//buildDataPoints
 	public File getDataFile() {
        
        return _file;
    }
 	public void setFile(File arquivo) {
 		_file = arquivo;
 	}
 	//Notificar a view da alteracao e pedir para imprimir o resultado.
 	private void printResult() {
 		String texto = "***********************"+"\n"
 	                   +"DataFile: " + getDataFile()+"\n"
 	                   +"Interp at " + formatResult.format(_value) + " ; result = " + formatResult.format(result)
 	                   +"\n";
 	    this.setChanged();
 		this.notifyObservers(texto);
 	}
}
