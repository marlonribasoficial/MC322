package Combate;

import Entidades.Monstros.Monstro;
import Interfaces.*;
import Util.Utilidades;

public class HabilidadeFragmentar implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        Monstro monstro = (Monstro) usuario;
        int cura = monstro.getPontosDeVida() / 4;
        System.out.printf("💀 %s se fragmenta em duas massas e recupera %d de vida!\n\n", monstro.getNome(), cura);
        monstro.receberCura(cura);
        Utilidades.tempoDeTexto();
    }
}