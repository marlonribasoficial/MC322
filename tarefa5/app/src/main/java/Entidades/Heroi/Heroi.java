package Entidades.Heroi;

import Entidades.Personagem;
import Interfaces.AcaoDeCombate;
import Itens.Arma;
import Util.Utilidades;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstrata que representa um herói do jogo.
 * Controla experiência, nível, sorte e lista de ações.
 */
public abstract class Heroi extends Personagem {
    private int nivel;
    private int exp;
    private int expProximoNivel;
    private double sorte;
    private List<AcaoDeCombate> acoes;

    private static final int[] EXP_POR_NIVEL = {0, 60, 120, 200, 280, 360};

    /**
     * Construtor que inicializa atributos principais do herói.
     */
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
    
    /**
     * Adiciona experiência ao herói e verifica se ele sobe de nível.
     *
     * @param xpGanho quantidade de experiência obtida
     */
    public void ganharExperiencia(int xpGanho) {
        this.exp += xpGanho;
        verificarSubidaDeNivel();
    }

    /**
     * Verifica e executa a lógica de subida de nível
     * quando o herói acumula experiência suficiente.
     */
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

    /**
     * Atualiza o XP necessário para o próximo nível.
     */
    private void atualizarExpProximoNivel() {
        if (nivel < EXP_POR_NIVEL.length - 1) {
            this.expProximoNivel = EXP_POR_NIVEL[this.nivel + 1];
        } else {
            this.expProximoNivel = Integer.MAX_VALUE;
        }
    }

    /**
     * Exibe no console uma mensagem de "level up".
     */
    private void printLevelUp(int nivelAntigo, int nivelNovo) {
        String linha = "==================================================";
        System.out.println("\n" + linha);
        System.out.println("           ✨✨✨ LEVEL UP! ✨✨✨");
        System.out.println("\n" + getNome() + " subiu do nível " + nivelAntigo + " para o nível " + nivelNovo + "!");
        System.out.println(linha + "\n");
        Utilidades.tempoDeTexto();
    }

    /**
     * Método abstrato que deve ser implementado
     * para definir como o herói evolui ao subir de nível.
     */
    protected abstract void subirDeNivel();

    /**
     * Permite ao herói equipar uma nova arma,
     * respeitando restrições de nível e poder da arma atual.
     *
     * @param novaArma arma encontrada ou adquirida
     */
    public void equiparArma(Arma novaArma) {

        // Painel visual que apresenta a arma encontrada e arma atual (se houver)
        Utilidades.mostrarPainel(this, novaArma); 

        if (nivel >= novaArma.getMinNivel()) {
            if (this.getArma() == null || this.getArma().getDano() < novaArma.getDano()) {
                this.setArma(novaArma);
                System.out.printf("\n🔄 %s equipou %s!\n\n", this.getNome(), novaArma.getNome());

            } else if (this.getArma().getDano() == novaArma.getDano()) {
                System.out.printf("\n🪐 %s analisa %s, mas percebe que seu poder é igual ao da arma em uso. Continua com a atual.\n\n", this.getNome(), novaArma.getNome());
                
            } else {
                 System.out.printf("\n⚖️ %s decide não equipar %s pois sua arma atual é mais forte.\n\n", this.getNome(), novaArma.getNome());
            }
            
        } else {
            System.out.printf("\n❌ %s não tem nível suficiente para usar %s!\n\n",
                               this.getNome(), novaArma.getNome());
        }
    }
}