package Interfaces;

import Heroi.Heroi;
import Utilidades.TipoCenario;

public interface Fase {
    void iniciar(Heroi heroi);
    boolean isConcluida();
    TipoCenario getTipoDeCenario();
}
