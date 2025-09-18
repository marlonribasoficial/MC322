package AcoesMonstro;

import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;
import Personagem.Personagem;
import Utilidades.Utilidades;

/**
 * Alien4D atravessa dimensões causando dano direto.
 */
public class AtaqueDimensional implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (!(usuario instanceof Personagem) || !(alvo instanceof Personagem)) return;

        Personagem alien = (Personagem) usuario;
        Personagem inimigo = (Personagem) alvo;

        int dano = alien.getForca();
        System.out.printf("🌀 %s atravessa dimensões e atinge %s causando %d de dano!\n\n",
                alien.getNome(), inimigo.getNome(), dano);

        inimigo.receberDano(dano);
        Utilidades.tempoDeTexto();
    }
}