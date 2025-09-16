package Personagem;

import Armas.Arma;

public abstract class Personagem {
    private final String nome;
    private int pontosDeVida;
    private int forca;
    private Arma arma;
    private boolean contaminado = false;
    private boolean refletido = false;
    private boolean aprisionado = false;

    public Personagem(String nome,
                    int pontosDeVida,
                    int forca,
                    Arma arma) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
    }

    // Getters
    public String getNome() { return nome; }
    public int getVida() { return pontosDeVida; }
    public int getForca() { return forca; }
    public Arma getArma() { return arma; }
    public boolean getContaminado() { return contaminado; }
    public boolean getRefletido() { return refletido; }
    public boolean getAprisionado() { return aprisionado; }

    // Setters
    public void setVida(int vida) {
        this.pontosDeVida = vida;
    }
    public void setForca(int forca) {
        this.forca = forca;
    }
    public void setArma(Arma arma) {
        this.arma = arma;
    }
    public void setContaminado(boolean contaminado) {
        this.contaminado = contaminado;
    }
    public void setRefletido(boolean refletido) {
        this.refletido = refletido;
    }
    public void setAprisionado(boolean aprisionado) {
        this.aprisionado = aprisionado;
    }

    // Reduz os pontos de vida com base no dano recebido
    public void receberDano(int dano) {
        this.pontosDeVida -= dano;
        if (this.pontosDeVida < 0) this.pontosDeVida = 0;
    }

    // Cura a vida
    public abstract void receberCura(int cura);

    // Imprime as informações do personagem
    public abstract void exibirStatus();

    // Método abstrato para ataque
    public abstract void atacar(Personagem alvo);
}