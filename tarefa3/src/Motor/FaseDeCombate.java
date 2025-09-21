package Motor;

import Entidades.Heroi.Heroi;
import Entidades.Monstros.Monstro;
import Interfaces.Fase;
import java.util.List;

public class FaseDeCombate implements Fase {
    private int nivel;
    private TipoCenario cenario;
    private List<Monstro> monstros;

    public FaseDeCombate(int nivel, TipoCenario cenario, List<Monstro> monstros) {
        this.nivel = nivel;
        this.cenario = cenario;
        this.monstros = monstros;
    }
    
    // Getters
    public List<Monstro> getMonstros() { return monstros; }
    public int getNivel() { return nivel; }

    @Override
    public void iniciar(Heroi heroi) {
        Narrador.imprimirTituloFase(this);
        cenario.aplicarEfeitos(heroi);
    }

    @Override
    public boolean isConcluida() {
        for (Monstro monstro : monstros) {
            if (monstro.estaVivo()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public TipoCenario getTipoDeCenario() {
        return cenario;
    }
}