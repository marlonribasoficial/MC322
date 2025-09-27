package Itens;

import Interfaces.Item;

public abstract class Arma implements Item {
    private String nome;
    private int dano;
    private int minNivel;

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

    public void exibirDescricao() {
        String linha = "=====================================================================";
        System.out.println(linha);
        System.out.printf("| 🗡️ Arma: %-32s\n", this.nome);
        System.out.printf("| ⚔️ Dano: %-32d\n", this.dano);
        System.out.printf("| 🔰 Nível mínimo: %-32d\n", this.minNivel);
    }
}