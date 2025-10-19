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
import Util.ItemCreator;
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
    private List<AcaoDeCombate> acoes;

    @XmlElement
    private int pontosDeVidaMaximo;

    @XmlTransient // Não precisa ser salvo, será definido pelo ConstrutorDeCenarioFixo
    private List<String> tabelaDeLoot;

    public Monstro() {
        super();
    }

    public Monstro(String nome,
                   int pontosDeVida,
                   int forca,
                   int xpConcedido,
                   int pontosDeVidaMaximo,
                   Arma arma,
                   List<String> tabelaDeLoot,
                   List<AcaoDeCombate> acoes) {
        super(nome, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.pontosDeVidaMaximo = pontosDeVidaMaximo;
        this.tabelaDeLoot = tabelaDeLoot;
        this.acoes = acoes;
    }

    // Getters
    public int getXpConcedido() { return xpConcedido; }
    public int getVidaMax() { return pontosDeVidaMaximo; }

    /**
     * Escolhe aleatoriamente uma ação de combate entre as disponíveis.
     *
     * @param alvo combatente alvo da ação
     * @return ação escolhida
     */
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        if (acoes == null || acoes.isEmpty()) { return null; }
        Random random = new Random();
        return acoes.get(random.nextInt(acoes.size()));
    }

    /**
     * Escolhe aleatoriamente um item da tabela de loot.
     *
     * @return item dropado ou null se não houver loot
     */
    @Override
    public Item droparLoot(int nivelFase, double modDificuldade) {
        if (tabelaDeLoot == null || tabelaDeLoot.isEmpty()) {
            return null;
        }
        Random random = new Random();
        String nomeItemParaDropar = tabelaDeLoot.get(random.nextInt(tabelaDeLoot.size()));
        return ItemCreator.criarItem(nomeItemParaDropar, nivelFase, modDificuldade);
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