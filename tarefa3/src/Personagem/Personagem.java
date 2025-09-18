package Personagem;

import Armas.Arma;
import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;

public abstract class Personagem implements Combatente {
    private final String nome;
    private int pontosDeVida;
    private int forca;
    private Arma arma;

    private boolean contaminado = false;
    private boolean refletido = false;
    private boolean aprisionado = false;

    public Personagem(String nome, int pontosDeVida, int forca, Arma arma) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
    }

    // Getters
    @Override
    public String getNome() { return nome; }
    public int getVida() { return pontosDeVida; }
    public int getForca() { return forca; }
    public Arma getArma() { return arma; }

    public boolean isContaminado() { return contaminado; }
    public boolean isRefletido() { return refletido; }
    public boolean isAprisionado() { return aprisionado; }

    // Setters
    public void setVida(int vida) { this.pontosDeVida = Math.max(0, vida); }
    public void setForca(int forca) { this.forca = forca; }
    public void setArma(Arma arma) { this.arma = arma; }

    public void setContaminado(boolean contaminado) { this.contaminado = contaminado; }
    public void setRefletido(boolean refletido) { this.refletido = refletido; }
    public void setAprisionado(boolean aprisionado) { this.aprisionado = aprisionado; }

    // Métodos comuns
    @Override
    public boolean estaVivo() { return pontosDeVida > 0; }

    @Override
    public void receberDano(int dano) {
        this.pontosDeVida -= dano;
        if (this.pontosDeVida < 0) this.pontosDeVida = 0;
    }

    // Métodos abstratos
    @Override
    public abstract AcaoDeCombate escolherAcao(Combatente alvo);
    @Override
    public abstract void receberCura(int cura);
    public abstract void exibirStatus();
}