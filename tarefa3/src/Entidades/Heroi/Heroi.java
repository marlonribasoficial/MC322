package Entidades.Heroi;

import Entidades.Personagem;
import Interfaces.AcaoDeCombate;
import Itens.Arma;
import Util.Utilidades;
import java.util.ArrayList;
import java.util.List;

public abstract class Heroi extends Personagem {
    private int nivel;
    private int exp;
    private int expProximoNivel;
    private double sorte;
    private List<AcaoDeCombate> acoes;

    private static final int[] EXP_POR_NIVEL = {0, 60, 120, 200, 280, 360};

    public Heroi(String nome,
                int pontosDeVida,
                int forca,
                int nivel,
                int exp,
                Arma arma,
                double sorte) {
        super(nome, pontosDeVida, forca, arma);
        this.nivel = nivel;
        this.exp = exp;
        this.sorte = sorte;
        this.acoes = new ArrayList<>();
        atualizarExpProximoNivel();
    }

    // Getters
    public int getNivel() { return nivel; }
    public int getExp() { return exp; }
    public double getSorte() { return sorte; }
    public List<AcaoDeCombate> getAcoes() { return acoes; }

    // Setters
    protected void setNivel(int nivel) { this.nivel = nivel; }
    protected void setExp(int exp) { this.exp = exp; }
    
    // Lógica da Experiência
    public void ganharExperiencia(int xpGanho) {
        this.exp += xpGanho;
        System.out.printf("⭐ %s ganhou %d pontos de experiência!\n", getNome(), xpGanho);
        Utilidades.tempoDeTexto();
        verificarSubidaDeNivel();
    }

    private void verificarSubidaDeNivel() {
        // Continua checando até que o herói não tenha mais XP para subir de nível
        while (nivel < EXP_POR_NIVEL.length - 1 && this.exp >= this.expProximoNivel) {
            int nivelAntigo = this.nivel;
            this.nivel++;
            printLevelUp(nivelAntigo, this.nivel);
            subirDeNivel();
            atualizarExpProximoNivel();
        }
    }

    private void atualizarExpProximoNivel() {
        if (nivel < EXP_POR_NIVEL.length - 1) {
            this.expProximoNivel = EXP_POR_NIVEL[this.nivel + 1];
        } else {
            this.expProximoNivel = Integer.MAX_VALUE;
        }
    }

    private void printLevelUp(int nivelAntigo, int nivelNovo) {
        String linha = "==================================================";
        System.out.println("\n" + linha);
        System.out.println("           ✨✨✨ LEVEL UP! ✨✨✨");
        System.out.println("\n" + getNome() + " subiu do nível " + nivelAntigo + " para o nível " + nivelNovo + "!");
        System.out.println(linha + "\n");
        Utilidades.tempoDeTexto();
    }

    protected abstract void subirDeNivel();

    public void equiparArma(Arma novaArma) {
        if (nivel >= novaArma.getMinNivel()) {
            if (this.getArma() == null || this.getArma().getDano() < novaArma.getDano()) {
                this.setArma(novaArma);
                System.out.printf("🔄 %s equipou %s!\n", this.getNome(), novaArma.getNome());
                novaArma.exibirDescricao();
            } else {
                 System.out.printf("⚖️ %s decide não equipar %s pois sua arma atual é mais forte.\n", this.getNome(), novaArma.getNome());
            }
        } else {
            System.out.printf("❌ %s não tem nível suficiente para usar %s!\n",
                               this.getNome(), novaArma.getNome());
        }
    }
}