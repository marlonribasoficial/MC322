package Interfaces;

import Motor.Dificuldade;
import java.util.List;

public interface GeradorDeFases {
    List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade);
}