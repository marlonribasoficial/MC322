package Acoes;

import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;
import Personagem.Personagem;
import Utilidades.Utilidades;

public class SoproCriogenico implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (!(usuario instanceof Heroi.Astronauta) || !(alvo instanceof Personagem)) return;

        Heroi.Astronauta astronauta = (Heroi.Astronauta) usuario;
        Personagem inimigo = (Personagem) alvo;

        if (astronauta.getOxigenio() >= 40) {
            int dano = astronauta.getForca() * 3;
            System.out.printf("❄️ %s usa o Sopro Criogênico em %s causando %d de dano!\n\n",
                    astronauta.getNome(), inimigo.getNome(), dano);
            inimigo.receberDano(dano);
            astronauta.setOxigenio(astronauta.getOxigenio() - 40);
        } else {
            System.out.printf("⚠️ %s não tem oxigênio suficiente para usar o Sopro Criogênico!\n\n",
                    astronauta.getNome());
        }

        Utilidades.tempoDeTexto();
    }
}