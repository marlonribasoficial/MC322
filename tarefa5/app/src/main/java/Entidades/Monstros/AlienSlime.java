package Entidades.Monstros;

import Combate.AtaqueContaminante;
import Combate.HabilidadeFragmentar;
import Interfaces.Item;
import Itens.Arma;
import java.util.List;

/**
 * Alienígena slime, capaz de contaminar e se regenerar fragmentando-se.
 */
public class AlienSlime extends Monstro {
    public AlienSlime(String nome,
                    int pontosDeVida,
                    int forca,
                    int xpConcedido,
                    int pontosDeVidaMaximo,
                    Arma arma,
                    List<Item> listaDeArmasParaLargar) {
        super(nome, pontosDeVida, forca, xpConcedido, pontosDeVidaMaximo, arma, listaDeArmasParaLargar);
        getAcoes().add(new AtaqueContaminante());
        getAcoes().add(new HabilidadeFragmentar());
    }
}