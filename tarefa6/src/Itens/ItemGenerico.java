package Itens;

import Interfaces.Item;

/**
 * Item simples do jogo.
 */
public class ItemGenerico implements Item {

    public ItemGenerico() {
        super();
    }

    private String nome;

    public ItemGenerico(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }
}