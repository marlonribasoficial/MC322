package Entidades.Monstros;

import Entidades.Personagem;
import Interfaces.*;
import Itens.Arma;
import Util.Utilidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Monstro extends Personagem implements Lootavel {
    private int xpConcedido;
    private List<Item> tabelaDeLoot;
    private List<AcaoDeCombate> acoes;
    private int pontosDeVidaMaximo;

    public Monstro(String nome,
                int pontosDeVida,
                int forca,
                int xpConcedido,
                int pontosDeVidaMaximo,
                Arma arma,
                List<Item> tabelaDeLoot) {
        super(nome, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.pontosDeVidaMaximo = pontosDeVidaMaximo;
        this.tabelaDeLoot = tabelaDeLoot;
        this.acoes = new ArrayList<>();
    }

    // Getters
    public int getXpConcedido() { return xpConcedido; }
    protected List<AcaoDeCombate> getAcoes() { return acoes; }
    public int getVidaMax() { return pontosDeVidaMaximo; }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        Random random = new Random();
        int index = random.nextInt(acoes.size());
        return acoes.get(index);
    }

    @Override
    public Item droparLoot() {
        if (tabelaDeLoot == null || tabelaDeLoot.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(tabelaDeLoot.size());
        return tabelaDeLoot.get(index);
    }
    
    @Override
    public void receberCura(int cura) {
        super.receberCura(cura);
        if (getPontosDeVida() > pontosDeVidaMaximo) {
            setPontosDeVida(pontosDeVidaMaximo);
        }
    }

    @Override
    public void exibirStatus() {
        String linha = "========================================";
        System.out.println("\n" + linha);
        System.out.printf("| 👾 Nome: %-32s\n", this.getNome());
        System.out.printf("| 💖 Vida: %-18s %3d/%d\n", Utilidades.gerarBarra(this.getPontosDeVida(), this.pontosDeVidaMaximo, 10), this.getPontosDeVida(), this.pontosDeVidaMaximo);
        System.out.printf("| ⚔️ Força: %-28d\n", this.getForca());
        System.out.printf("| ⭐ XP: %-31d\n", this.xpConcedido);
        System.out.println(linha + "\n");
        Utilidades.tempoDeTexto();
    }
}