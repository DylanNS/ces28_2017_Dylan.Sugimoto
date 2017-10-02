package Q3.TireMonitor;

import java.util.Random;

public class SampleRandomGenerator extends SampleGenerator {
	private Random basicRandomNumbersGenerator;
	public SampleRandomGenerator() {
		basicRandomNumbersGenerator = new Random();
	}
	
	 public double samplePressure() {
	     
	     return 6 * basicRandomNumbersGenerator.nextDouble() 
	    		 * basicRandomNumbersGenerator.nextDouble();
	   
	 }
}
