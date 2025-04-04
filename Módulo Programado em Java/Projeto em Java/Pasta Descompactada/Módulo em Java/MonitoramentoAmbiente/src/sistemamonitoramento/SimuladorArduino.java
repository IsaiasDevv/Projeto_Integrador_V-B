package sistemamonitoramento;

import java.util.Random;

public class SimuladorArduino {
    private static Random random = new Random();

    public static SensorData gerarDadosSimulados() {
        double temperatura = 15 + random.nextDouble() * 20; // Temperatura entre 15°C e 35°C
        int umidade = 30 + random.nextInt(51); // Umidade entre 30% e 80%
        int luminosidade = random.nextInt(101); // Luminosidade entre 0% e 100%

        return new SensorData(temperatura, umidade, luminosidade);
    }
}
