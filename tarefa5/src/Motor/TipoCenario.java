package Motor;

import Entidades.Heroi.Heroi;
import Util.Utilidades;

/**
 * Enumeração dos tipos de cenários do jogo.
 * Cada cenário possui uma descrição e um efeito específico aplicado ao herói.
 */
public enum TipoCenario {
    LUA_SOMBRIA("Lua Sombria") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("A baixa gravidade da Lua Sombria aumenta a agilidade de " + heroi.getNome() + "!");
            Utilidades.tempoDeTexto();
        }
    },
    BASE_ABANDONADA("Base Abandonada") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("A atmosfera rarefeita da Base Abandonada testa a resistência de " + heroi.getNome() + ".");
            Utilidades.tempoDeTexto();
        }
    },
    BURACO_NEGRO("Proximidades de um Buraco Negro") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("A distorção temporal perto do Buraco Negro deixa " + heroi.getNome() + " em alerta máximo!");
            Utilidades.tempoDeTexto();
        }
    };

    private String descricao;

    /**
     * Construtor do cenário.
     *
     * @param descricao Descrição textual do cenário
     */
    TipoCenario(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a descrição do cenário.
     *
     * @return {@code String} descrição do cenário
     */
    public String getDescricao() {
        return descricao;
    }
    
    /**
     * Aplica os efeitos específicos do cenário ao herói.
     *
     * @param heroi Herói que sofrerá os efeitos do cenário
     */
    public abstract void aplicarEfeitos(Heroi heroi);
}