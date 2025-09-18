package Monstros;

import Acoes.AtaqueFisico;
import Armas.Arma;
import Personagem.Personagem;
import Utilidades.Utilidades;
import java.util.List;

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

        // Ações
        this.acoes.add(new AtaqueFisico());
        this.acoes.add(new AtaqueFisico());
        this.acoes.add(new AtaqueFisico());
        this.acoes.add((usuario, alvo) -> usarHabilidadeEspecial((Personagem) alvo));
    }

    @Override
    public int getPontosDeVidaMaximo() { return pontosDeVidaMaximo; }

    @Override
    public void receberCura(int cura) {
        int vida = this.getVida() + cura;
        setVida(Math.min(vida, pontosDeVidaMaximo));
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.3) {
            System.out.printf("🪞 %s ativa o Espelho Temporal!\n", getNome());
            Utilidades.tempoDeTexto();
            alvo.setRefletido(true);
        } else {
            // 50% cura, 50% dano
            if (Math.random() < 0.5) {
                int dano = getForca();
                System.out.printf("⚡ %s desfere um ataque caótico contra %s causando %d de dano!\n\n",
                        getNome(), alvo.getNome(), dano);
                alvo.receberDano(dano);
            } else {
                int cura = 15;
                System.out.printf("✨ %s entra em paradoxo e se cura em %d pontos!\n\n",
                        getNome(), cura);
                this.receberCura(cura);
            }
        }
    }
}