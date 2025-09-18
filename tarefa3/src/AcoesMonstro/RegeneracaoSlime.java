package AcoesMonstro;

import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;
import Personagem.Personagem;
import Utilidades.Utilidades;

/**
 * Alien Slime se fragmenta e regenera parte da vida.
 */
public class RegeneracaoSlime implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (!(usuario instanceof Personagem)) return;

        Personagem slime = (Personagem) usuario;
        if (Math.random() < 0.4) {
            int cura = slime.getVida() / 4;
            slime.receberCura(cura);
            System.out.printf("💀 %s se fragmenta e regenera %d de vida!\n\n",
                    slime.getNome(), cura);
        }
        Utilidades.tempoDeTexto();
    }
}