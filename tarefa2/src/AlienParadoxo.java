import java.util.List;

/* 
Alien Paradoxo:
- Atributos: Nome, Vida, Força, XP concedida, Estado de reflexo
- Ataques: ataque caótico OU paradoxo que cura
- Habilidade Especial: ativa espelho temporal (reflete próximo ataque)
*/

public class AlienParadoxo extends Monstro {
    private int pontosDeVidaMaximo;

    public AlienParadoxo(String nome,
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
    public void setPontosDeVidaMaximo(int novaVidaMax) {
        this.pontosDeVidaMaximo = novaVidaMax;
    }

    @Override
    public void atacar(Personagem alvo) {
        int danoTotal;

        // Ataque com arma, se tiver
        danoTotal = arma.atacarComArma(this, alvo);
        
        // Se houve ataque com arma
        if (danoTotal != this.forca) {
            alvo.receberDano(danoTotal);
        }

        if (Math.random() < 0.5) { // 50% de chance de atacar
            danoTotal = this.forca;
            System.out.printf("⚡ %s desfere um ataque caótico contra %s causando %d de dano!\n\n", this.nome, alvo.getNome(), danoTotal);
            Utilidades.tempoDeTexto();
            alvo.receberDano(danoTotal);
        } else { // 50% de chance de curar
            int cura = 15;
            System.out.printf("✨ %s entra em paradoxo e cura %s em %d pontos de vida!\n\n", this.nome, alvo.getNome(), cura);
            Utilidades.tempoDeTexto();
            alvo.curar(cura);
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.30) { // 30% de chance
            System.out.printf("🪞 %s ativa o Espelho Temporal!\n", this.nome);
            Utilidades.tempoDeTexto();
            System.out.printf("[O próximo ataque de %s será refletido contra ela mesma]\n\n", alvo.getNome());
            Utilidades.tempoDeTexto();
            alvo.setRefletido(true);
        }
    }
}