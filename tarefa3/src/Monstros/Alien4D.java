package Monstros;

import Armas.Arma;
import Personagem.Personagem;
import Utilidades.Utilidades;
import java.util.List;

/* 
Alien 4D:
- Atributos: Nome, Vida, Força, XP concedida, Estado de aprisionamento
- Ataques: atravessa dimensões causando dano
- Habilidade Especial: pode aprisionar o inimigo no vácuo (perde 1 turno)
*/

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

        // Se não houve ataque com arma
        if (danoTotal == getForca()) {
            System.out.printf("🌀 %s atravessa dimensões e ataca %s causando %d de dano!\n\n", 
                                getNome(), alvo.getNome(), danoTotal);
            Utilidades.tempoDeTexto();
        }

        alvo.receberDano(danoTotal);

        if (getVida() < 40) {
            usarHabilidadeEspecial(alvo);
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.30) { // 30% de chance
            System.out.printf("🌀 %s aprisiona %s no vácuo dimensional!\n", getNome(), alvo.getNome());
            Utilidades.tempoDeTexto();
            System.out.printf("[%s perde o próximo turno]\n\n", alvo.getNome());
            Utilidades.tempoDeTexto();
            alvo.setAprisionado(true);
        }
    }
}