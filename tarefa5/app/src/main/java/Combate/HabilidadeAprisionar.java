package Combate;

import Entidades.Personagem;
import Interfaces.*;
import Util.Utilidades;
import java.util.Random;

/**
 * Habilidade que aprisiona o alvo, impedindo-o de agir no próximo turno.
 * Chance de 30% de sucesso.
 */
public class HabilidadeAprisionar implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (alvo instanceof Personagem && new Random().nextDouble() < 0.3) {
            Personagem pAlvo = (Personagem) alvo;
            System.out.printf("🌀 %s aprisiona %s no vácuo dimensional!\n", usuario.getNome(), pAlvo.getNome());
            Utilidades.tempoDeTexto();
            System.out.printf("[%s perde o próximo turno]\n\n", pAlvo.getNome());
            pAlvo.setAprisionado(true);
            Utilidades.tempoDeTexto();
        }
    }
}