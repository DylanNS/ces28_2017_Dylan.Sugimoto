package Q3.TireMonitor;


public class Alarm
{
    private final double LowPressureThreshold;
    private final double HighPressureThreshold;

   // Sensor sensor = new Sensor(); Erroneamente tinhamos uma composição.
    private Sensor sensor;
    
    public Alarm(Sensor sensorNovo,double low, double high) {
    	sensor = sensorNovo;//Agora temos uma agregação.
    	LowPressureThreshold = low;
    	HighPressureThreshold = high;
    }
    //Podemos fazer atualizacoes no alarme ou consertos.
    public void trocarSensor(Sensor novoSensor) {
    	sensor = novoSensor;
    }
    
    boolean alarmOn = false;

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}