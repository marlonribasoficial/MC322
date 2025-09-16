package Heroi;

import Armas.Arma;
import Personagem.Personagem;

public abstract class Heroi extends Personagem {
    private int nivelAtual;
    private int exp;
    private int expProximoNivel;
    private double sorte; // 0.0 a 1.0

    public Heroi(String nome, int pontosDeVida, int forca,
                 int nivelAtual, int exp, Arma arma,
                 int expProximoNivel, double sorte) {
        super(nome, pontosDeVida, forca, arma);
        this.nivelAtual = nivelAtual;
        this.exp = exp;
        this.expProximoNivel = expProximoNivel;
        this.sorte = sorte;
    }

    // Getters
    public int getNivel() { return nivelAtual; }
    public int getExp() { return exp; }
    public int getExpProxNivel() { return expProximoNivel; }
    public double getSorte() { return sorte; }

    // Setters
    public void setNivel(int nivel) {
        this.nivelAtual = nivel;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public void setExpProximoNivel(int expProxNivel) {
        this.expProximoNivel = expProxNivel;
    }
    public void setSorte(double sorte) {
        this.sorte = sorte;
    }

    // Troca de arma respeitando nível mínimo
    public void equiparArma(Arma novaArma) {
        if (nivelAtual >= novaArma.getMinNivel()) {
            if (getArma() == null || getArma().getDano() < novaArma.getDano()) {
                setArma(novaArma);
                System.out.printf("🔄 %s equipou %s!\n", getNome(), novaArma.getNome());
                novaArma.exibirDescricao();
            }
        } else {
            System.out.printf("❌ %s não tem nível suficiente para usar %s!\n",
                               getNome(), novaArma.getNome());
        }
    }

    public abstract void usarHabilidadeEspecial(Personagem alvo);
}