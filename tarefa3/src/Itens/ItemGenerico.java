package Itens;

import Interfaces.Item;

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