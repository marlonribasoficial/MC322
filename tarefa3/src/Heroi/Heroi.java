package Heroi;

import Armas.Arma;
import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;
import Personagem.Personagem;
import java.util.List;

public abstract class Heroi extends Personagem {
    private int nivelAtual;
    private int exp;
    private int expProximoNivel;
    private double sorte;
    protected List<AcaoDeCombate> acoes;

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
    public void setNivel(int nivel) { this.nivelAtual = nivel; }
    public void setExp(int exp) { this.exp = exp; }
    public void setExpProximoNivel(int expProxNivel) { this.expProximoNivel = expProxNivel; }
    public void setSorte(double sorte) { this.sorte = sorte; }

    // Troca de arma respeitando nivel minimo
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

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        // Escolha automática de uma ação (pode ser aleatorio)
        if (acoes == null || acoes.isEmpty()) return null;
        return acoes.get((int)(Math.random() * acoes.size()));
    }
}