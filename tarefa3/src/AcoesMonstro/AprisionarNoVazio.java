package AcoesMonstro;

import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;
import Personagem.Personagem;
import Utilidades.Utilidades;

/**
 * Alien4D aprisiona o alvo no vácuo dimensional.
 */
public class AprisionarNoVazio implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (!(alvo instanceof Personagem)) return;

        Personagem inimigo = (Personagem) alvo;
        if (Math.random() < 0.30) {
            System.out.printf("🌀 %s foi aprisionado no vácuo dimensional e perderá o próximo turno!\n\n",
                    inimigo.getNome());
            inimigo.setAprisionado(true);
        }
        Utilidades.tempoDeTexto();
    }
}