package sistemamonitoramento;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class SensorData {
    private double temperatura;
    private int umidade;
    private int luminosidade;
    private boolean luzLigada;
    private static final DecimalFormat df = new DecimalFormat("0.0", 
        DecimalFormatSymbols.getInstance(Locale.US));

    public SensorData(double temperatura, int umidade, int luminosidade) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.luminosidade = luminosidade;
        this.luzLigada = luminosidade > 50; // Simula acender a luz se a luminosidade for maior que 50%
    }

    public void exibirDados() {
        System.out.println("Temperatura: " + df.format(temperatura) + "°C");
        System.out.println("Umidade: " + umidade + "%");
        System.out.println("Luminosidade: " + luminosidade + "% - " + (luzLigada ? "Luz Ligada" : "Luz Desligada"));
    }
}
