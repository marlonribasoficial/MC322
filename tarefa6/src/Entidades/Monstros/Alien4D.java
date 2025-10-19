package Entidades.Monstros;

import Combate.AtaqueDimensional;
import Combate.HabilidadeAprisionar;
import Interfaces.AcaoDeCombate;
import Interfaces.Item;
import Itens.Arma;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

/**
 * Alienígena 4D com ataques dimensionais e habilidade de aprisionar.
 */
@XmlRootElement
public class Alien4D extends Monstro {

    public Alien4D() { 
        super();
    }

    public Alien4D(String nome,
                    int pontosDeVida,
                    int forca,
                    int xpConcedido,
                    int pontosDeVidaMaximo,
                    Arma arma,
                    List<String> listaDeLoot,
                    List<AcaoDeCombate> acoes) {
        super(nome, pontosDeVida, forca, xpConcedido, pontosDeVidaMaximo, arma, listaDeLoot, acoes);
    }
}