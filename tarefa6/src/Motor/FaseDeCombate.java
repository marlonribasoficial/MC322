package Motor;

import Entidades.Heroi.Heroi;
import Entidades.Monstros.Alien4D;
import Entidades.Monstros.AlienParadoxo;
import Entidades.Monstros.AlienSlime;
import Entidades.Monstros.Monstro;
import Interfaces.Fase;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

/**
 * Representa uma fase de combate contendo um nível,
 * um cenário e uma lista de monstros a serem enfrentados.
 * Controla o início da fase e verifica se ela foi concluída.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FaseDeCombate implements Fase {

    @XmlElement
    private int nivel;

    @XmlElement
    private TipoCenario cenario;

    @XmlElements({
        @XmlElement(name="alienSlime", type=AlienSlime.class),
        @XmlElement(name="alienParadoxo", type=AlienParadoxo.class),
        @XmlElement(name="alien4D", type=Alien4D.class)
    })
    private List<Monstro> monstros;

    public FaseDeCombate() {}

    /**
     * Construtor da fase de combate.
     *
     * @param nivel Nível da fase
     * @param cenario Tipo de cenário onde a fase ocorre
     * @param monstros Lista de monstros que aparecerão na fase
     */
    public FaseDeCombate(int nivel, TipoCenario cenario, List<Monstro> monstros) {
        this.nivel = nivel;
        this.cenario = cenario;
        this.monstros = monstros;
    }
    
    /** 
     * Retorna a lista de monstros da fase.
     * 
     * @return Lista de monstros
     */
    public List<Monstro> getMonstros() { return monstros; }

    public void setMonstros(List<Monstro> monstros) {
        this.monstros = monstros;
    }

    /**
     * Retorna o nível da fase.
     *
     * @return nível da fase
     */
    public int getNivel() { return nivel; }

    /**
     * Inicia a fase aplicando efeitos do cenário sobre o herói.
     *
     * @param heroi Herói que participará da fase
     */
    @Override
    public void iniciar(Heroi heroi) {
        Narrador.imprimirTituloFase(this);
        cenario.aplicarEfeitos(heroi);
    }

    /**
     * Verifica se todos os monstros da fase foram derrotados.
     *
     * @return {@code true} se todos os monstros estiverem mortos, 
     * {@code false} caso contrário
     */
    @Override
    public boolean isConcluida() {
        for (Monstro monstro : monstros) {
            if (monstro.estaVivo()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Retorna o tipo de cenário da fase.
     *
     * @return TipoCenario da fase
     */
    @Override
    public TipoCenario getTipoDeCenario() {
        return cenario;
    }

    public void setTipoDeCenario(TipoCenario cenario) {
        this.cenario = cenario;
    }
}