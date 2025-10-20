package Interfaces;

import Entidades.Heroi.Heroi;
import Motor.TipoCenario;

/**
 * Representa uma fase do jogo.
 */
public interface Fase {

    /**
     * Inicia a fase para o herói.
     *
     * @param heroi O herói que participará da fase.
     */
    void iniciar(Heroi heroi);

    /**
     * @return {@code true} se a fase já foi concluída.
     */
    boolean isConcluida();

    /**
     * @return O tipo de cenário da fase.
     */
    TipoCenario getTipoDeCenario();
}