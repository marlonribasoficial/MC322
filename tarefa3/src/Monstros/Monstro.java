package Monstros;

import java.util.List;

import Armas.Arma;
import Personagem.Personagem;
import Utilidades.Utilidades;

public abstract class Monstro extends Personagem {
    protected int xpConcedido;
    protected List<Arma> listaDeArmasParaLargar;

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
    public void curar(int quantidade) {
        this.pontosDeVida += quantidade;
        if (this.pontosDeVida > getPontosDeVidaMaximo()) {
            this.pontosDeVida = getPontosDeVidaMaximo();
        }
    }

    @Override
    public void exibirStatus() {
        String linha = "========================================";
        System.out.println("\n" + linha);
        System.out.printf("| 👾 Nome: %-32s\n", this.nome);
        System.out.printf("| 💖 Pontos de Vida: %-11s %3d\n", Utilidades.gerarBarra(this.pontosDeVida, this.getPontosDeVidaMaximo(), 10), this.pontosDeVida);
        System.out.printf("| ⚔️ Força: %-28d\n", this.forca);
        System.out.printf("| ⭐ XP concedida: %-20d\n", this.xpConcedido);
        System.out.println(linha + "\n");
        Utilidades.tempoDeTexto();
    }

    // Agora retorna uma arma aleatória
    public Arma largaArma() {
        if (listaDeArmasParaLargar.isEmpty()) return null;
        int index = (int)(Math.random() * listaDeArmasParaLargar.size());
        return listaDeArmasParaLargar.get(index);
    }

    public abstract void usarHabilidadeEspecial(Personagem alvo);
}