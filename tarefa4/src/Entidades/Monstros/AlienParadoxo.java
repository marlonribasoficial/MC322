package Entidades.Monstros;

import Combate.AtaqueParadoxal;
import Combate.HabilidadeEspelhoTemporal;
import Interfaces.Item;
import Itens.Arma;
import java.util.List;

public class AlienParadoxo extends Monstro {
    public AlienParadoxo(String nome,
                        int pontosDeVida,
                        int forca,
                        int xpConcedido,
                        int pontosDeVidaMaximo,
                        Arma arma,
                        List<Item> listaDeArmasParaLargar) {
        super(nome, pontosDeVida, forca, xpConcedido, pontosDeVidaMaximo, arma, listaDeArmasParaLargar);
        getAcoes().add(new AtaqueParadoxal());
        getAcoes().add(new HabilidadeEspelhoTemporal());
    }
}