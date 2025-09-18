package Monstros;

import Armas.Arma;
import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;
import Personagem.Personagem;
import Utilidades.Utilidades;
import java.util.ArrayList;
import java.util.List;

public abstract class Monstro extends Personagem {
    private final int xpConcedido;
    protected List<AcaoDeCombate> acoes = new ArrayList<>();
    private List<Arma> listaDeArmasParaLargar;

    public Monstro(String nome,
                   int pontosDeVida,
                   int forca,
                   int xpConcedido,
                   Arma arma,
                   List<Arma> listaDeArmasParaLargar) {
        super(nome, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.listaDeArmasParaLargar = listaDeArmasParaLargar;
    }

    // Getters
    public int getXpConcedido() { return xpConcedido; }
    public List<Arma> getListaDeArmasParaLargar() { return listaDeArmasParaLargar; }
    public abstract int getPontosDeVidaMaximo();

    @Override
    public void exibirStatus() {
        String linha = "========================================";
        System.out.println("\n" + linha);
        System.out.printf("| 👾 Nome: %-32s\n", getNome());
        System.out.printf("| 💖 Vida: %-11s %3d\n",
                Utilidades.gerarBarra(getVida(), this.getPontosDeVidaMaximo(), 10), getVida());
        System.out.printf("| ⚔️ Força: %-28d\n", getForca());
        System.out.printf("| ⭐ XP concedida: %-20d\n", getXpConcedido());
        System.out.println(linha + "\n");
        Utilidades.tempoDeTexto();
    }

    public Arma largaArma() {
        if (listaDeArmasParaLargar.isEmpty()) return null;
        int index = (int)(Math.random() * listaDeArmasParaLargar.size());
        return listaDeArmasParaLargar.get(index);
    }

    public abstract void usarHabilidadeEspecial(Personagem alvo);

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        if (acoes == null || acoes.isEmpty()) return null;
        return acoes.get((int)(Math.random() * acoes.size()));
    }
}