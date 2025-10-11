package Combate;

import Entidades.Personagem;
import Interfaces.*;
import Util.Utilidades;

/**
 * Representa um ataque místico em que o usuário atravessa dimensões para golpear o inimigo.
 * Causa dano equivalente à força do personagem.
 */
public class AtaqueDimensional implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        Personagem pUsuario = (Personagem) usuario;
        int dano = pUsuario.getForca();
        System.out.printf("🌀 %s atravessa dimensões e ataca %s causando %d de dano!\n\n",
                pUsuario.getNome(), alvo.getNome(), dano);
        alvo.receberDano(dano);
        Utilidades.tempoDeTexto();
    }
}