package Combate;

import Entidades.Personagem;
import Interfaces.*;
import Util.Utilidades;
import java.util.Random;

public class AtaqueContaminante implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (usuario instanceof Personagem && alvo instanceof Personagem) {
            Personagem pUsuario = (Personagem) usuario;
            Personagem pAlvo = (Personagem) alvo;

            System.out.printf("🟢 %s arremessa uma gosma radioativa contra %s!\n\n", pUsuario.getNome(), pAlvo.getNome());
            pAlvo.receberDano(pUsuario.getForca());
            Utilidades.tempoDeTexto();

            if (new Random().nextDouble() < 0.4) {
                pAlvo.setContaminado(true);
                System.out.printf("☣️ %s foi contaminado!\n\n", pAlvo.getNome());
                Utilidades.tempoDeTexto();
            }
        }
    }
}