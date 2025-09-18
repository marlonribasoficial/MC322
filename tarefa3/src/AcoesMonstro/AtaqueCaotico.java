package AcoesMonstro;

import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;
import Personagem.Personagem;
import Utilidades.Utilidades;

/**
 * Alien Paradoxo desfere um ataque caótico.
 */
public class AtaqueCaotico implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (!(usuario instanceof Personagem) || !(alvo instanceof Personagem)) return;

        Personagem alien = (Personagem) usuario;
        Personagem inimigo = (Personagem) alvo;

        int dano = alien.getForca();
        System.out.printf("⚡ %s desfere um ataque caótico contra %s causando %d de dano!\n\n",
                alien.getNome(), inimigo.getNome(), dano);

        inimigo.receberDano(dano);
        Utilidades.tempoDeTexto();
    }
}