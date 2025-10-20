package Interfaces;

import Motor.Dificuldade;
import java.util.List;

/**
 * Responsável por gerar um conjunto de fases para o jogo.
 */
public interface GeradorDeFases {

    /**
     * Gera uma lista de fases com base na quantidade e dificuldade escolhida.
     *
     * @param quantidadeDeFases Quantidade de fases que devem ser criadas.
     * @param dificuldade Nível de dificuldade aplicado às fases.
     * @return Lista de fases geradas.
     */
    List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade);
}