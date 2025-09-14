package Utilidades

public class Utilidades {

    public static void imprimirTituloFase(Fase f) {
        System.out.println("\n════════════════════════════════════════════");
        System.out.printf("🌌 FASE %d — Ambiente: %s\n", f.getNivel(), f.getAmbiente());
        System.out.println("════════════════════════════════════════════\n");
        tempoDeTexto();
    }

    public static void tempoDeTexto() {
        try {
            Thread.sleep(Config.VELOCIDADE_TEXTO);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String gerarBarra(int valor, int maximo, int tamanho) {
        int preenchidos = (int) ((double) valor / maximo * tamanho);
        StringBuilder barra = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            barra.append(i < preenchidos ? "█" : "░");
        }
        return barra.toString();
    }
}
