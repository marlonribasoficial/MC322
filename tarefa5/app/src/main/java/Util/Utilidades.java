package Util;

import Entidades.Heroi.Heroi;
import Itens.Arma;

/**
 * Métodos utilitários diversos para o jogo.
 * Inclui geração de barras de status, exibição de painel de armas e pausas no texto.
 */
public class Utilidades {

    /** Pausa o fluxo de execução por VELOCIDADE_TEXTO milissegundos. */
    public static void tempoDeTexto() {
        try {
            Thread.sleep(Config.VELOCIDADE_TEXTO);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gera uma barra visual representando valor/maximo.
     * 
     * @param valor valor atual
     * @param maximo valor máximo
     * @param tamanho tamanho da barra
     */
    public static String gerarBarra(int valor, int maximo, int tamanho) {
        int preenchidos = (int) ((double) valor / maximo * tamanho);
        StringBuilder barra = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            barra.append(i < preenchidos ? "█" : "░");
        }
        return barra.toString();
    }

    /**
     * Mostra painel comparando a nova arma encontrada com a arma atual do herói.
     */
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