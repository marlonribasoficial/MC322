package Entidades.Monstros;

import Combate.AtaqueContaminante;
import Combate.HabilidadeFragmentar;
import Interfaces.AcaoDeCombate;
import Interfaces.Item;
import Itens.Arma;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

/**
 * Alienígena slime, capaz de contaminar e se regenerar fragmentando-se.
 */
@XmlRootElement
public class AlienSlime extends Monstro {

    public AlienSlime() { 
        super();
    }

    public AlienSlime(String nome,
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