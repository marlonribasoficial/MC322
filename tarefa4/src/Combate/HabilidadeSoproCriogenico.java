package Combate;

import Entidades.Heroi.*;
import Interfaces.*;
import Util.Utilidades;

public class HabilidadeSoproCriogenico implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        Astronauta astronauta = (Astronauta) usuario;
        if (astronauta.getOxigenio() >= 40) {
            int dano = astronauta.getForca() * 2;
            System.out.printf("❄️ %s usa o sopro criogênico em %s causando %d de dano!\n\n",
                    astronauta.getNome(), alvo.getNome(), dano);
            alvo.receberDano(dano);
            astronauta.setOxigenio(astronauta.getOxigenio() - 40);
            Utilidades.tempoDeTexto();
        } else {
            System.out.printf("💨 %s tenta usar o sopro criogênico, mas não tem oxigênio suficiente!\n\n", astronauta.getNome());
            new AtaqueFisico().executar(usuario, alvo); // Realiza um ataque básico no lugar
        }
    }
}