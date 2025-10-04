package Combate;

import Entidades.Heroi.Astronauta;
import Interfaces.*;
import Util.Utilidades;

public class HabilidadeDefesaTraje implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        Astronauta astronauta = (Astronauta) usuario;
        if (astronauta.getTrajeEspacial() >= 30) {
            int cura = 40;
            System.out.printf("🛡️ %s ativa o modo de defesa máxima do traje, recuperando %d de vida!\n\n", astronauta.getNome(), cura);
            astronauta.receberCura(cura);
            astronauta.setTrajeEspacial(astronauta.getTrajeEspacial() - 30);
            Utilidades.tempoDeTexto();
        } else {
            System.out.printf("⚠️ %s não tem energia suficiente para usar a habilidade especial do traje!\n\n", astronauta.getNome());
            Utilidades.tempoDeTexto();
        }
    }
}