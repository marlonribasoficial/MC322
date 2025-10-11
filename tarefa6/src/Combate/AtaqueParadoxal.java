package Combate;

import Entidades.Personagem;
import Interfaces.*;
import Util.Utilidades;
import java.util.Random;

/**
 * Representa um ataque imprevisível causado por um paradoxo temporal.
 * Possui 50% de chance de causar dano ao inimigo e 50% de chance de curá-lo.
 */
public class AtaqueParadoxal implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        Personagem pUsuario = (Personagem) usuario;

        if (new Random().nextDouble() < 0.5) {
            int dano = pUsuario.getForca();
            System.out.printf("⚡ %s desfere um ataque caótico contra %s causando %d de dano!\n\n", pUsuario.getNome(), alvo.getNome(), dano);
            alvo.receberDano(dano);
        } else {
            int cura = 15;
            System.out.printf("✨ %s entra em paradoxo e cura %s em %d pontos de vida!\n\n", pUsuario.getNome(), alvo.getNome(), cura);
            alvo.receberCura(cura);
        }
        Utilidades.tempoDeTexto();
    }
}