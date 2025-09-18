package Monstros;

import Acoes.AtaqueFisico;
import Armas.Arma;
import Personagem.Personagem;
import Utilidades.Utilidades;
import java.util.List;

public class Alien4D extends Monstro {
    private int pontosDeVidaMaximo;

    public Alien4D(String nome,
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
            System.out.printf("🌀 %s aprisiona %s no vácuo dimensional! [%s perde o próximo turno]\n\n",
                    getNome(), alvo.getNome(), alvo.getNome());
            Utilidades.tempoDeTexto();
            alvo.setAprisionado(true);
        }
    }
}