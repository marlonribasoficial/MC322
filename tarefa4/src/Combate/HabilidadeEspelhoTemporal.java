package Combate;

import Entidades.Personagem;
import Interfaces.*;
import Util.Utilidades;
import java.util.Random;

public class HabilidadeEspelhoTemporal implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (new Random().nextDouble() < 0.3) {
            Personagem pAlvo = (Personagem) alvo;
            System.out.printf("🪞 %s ativa o Espelho Temporal!\n", usuario.getNome());
            Utilidades.tempoDeTexto();
            System.out.printf("[O próximo ataque de %s será refletido contra ele mesmo!]\n\n", pAlvo.getNome());
            pAlvo.setRefletido(true);
            Utilidades.tempoDeTexto();
        }
    }
}