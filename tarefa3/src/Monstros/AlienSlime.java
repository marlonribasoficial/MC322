package Monstros;

import Acoes.AtaqueFisico;
import Armas.Arma;
import Personagem.Personagem;
import Utilidades.Utilidades;
import java.util.List;

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

        // Ações do Slime
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
        if (Math.random() < 0.4) { // 40% chance
            System.out.printf("💀 %s se fragmenta e recupera 25%% da vida!\n\n", getNome());
            Utilidades.tempoDeTexto();
            int cura = getPontosDeVidaMaximo() / 4;
            setVida(Math.min(getVida() + cura, pontosDeVidaMaximo));
        }
    }
}