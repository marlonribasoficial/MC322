package Combate;

import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;
import Util.Utilidades;

/**
 * Representa um ataque físico direto, baseado apenas na força do personagem.
 */
public class AtaqueFisico implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        int dano = usuario.getForca();
        System.out.printf("🚀 %s ataca %s com um golpe físico, causando %d de dano!\n\n", usuario.getNome(), alvo.getNome(), dano);
        Utilidades.tempoDeTexto();
        alvo.receberDano(dano);
    }
}