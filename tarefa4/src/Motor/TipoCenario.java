package Motor;

import Entidades.Heroi.Heroi;
import Util.Utilidades;

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

    TipoCenario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void aplicarEfeitos(Heroi heroi);
}