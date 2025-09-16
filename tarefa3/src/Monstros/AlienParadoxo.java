package Monstros;

import Armas.Arma;
import Personagem.Personagem;
import Utilidades.Utilidades;
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
    public void receberCura(int cura) {
        int vida = this.getVida() + cura;
        if (vida > pontosDeVidaMaximo) {
            setVida(pontosDeVidaMaximo);
        } else {
            setVida(vida);
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        int danoTotal;

        // Ataque com arma, se tiver
        danoTotal = getArma().atacarComArma(this, alvo);
        
        // Se houve ataque com arma
        if (danoTotal != getForca()) {
            alvo.receberDano(danoTotal);
        }

        if (Math.random() < 0.5) { // 50% de chance de atacar
            danoTotal = getForca();
            System.out.printf("⚡ %s desfere um ataque caótico contra %s causando %d de dano!\n\n", getNome(), alvo.getNome(), danoTotal);
            Utilidades.tempoDeTexto();
            alvo.receberDano(danoTotal);
        } else { // 50% de chance de curar
            int cura = 15;
            System.out.printf("✨ %s entra em paradoxo e cura %s em %d pontos de vida!\n\n", getNome(), alvo.getNome(), cura);
            Utilidades.tempoDeTexto();
            alvo.receberCura(cura);
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.30) { // 30% de chance
            System.out.printf("🪞 %s ativa o Espelho Temporal!\n", getNome());
            Utilidades.tempoDeTexto();
            System.out.printf("[O próximo ataque de %s será refletido contra ela mesma]\n\n", alvo.getNome());
            Utilidades.tempoDeTexto();
            alvo.setRefletido(true);
        }
    }
}