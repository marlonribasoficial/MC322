package Combate;

import Entidades.Personagem;
import Interfaces.*;
import Util.Utilidades;

public class AtaqueFisico implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        Personagem pUsuario = (Personagem) usuario;
        int dano = pUsuario.getForca();
        System.out.printf("🚀 %s ataca %s com um golpe físico, causando %d de dano!\n\n", usuario.getNome(), alvo.getNome(), dano);
        Utilidades.tempoDeTexto();
        alvo.receberDano(dano);
    }
}