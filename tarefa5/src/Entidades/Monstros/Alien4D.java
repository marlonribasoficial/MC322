package Entidades.Monstros;

import Combate.AtaqueDimensional;
import Combate.HabilidadeAprisionar;
import Interfaces.Item;
import Itens.Arma;
import java.util.List;

public class Alien4D extends Monstro {
    public Alien4D(String nome,
                    int pontosDeVida,
                    int forca,
                    int xpConcedido,
                    int pontosDeVidaMaximo,
                    Arma arma,
                    List<Item> listaDeArmasParaLargar) {
        super(nome, pontosDeVida, forca, xpConcedido, pontosDeVidaMaximo, arma, listaDeArmasParaLargar);
        getAcoes().add(new AtaqueDimensional());
        getAcoes().add(new HabilidadeAprisionar());
    }
}