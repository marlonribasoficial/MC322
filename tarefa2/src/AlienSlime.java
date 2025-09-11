import java.util.List;

/* 
Alien Slime:
- Atributos: Nome, Vida, Força, XP concedida, Estado de contaminação
- Ataques: joga gosma radioativa, chance de contaminar
- Habilidade Especial: se fragmenta e regenera parte da vida
*/

public class AlienSlime extends Monstro {
    private int pontosDeVidaMaximo;

    public AlienSlime(String nome,
                    int pontosDeVida,
                    int forca,
                    int xpConcedido,
                    int pontosDeVidaMaximo,
                    Arma arma,
                    List<Arma> listaDeArmasParaLargar) {
        super(nome, pontosDeVida, forca, xpConcedido, arma, listaDeArmasParaLargar);
        this.pontosDeVidaMaximo = pontosDeVidaMaximo;
    }

    // Getter
    @Override
    public int getPontosDeVidaMaximo() { return pontosDeVidaMaximo; }

    // Setter
    public void setPontosDeVidaMax(int novaVidaMax) {
        this.pontosDeVidaMaximo = novaVidaMax;
    }

    @Override
    public void atacar(Personagem alvo) {
        int danoTotal;

        danoTotal = arma.atacarComArma(this, alvo);
        
        // se não houve ataque com arma
        if (danoTotal == this.forca) {
            System.out.printf("🟢 %s arremessa uma gosma radioativa contra %s!\n\n", this.nome, alvo.getNome());
            Main.tempoDeTexto();
        }

        alvo.receberDano(danoTotal);

        // Chance de contaminação
        if (Math.random() < 0.5) {
            int danoContaminacao = forca / 2;
            System.out.printf("☣️ %s foi contaminado! Perderá %d de vida no próximo turno.\n\n", alvo.getNome(), danoContaminacao);
            Main.tempoDeTexto();
            alvo.setContaminado(true);
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.4) { // 40% de chance de regenerar
            System.out.printf("💀 %s se fragmenta em duas massas e recupera 25%% da sua vida!\n\n", this.nome);
            Main.tempoDeTexto();
            pontosDeVida += pontosDeVida / 4;
            if (pontosDeVida > pontosDeVidaMaximo) pontosDeVida = pontosDeVidaMaximo;
        }
    }
}