package Entidades.Heroi;

import Interfaces.*;
import Itens.*;
import Util.Utilidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Combate.AcaoUsarItem;
import Combate.AtaqueComArma;
import Combate.AtaqueFisico;
import Combate.HabilidadeDefesaTraje;
import Combate.HabilidadeSoproCriogenico;

/**
 * Classe que representa o herói Astronauta.
 * Possui atributos exclusivos como traje espacial e oxigênio,
 * além de um inventário de itens.
 */
public class Astronauta extends Heroi {
    private int pontosDeVidaMaximo;
    private int trajeEspacial;
    private int oxigenio;
    private List<Item> inventario = new ArrayList<>();

    /**
     * Construtor que inicializa o astronauta com atributos básicos,
     * recursos (vida, traje, oxigênio) e ações de combate.
     */
    public Astronauta(String nome,
                    int pontosDeVida,
                    int forca,
                    int nivel,
                    int exp,
                    int trajeEspacial,
                    int pontosDeVidaMaximo,
                    int oxigenio,
                    Arma arma,
                    double sorte) {
        super(nome, pontosDeVida, forca, nivel, exp, arma, sorte);
        this.pontosDeVidaMaximo = pontosDeVidaMaximo;
        this.trajeEspacial = trajeEspacial;
        this.oxigenio = oxigenio;
        
        // Lista de ações
        getAcoes().add(new AtaqueFisico());
        getAcoes().add(new HabilidadeDefesaTraje());
        getAcoes().add(new HabilidadeSoproCriogenico());
        getAcoes().add(new AcaoUsarItem());
    }

    /**
     * Sobe de nível, restaurando atributos e fortalecendo
     * traje e oxigênio.
     */
    @Override
    protected void subirDeNivel() {
        receberCura(40);

        int novoOxigenio = getOxigenio() + 20;
        if (novoOxigenio >= 100) {
            setOxigenio(100);
        } else {
            setOxigenio(novoOxigenio);
        }

        int novoTraje = getTrajeEspacial() + 20;
        if (novoTraje >= 100) {
            setTrajeEspacial(100);
        } else {
            setTrajeEspacial(novoTraje);
        }

        System.out.println("[Atributos fortalecidos]\n");
        Utilidades.tempoDeTexto();
    }
    
    // Getters
    public int getVidaMax() { return pontosDeVidaMaximo; }
    public int getOxigenio() { return oxigenio; }
    public int getTrajeEspacial() { return trajeEspacial; }
    public List<Item> getInventario() { return this.inventario; }

    // Setters
    public void setOxigenio(int oxigenio) { this.oxigenio = oxigenio; }
    public void setTrajeEspacial(int trajeEspacial) { this.trajeEspacial = trajeEspacial; }
    public void adicionarItemAoInventario(Item item) {
        if (item != null) {
            this.inventario.add(item);
            System.out.printf("🎒 %s guardou %s no inventário.\n\n", getNome(), item.getNome());
            Utilidades.tempoDeTexto();
        }
    }

    /**
     * Permite ao Astronauta escolher a ação de combate mais adequada
     * considerando vida, sorte, oxigênio e inventário.
     *
     * @param alvo inimigo ou alvo da ação
     * @return ação escolhida
     */
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        Random random = new Random();
        
        if (this.oxigenio < 50 && inventario.stream().anyMatch(item -> item.getNome().equals("Tubo de Oxigênio"))) {
            return getAcoes().get(3); // AcaoUsarItem
        }
        
        if (this.oxigenio >= 40 && random.nextDouble() < getSorte() * 0.4) {
            return getAcoes().get(2); // HabilidadeSoproCriogenico
        }
        
        if (this.getPontosDeVida() < this.pontosDeVidaMaximo / 2 && this.trajeEspacial >= 40 && random.nextDouble() < getSorte()) {
             return getAcoes().get(1); // HabilidadeDefesaTraje
        }

        if (getArma() != null) {
            return new AtaqueComArma();
        }

        return getAcoes().get(0);
    }
    
    /**
     * Cura o Astronauta sem ultrapassar o limite de vida máxima.
     *
     * @param cura quantidade de vida a recuperar
     */
    @Override
    public void receberCura(int cura) {
        super.receberCura(cura);
        if (getPontosDeVida() > pontosDeVidaMaximo) {
            setPontosDeVida(pontosDeVidaMaximo);
        }
    }

    /**
     * Exibe os status atuais do Astronauta no console
     * (vida, nível, oxigênio, traje etc.).
     */
    @Override
    public void exibirStatus() {
        String linha = "========================================";
        System.out.println("\n" + linha);
        System.out.printf("| 🚀 Nome: %-32s\n", this.getNome());
        System.out.printf("| 💖 Vida: %-18s %3d/%d\n", Utilidades.gerarBarra(this.getPontosDeVida(), pontosDeVidaMaximo, 10), this.getPontosDeVida(), this.pontosDeVidaMaximo);
        System.out.printf("| ⚔️ Força: %-28d\n", this.getForca());
        System.out.printf("| 🆙 Nível: %-29d\n", this.getNivel());
        System.out.printf("| ⭐ EXP: %-31d\n", this.getExp());
        System.out.printf("| 🫁 Oxigênio: %-18s %3d%%\n", Utilidades.gerarBarra(this.oxigenio, 100, 10), this.oxigenio);
        System.out.printf("| 🛰️ Traje: %-20s %3d%%\n", Utilidades.gerarBarra(this.trajeEspacial, 100, 10), this.trajeEspacial);
        System.out.println(linha + "\n");
        Utilidades.tempoDeTexto();
    }
}