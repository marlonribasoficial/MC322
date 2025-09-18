package AcoesMonstro;

import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;
import Personagem.Personagem;
import Utilidades.Utilidades;

/**
 * Alien Paradoxo entra em paradoxo e cura a si mesmo.
 */
public class CurarParadoxo implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (!(usuario instanceof Personagem)) return;

        Personagem alien = (Personagem) usuario;
        int cura = 15;

        System.out.printf("✨ %s entra em paradoxo e se cura em %d pontos de vida!\n\n",
                alien.getNome(), cura);

        alien.receberCura(cura);
        Utilidades.tempoDeTexto();
    }
}
