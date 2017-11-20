package MVP_Models;

import java.util.Vector;

/**
 * Created by atempa on 13/07/16.
 * //RESPONSABILIDADE: EFETIVAMENTE IMPLEMENTAR UM METODO DE INTERPOLACAO
 */
public interface InterpolationMethod {
	//RESPONSABILIDADE: EFETIVAMENTE IMPLEMENTAR UM METODO DE INTERPOLACAO
    double calculateResult(double t, Vector<Double> xx, Vector<Double> yy);
}