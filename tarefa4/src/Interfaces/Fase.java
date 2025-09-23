package Interfaces;

import Entidades.Heroi.Heroi;
import Motor.TipoCenario;

public interface Fase {
    void iniciar(Heroi heroi);
    boolean isConcluida();
    TipoCenario getTipoDeCenario();
}