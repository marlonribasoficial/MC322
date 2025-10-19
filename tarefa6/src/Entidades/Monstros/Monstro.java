package Entidades.Monstros;

import Entidades.Personagem;
import Interfaces.*;
import Itens.Arma;
import Itens.ArmaEstelar;
import Itens.ArmaGeometrica;
import Itens.ArmaGosmaX;
import Itens.ArmaIlusao;
import Itens.ArmaLuzNegra;
import Itens.ArmaVacuosa;
import Itens.ItemGenerico;
import Util.Utilidades;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Combate.AtaqueContaminante;
import Combate.AtaqueDimensional;
import Combate.AtaqueParadoxal;
import Combate.HabilidadeAprisionar;
import Combate.HabilidadeEspelhoTemporal;
import Combate.HabilidadeFragmentar;

/**
 * Classe abstrata que representa um monstro genérico.
 * Possui XP concedido ao ser derrotado, tabela de loot e lista de ações.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Monstro extends Personagem implements Lootavel {

    @XmlElement
    private int xpConcedido;

    @XmlTransient 
    private List<AcaoDeCombate> acoes = new ArrayList<>();

    @XmlElement
    private int pontosDeVidaMaximo;

    @XmlElements({
        @XmlElement(name="armaEstelar", type=ArmaEstelar.class),
        @XmlElement(name="armaGosmaX", type=ArmaGosmaX.class),
        @XmlElement(name="armaLuzNegra", type=ArmaLuzNegra.class),
        @XmlElement(name="armaGeometrica", type=ArmaGeometrica.class),
        @XmlElement(name="armaIlusao", type=ArmaIlusao.class),
        @XmlElement(name="armaVacuosa", type=ArmaVacuosa.class),
    })
    private List<Item> tabelaDeLoot;

    public Monstro() { 
        super();
        inicializarAcoes(); 
    }

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
        inicializarAcoes();
    }

    // Getters
    public int getXpConcedido() { return xpConcedido; }
    protected List<AcaoDeCombate> getAcoes() { return acoes; }
    public int getVidaMax() { return pontosDeVidaMaximo; }

    /** 
     * Inicializa a lista de ações do monstro.
     */
    public void inicializarAcoes() {
        if (acoes == null) {
            acoes = new ArrayList<>();
        }

        if (this instanceof Alien4D) {
            acoes.add(new AtaqueDimensional());
            acoes.add(new HabilidadeAprisionar());
        } else if (this instanceof AlienParadoxo) {
            acoes.add(new AtaqueParadoxal());
            acoes.add(new HabilidadeEspelhoTemporal());
        } else if (this instanceof AlienSlime) {
            acoes.add(new AtaqueContaminante());
            acoes.add(new HabilidadeFragmentar());
        }
    }

    /** 
     * Inicializa o loot do monstro.
     */
    public void inicializarLoot(int i, double mod) {
        if (tabelaDeLoot == null) {
            tabelaDeLoot = new ArrayList<>();
        }

        if (this instanceof Alien4D) {
            tabelaDeLoot.add(new ArmaLuzNegra("Lâmina de Antimatéria", (int)((25 + i) * mod), 3));
            tabelaDeLoot.add(new ArmaGeometrica("Cubo Hipergeométrico", (int)((22 + i) * mod), 2));
            tabelaDeLoot.add(new ItemGenerico("Tubo de Oxigênio"));

            if (mod == 1.2) {
                tabelaDeLoot.add(new ArmaLuzNegra("Lâmina de Antimatéria", (int)((25 + i) * mod), 3));
                tabelaDeLoot.add(new ItemGenerico("Tubo de Oxigênio"));                   
            }

        } else if (this instanceof AlienParadoxo) {
            tabelaDeLoot.add(new ArmaVacuosa("Distorcedor a Vácuo", (int)((20 + i) * mod), 2));
            tabelaDeLoot.add(new ArmaIlusao("Projetor de Ilusões", (int)((18 + i) * mod), 1));

            if (mod == 1.2) {
                tabelaDeLoot.add(new ArmaVacuosa("Distorcedor a Vácuo", (int)((20 + i) * mod), 2));
            }

        } else if (this instanceof AlienSlime) {
            tabelaDeLoot.add(new ArmaGosmaX("GosmaX", (int)((10 + i) * mod), 0));
            tabelaDeLoot.add(new ArmaEstelar("Fragmento Estelar", (int)((15 + i) * mod), 1));
            tabelaDeLoot.add(new ItemGenerico("Tubo de Oxigênio"));

            if (mod == 1.2) {
                tabelaDeLoot.add(new ArmaEstelar("Fragmento Estelar", (int)((15 + i) * mod), 1));
                tabelaDeLoot.add(new ItemGenerico("Tubo de Oxigênio"));
            }
        }
    }

    /**
     * Escolhe aleatoriamente uma ação de combate entre as disponíveis.
     *
     * @param alvo combatente alvo da ação
     * @return ação escolhida
     */
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        Random random = new Random();
        int index = random.nextInt(acoes.size());
        return acoes.get(index);
    }

    /**
     * Escolhe aleatoriamente um item da tabela de loot.
     *
     * @return item dropado ou null se não houver loot
     */
    @Override
    public Item droparLoot() {
        if (tabelaDeLoot == null || tabelaDeLoot.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(tabelaDeLoot.size());
        return tabelaDeLoot.get(index);
    }

    /**
     * Cura o monstro sem ultrapassar a vida máxima.
     */
    @Override
    public void receberCura(int cura) {
        super.receberCura(cura);
        if (getPontosDeVida() > pontosDeVidaMaximo) {
            setPontosDeVida(pontosDeVidaMaximo);
        }
    }

    /**
     * Exibe no console os status do monstro (nome, vida, força, XP).
     */
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