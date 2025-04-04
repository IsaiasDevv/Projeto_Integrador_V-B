package sistemamonitoramento;

import java.util.Scanner;

public class Monitoramento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // Loop principal do programa
            // Exibe o menu inicial
            System.out.println();
            System.out.println("=====================================");
            System.out.println("  SISTEMA DE MONITORAMENTO AMBIENTAL  ");
            System.out.println("=====================================");
            System.out.println();
            System.out.println("Escolha a área da casa que deseja monitorar:");
            System.out.println();
            System.out.println("1 - Banheiro");
            System.out.println("2 - Cozinha");
            System.out.println("3 - Quarto 1");
            System.out.println("4 - Quarto 2");
            System.out.println("5 - Quarto 3");
            System.out.println("6 - Sala");
            System.out.println();
            System.out.print("Digite o número correspondente à área: ");

            int escolha = scanner.nextInt(); // Captura a escolha do usuário
            scanner.nextLine(); // Consumir a quebra de linha
            String areaSelecionada = "";

            // Define qual área foi escolhida
            switch (escolha) {
                case 1:
                    areaSelecionada = "Banheiro";
                    break;
                case 2:
                    areaSelecionada = "Cozinha";
                    break;
                case 3:
                    areaSelecionada = "Quarto 1";
                    break;
                case 4:
                    areaSelecionada = "Quarto 2";
                    break;
                case 5:
                    areaSelecionada = "Quarto 3";
                    break;
                case 6:
                    areaSelecionada = "Sala";
                    break;
                default:
                    System.out.println("Opção inválida! O programa será encerrado.");
                    return; // Sai do programa se a escolha for inválida
            }

            // Mensagem de coleta dos dados
            System.out.println();
            System.out.println("\nSendo coletado os dados dos sensores do ambiente...");
            System.out.println();
            try {
                Thread.sleep(3000); // Espera 3 segundos antes de exibir os dados
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("\nMonitorando a área: " + areaSelecionada + "\n");

            // Exibir os dados 5 vezes antes de perguntar se deseja continuar
            for (int i = 1; i <= 5; i++) {
                System.out.println("----------------------------------");
                System.out.println("\nÁrea: " + areaSelecionada);
                System.out.println();
                SensorData dados = SimuladorArduino.gerarDadosSimulados();
                dados.exibirDados();
                System.out.println("\n----------------------------------");
                System.out.println();

                try {
                    Thread.sleep(5000); // Espera 5 segundos antes da próxima leitura
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Perguntar se deseja continuar após 5 leituras
            System.out.println();
            System.out.print("Deseja continuar o monitoramento? (S/N): ");
            String resposta = scanner.nextLine().trim().toUpperCase();
            System.out.println();
            if (!resposta.equals("S")) {
                System.out.println("\nMonitoramento encerrado. Obrigado por usar o sistema!");
                break; // Sai do loop e finaliza o programa
            }
        }
        scanner.close(); // Fecha o Scanner ao final do programa
    }
}
