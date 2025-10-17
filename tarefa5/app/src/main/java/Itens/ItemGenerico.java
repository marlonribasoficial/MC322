package Itens;

import Interfaces.Item;

/**
 * Item simples do jogo.
 */
public class ItemGenerico implements Item {
    private String nome;

    public ItemGenerico(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }
}