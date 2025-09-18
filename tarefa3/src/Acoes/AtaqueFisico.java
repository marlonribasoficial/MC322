package Acoes;

import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;
import Personagem.Personagem;
import Utilidades.Utilidades;

public class AtaqueFisico implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (!(usuario instanceof Personagem) || !(alvo instanceof Personagem)) return;

        Personagem atacante = (Personagem) usuario;
        Personagem inimigo = (Personagem) alvo;

        int danoTotal;
        if (atacante.getArma() != null) {
            danoTotal = atacante.getArma().atacarComArma(atacante, inimigo);
            if (danoTotal == atacante.getForca()) {
                System.out.printf("🚀 %s ataca %s com força %d!\n\n", atacante.getNome(), inimigo.getNome(), danoTotal);
                Utilidades.tempoDeTexto();
            }
        } else {
            danoTotal = atacante.getForca();
            System.out.printf("🚀 %s ataca %s com força %d!\n\n", atacante.getNome(), inimigo.getNome(), danoTotal);
            Utilidades.tempoDeTexto();
        }

        inimigo.receberDano(danoTotal);
    }
}