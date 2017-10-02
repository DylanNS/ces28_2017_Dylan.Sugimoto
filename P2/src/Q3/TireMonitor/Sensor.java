package Q3.TireMonitor;

import java.util.Random;

//The reading of the pressure value from the sensor is simulated in this implementation.
//Because the focus of the exercise is on the other class.

public class Sensor {
 //public static final double OFFSET = 16;
	private static final double OFFSET = 16;
    private SampleGenerator _generator;
 
 public Sensor(SampleGenerator gen) {
	 _generator = gen;
 }
 
 public double popNextPressurePsiValue() {
     double pressureTelemetryValue;
     pressureTelemetryValue = samplePressure( );

     return OFFSET + pressureTelemetryValue;
 }
public double getOffset() {
	return OFFSET;
}
 private double samplePressure() {
     // placeholder implementation that simulate a real sensor in a real tire
     //Random basicRandomNumbersGenerator = new Random();
     //double pressureTelemetryValue = 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
     double pressure = _generator.samplePressure();
	 return pressure;
 }
 
}//class