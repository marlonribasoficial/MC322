package Utilidades;

import Heroi.Heroi;

public enum TipoCenario {
    LUA_SOMBRIA("Lua sombria e misteriosa, drenando energia vital.") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            heroi.receberDano(5); // perde um pouco de vida no início
        }
    },
    BASE_ABANDONADA("Base abandonada, restos tecnológicos fortalecem você.") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            heroi.receberCura(10); // ganha vida extra
        }
    },
    BURACO_NEGRO("Buraco negro instável, sua força é comprimida pela gravidade.") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            heroi.setForca(Math.max(1, heroi.getForca() - 5)); // perde força temporariamente
        }
    };

    private final String descricao;

    TipoCenario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void aplicarEfeitos(Heroi heroi);
}