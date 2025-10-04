package Util;

import Entidades.Heroi.Heroi;
import Itens.Arma;

public class Utilidades {

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

    public static void mostrarPainel(Heroi heroi, Arma novaArma) {
        String linha = "=====================================================================";

        System.out.println(linha);

        // Título do painel centralizado
        System.out.println("            🔹🔷🔶  PAINEL DE ANÁLISE DE ARMAS 🔶🔷🔹");
        System.out.println(linha);

        // Nova arma
        System.out.println("                        🔹  NOVA ARMA  🔹");
        novaArma.exibirDescricao();

        // Arma atual
        if (heroi.getArma() != null) {
            System.out.println("                        🔸  ARMA ATUAL  🔸");
            heroi.getArma().exibirDescricao();
        }
    }
}