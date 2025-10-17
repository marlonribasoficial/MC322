package Itens;

import Interfaces.Item;

/**
 * Classe abstrata que representa uma arma no jogo.
 * Toda arma tem um nome, um dano e um nível mínimo para ser utilizada.
 */
public abstract class Arma implements Item {
    private String nome;
    private int dano;
    private int minNivel;

    /**
     * Construtor da classe Arma.
     *
     * @param nome     Nome da arma
     * @param dano     Dano causado pela arma
     * @param minNivel Nível mínimo para usar a arma
     */
    public Arma(String nome, int dano, int minNivel) {
        this.nome = nome;
        this.dano = dano;
        this.minNivel = minNivel;
    }

    // Getters
    @Override
    public String getNome() { return nome; }
    public int getDano() { return dano; }
    public int getMinNivel() { return minNivel; }

    /**
     * Exibe no console a descrição básica da arma (nome, dano e nível).
     */
    public void exibirDescricao() {
        String linha = "=====================================================================";
        System.out.println(linha);
        System.out.printf("| 🗡️ Arma: %-32s\n", this.nome);
        System.out.printf("| ⚔️ Dano: %-32d\n", this.dano);
        System.out.printf("| 🔰 Nível mínimo: %-32d\n", this.minNivel);
    }
}