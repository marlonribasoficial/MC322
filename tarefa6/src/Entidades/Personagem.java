package Entidades;

import Interfaces.Combatente;
import Itens.Arma;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

/**
 * Classe base abstrata para qualquer personagem (heróis ou monstros).
 * Implementa a interface Combatente.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Personagem implements Combatente {

    @XmlElement
    private String nome;

    @XmlElement
    private int pontosDeVida;

    @XmlElement
    private int forca;

    @XmlElement
    private Arma arma;

    // Status
    private boolean contaminado = false;
    private boolean refletido = false;
    private boolean aprisionado = false;
    private boolean desistiu = false;

    public Personagem() {}

    public Personagem(String nome, int pontosDeVida, int forca, Arma arma) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
    }

    // Métodos da Interface Combatente
    @Override
    public String getNome() { return nome; }

    @Override
    public boolean estaVivo() { return this.pontosDeVida > 0; }

    /**
     * Aplica dano ao personagem. Caso a vida chegue a zero, ele é considerado derrotado.
     */
    @Override
    public void receberDano(int dano) {
        this.pontosDeVida -= dano;
        if (this.pontosDeVida < 0) this.pontosDeVida = 0;
    }

    /**
     * Aplica cura ao personagem, aumentando seus pontos de vida.
     */
    @Override
    public void receberCura(int cura) {
        this.pontosDeVida += cura;
    }

    // Getters
    public int getPontosDeVida() { return pontosDeVida; }
    public int getForca() { return forca; }
    public Arma getArma() { return arma; }
    public boolean isContaminado() { return contaminado; }
    public boolean isRefletido() { return refletido; }
    public boolean isAprisionado() { return aprisionado; }
    public boolean isDesistente() { return desistiu; }

    // Setters
    public void setArma(Arma arma) { this.arma = arma; }
    public void setPontosDeVida(int pontosDeVida) { this.pontosDeVida = pontosDeVida; }
    public void setContaminado(boolean contaminado) { this.contaminado = contaminado; }
    public void setRefletido(boolean refletido) { this.refletido = refletido; }
    public void setAprisionado(boolean aprisionado) { this.aprisionado = aprisionado; }
    public void setDesistiu(boolean desistiu) { this.desistiu = desistiu; }
    
    // Métodos Abstratos
    /**
     * Exibe os status do personagem no console (implementação depende da subclasse).
     */
    public abstract void exibirStatus();
}