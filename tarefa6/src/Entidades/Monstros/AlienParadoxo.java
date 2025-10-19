package Entidades.Monstros;

import Combate.AtaqueParadoxal;
import Combate.HabilidadeEspelhoTemporal;
import Interfaces.AcaoDeCombate;
import Interfaces.Item;
import Itens.Arma;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

/**
 * Alienígena do paradoxo, usa ataques paradoxais e espelho temporal.
 */
@XmlRootElement
public class AlienParadoxo extends Monstro {

    public AlienParadoxo() { 
        super();
    }

    public AlienParadoxo(String nome,
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