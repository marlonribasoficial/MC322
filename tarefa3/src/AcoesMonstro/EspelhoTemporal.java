package AcoesMonstro;

import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;
import Personagem.Personagem;
import Utilidades.Utilidades;

/**
 * Alien Paradoxo ativa o espelho temporal (reflete próximo ataque).
 */
public class EspelhoTemporal implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (!(alvo instanceof Personagem)) return;

        Personagem inimigo = (Personagem) alvo;
        if (Math.random() < 0.30) {
            System.out.printf("🪞 O próximo ataque de %s será refletido!\n\n", inimigo.getNome());
            inimigo.setRefletido(true);
        }
        Utilidades.tempoDeTexto();
    }
}
