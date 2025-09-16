package Heroi;

import Armas.Arma;
import Personagem.Personagem;
import Utilidades.Item;
import Utilidades.Utilidades;
import java.util.ArrayList;

public class Astronauta extends Heroi {
    private final int pontosDeVidaMaximo;
    private int trajeEspacial;
    private int oxigenio;
    private ArrayList<Item> inventario = new ArrayList<>();
    private static final int[] EXP_POR_NIVEL = {60, 120, 200, 280, 360};

    public Astronauta(String nome,
                      int pontosDeVida,
                      int forca,
                      int nivel,
                      int exp,
                      int trajeEspacial,
                      int pontosDeVidaMaximo,
                      int oxigenio,
                      Arma arma,
                      int expProximoNivel,
                      double sorte) {
        super(nome, pontosDeVida, forca, nivel, exp, arma, expProximoNivel, sorte);
        this.pontosDeVidaMaximo = pontosDeVidaMaximo;
        this.trajeEspacial = trajeEspacial;
        this.oxigenio = oxigenio;
    }

    // Getters
    public int getVidaMax() { return pontosDeVidaMaximo; }
    public int getTrajeEspacial() { return trajeEspacial; }
    public int getOxigenio() { return oxigenio; }
    public ArrayList<Item> getInventario() { return inventario; }
    public int[] getXpPorNivel() { return EXP_POR_NIVEL; }

    @Override
    public void receberCura(int cura) {
        int vida = this.getVida() + cura;
        if (vida > pontosDeVidaMaximo) {
            setVida(pontosDeVidaMaximo);
        } else {
            setVida(vida);
        }
    }

    // Experiência
    public void ganharExperiencia(int xpGanho) {
        int exp = this.getExp() + xpGanho;
        setExp(exp);
        atualizarExpProximoNivel();
        subirDeNivel();
    }

    private void atualizarExpProximoNivel() {
        if (getNivel() < EXP_POR_NIVEL.length) {
            setExpProximoNivel(Math.max(0, EXP_POR_NIVEL[getNivel()] - getExp()));
        } else {
            setExpProximoNivel(0); // nível máximo
        }
    }

    private void subirDeNivel() {
        if (getExp() >= 60 && getNivel() < 1) {
            ganharAtributos(1, 35, 10, 10);
        } else if (getExp() >= 120 && getNivel() < 2) {
            ganharAtributos(2, 45, 10, 10);
        } else if (getExp() >= 200 && getNivel() < 3) {
            ganharAtributos(3, 55, 15, 15);
        } else if (getExp() >= 280 && getNivel() < 4) {
            ganharAtributos(4, 60, 25, 25);
        } else if (getExp() >= 360 && getNivel() < 5) {
            ganharAtributos(5,70, 30, 30);
        }
    }

    private void ganharAtributos(int novoNivel, int vidaGanha, int oxigenioGanho, int trajeGanho) {
        int nivelAntigo = getNivel();
        setNivel(novoNivel);
        setVida(Math.min(getVida() + vidaGanha, pontosDeVidaMaximo));
        oxigenio = Math.min(oxigenio + oxigenioGanho, 100);
        trajeEspacial = Math.min(trajeEspacial + trajeGanho, 100);
        printLevelUp(nivelAntigo);
    }

    private void printLevelUp(int nivelAntigo) {
        String linha = "==================================================";
        String titulo = "           ✨✨✨ LEVEL UP! ✨✨✨";
        System.out.println("\n" + linha);
        System.out.printf("%-36s\n", titulo);
        System.out.println("\n" + getNome() + " subiu do nível " + nivelAntigo + " para o nível " + getNivel() + "!");
        System.out.println(linha + "\n");
        Utilidades.tempoDeTexto();
    }

    // Ataques e Habilidades
    @Override
    public void atacar(Personagem alvo) {
        int danoTotal;

        // Ataque com arma
        if (getArma() != null) {
            danoTotal = getArma().atacarComArma(this, alvo);

            // Se não houve ataque com arma
            if (danoTotal == getForca()) {
                System.out.printf("🚀 %s ataca %s com força %d!\n\n", getNome(), alvo.getNome(), danoTotal);
                Utilidades.tempoDeTexto();
            }

        } else {
            danoTotal = getForca();
            System.out.printf("🚀 %s ataca %s com força %d!\n\n", getNome(), alvo.getNome(), danoTotal);
            Utilidades.tempoDeTexto();
        }

        alvo.receberDano(danoTotal);

        // Chance de usar habilidade dependendo da sorte
        if (Math.random() < getSorte()) {
            usarHabilidadeEspecial(alvo);
        }
        // Chance fixa de ativar sopro criogênico
        else if (Math.random() < 0.2) {
            soproCriogenico(alvo);
        }
    }

    public void soproCriogenico(Personagem alvo) {
        if (this.oxigenio >= 40) {
            System.out.printf("❄️ O QUE FOI ISSO? %s usa o sopro criogênico em %s causando %d de dano!\n\n",
                    getNome(), alvo.getNome(), getForca() * 3);
            Utilidades.tempoDeTexto();
            alvo.receberDano(getForca() * 3);
            this.oxigenio -= 40;
            if (this.oxigenio < 0) this.oxigenio = 0;
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (trajeEspacial >= 40) {
            System.out.printf("🛡️ %s ativa o modo de defesa máxima do traje espacial!\n\n", getNome());
            Utilidades.tempoDeTexto();
            int vida = getVida() + 40;
            setVida(vida);
            if (getVida() > pontosDeVidaMaximo) setVida(pontosDeVidaMaximo);

            this.trajeEspacial -= 30;
            this.oxigenio -= 10;
            if (this.oxigenio < 0) this.oxigenio = 0;
        } else {
            System.out.printf("⚠️ %s não tem energia suficiente para usar a habilidade especial do traje!\n\n", getNome());
            Utilidades.tempoDeTexto();
        }
    }

    // Inventário
    public void pegarItem(Item item) {
        if (Math.random() < 0.4) {
            inventario.add(item);
            System.out.printf("🎁 %s pegou um %s!\n\n", getNome(), item.getNome());
            Utilidades.tempoDeTexto();
        }
    }

    public void usarTuboOxigenio() {
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getNome().equals("Tubo de Oxigênio")) {
                oxigenio += 40;
                if (oxigenio > 100) oxigenio = 100;

                inventario.remove(i);
                System.out.printf("💨 %s usou um Tubo de Oxigênio! [Oxigênio agora em %d%%]\n\n", getNome(), oxigenio);
                Utilidades.tempoDeTexto();
                return;
            }
        }
        System.out.printf("⚠️ %s não tem nenhum Tubo de Oxigênio para usar!\n\n", getNome());
        Utilidades.tempoDeTexto();
    }

    // Status
    @Override
    public void exibirStatus() {
        String linha = "========================================";
        System.out.println("\n" + linha);
        System.out.printf("| 🚀 Nome: %-32s\n", getNome());
        System.out.printf("| 💖 Pontos de Vida: %-11s %3d\n", Utilidades.gerarBarra(getVida(), pontosDeVidaMaximo, 10), getVida());
        System.out.printf("| ⚔️ Força: %-28d\n", getForca());
        System.out.printf("| 🆙 Nível: %-29d\n", getNivel());
        System.out.printf("| ⭐ Experiência: %-24d\n", getExp());
        System.out.printf("| 🫁 Oxigênio: %-18s %3d%%\n", Utilidades.gerarBarra(this.oxigenio, 100, 10), this.oxigenio);
        System.out.printf("| 🛰️ Traje Espacial: %-13s %3d%%\n", Utilidades.gerarBarra(this.trajeEspacial, 100, 10), this.trajeEspacial);
        System.out.println(linha + "\n");
        Utilidades.tempoDeTexto();
    }
}
