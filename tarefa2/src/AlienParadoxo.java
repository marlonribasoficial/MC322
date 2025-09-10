import java.util.List;

/* 
Alien Paradoxo:
- Atributos: Nome, Vida, Força, XP concedida, Estado de reflexo
- Ataques: ataque caótico OU paradoxo que cura
- Habilidade Especial: ativa espelho temporal (reflete próximo ataque)
*/

public class AlienParadoxo extends Monstro {
    private int pontosDeVidaMaximo;
    private boolean refletido;

    public AlienParadoxo(String nome,
                        int pontosDeVida,
                        int forca,
                        int xpConcedido,
                        int pontosDeVidaMaximo,
                        boolean refletido,
                        Arma arma,
                        List<Arma> listaDeArmasParaLargar) {
        super(nome, pontosDeVida, forca, xpConcedido, arma, listaDeArmasParaLargar);
        this.pontosDeVidaMaximo = pontosDeVidaMaximo;
        this.refletido = refletido;
    }

    // Getter
    public int getPontosDeVidaMaximo() { return pontosDeVidaMaximo; }
    public boolean isRefletido() { return refletido; }

    // Setter
    public void setRefletido(boolean refletido) {
        this.refletido = refletido;
    }
    public void setPontosDeVidaMax(int novaVidaMax) {
        this.pontosDeVidaMaximo = novaVidaMax;
    }

    @Override
    public void curar(int quantidade) {
        this.pontosDeVida += quantidade;
        if (this.pontosDeVida > pontosDeVidaMaximo) {
            this.pontosDeVida = pontosDeVidaMaximo;
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        int danoTotal;

        // Ataque com arma, se tiver
        danoTotal = arma.atacarComArma(this, alvo);
        
        // se houve ataque com arma
        if (danoTotal != this.forca) {
            alvo.receberDano(danoTotal);
        }

        if (Math.random() < 0.5) { // 50% de chance de atacar
            danoTotal = this.forca;
            System.out.printf("⚡ %s desfere um ataque caótico contra %s causando %d de dano!\n\n", this.nome, alvo.getNome(), danoTotal);
            Main.tempoDeTexto();
            alvo.receberDano(danoTotal);
        } else { // 50% de chance de curar
            int cura = 15;
            System.out.printf("✨ %s entra em paradoxo e cura %s em %d pontos de vida!\n\n", this.nome, alvo.getNome(), cura);
            Main.tempoDeTexto();
            alvo.curar(cura);
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.3) { // 30% de chance
            System.out.printf("🪞 %s ativa o Espelho Temporal!\n", this.nome);
            Main.tempoDeTexto();
            System.out.printf("[O próximo ataque de %s será refletido contra ela mesma]\n\n", alvo.getNome());
            Main.tempoDeTexto();
            this.refletido = true;
        }
    }
}