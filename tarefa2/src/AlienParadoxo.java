import java.util.List;

/* 
Alien Paradoxo:
- Atributos: Nome, Vida, Força, XP concedida, Estado de reflexo
- Ataques: ataque caótico OU paradoxo que cura
- Habilidade Especial: ativa espelho temporal (reflete próximo ataque)
*/
public class AlienParadoxo extends Monstro {
    private boolean refletido;

    public AlienParadoxo(String nome,
                        int pontosDeVida,
                        int forca,
                        int xpConcedido,
                        boolean refletido,
                        Arma arma,
                        List<Arma> listaDeArmasParaLargar) {
        super(nome, pontosDeVida, forca, xpConcedido, arma, listaDeArmasParaLargar);
        this.refletido = refletido;
    }

    @Override
    public void atacar(Personagem alvo) {
        if (Math.random() < 0.5) { // 50% de chance de atacar
            System.out.printf("⚡ %s desfere um ataque caótico contra %s causando %d de dano!\n\n", this.nome, alvo.getNome(), this.forca);
            Main.tempoDeTexto();
            alvo.receberDano(forca);
        } else { // 50% de chance de curar o inimigo
            int cura = 15;
            System.out.printf("✨ %s entra em paradoxo e cura %s em %d pontos de vida!\n\n", this.nome, alvo.getNome(), cura);
            Main.tempoDeTexto();
            alvo.pontosDeVida += cura;
            if (alvo.pontosDeVida > 120) alvo.pontosDeVida = 120; // limite de vida genérico
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

    public boolean isRefletido() {
        return refletido;
    }

    public void setRefletido(boolean refletido) {
        this.refletido = refletido;
    }
}