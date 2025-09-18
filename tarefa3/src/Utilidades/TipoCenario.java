package Utilidades;

import Heroi.Heroi;

public enum TipoCenario {
    LUA_SOMBRIA("descricao"),
    BASE_ABANDONADA("descricao"),
    BURACO_NEGRO("descricao");

    private final String descricao;

    private TipoCenario(String descricao) {
        this.descricao = descricao;
    } 

    String getDescricao() {
        return descricao;
    }

    void aplicarEfeitos(Heroi heroi) {
        // fazer
    }
}
