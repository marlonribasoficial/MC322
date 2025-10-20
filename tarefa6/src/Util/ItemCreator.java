package Util;

import Itens.*;
import Interfaces.Item;

/**
 * Responsável por criar instâncias de itens com base em seus nomes.
 * Centraliza a lógica de criação, aplicando modificadores de dificuldade e
 * nível da fase no momento da instanciação.
 */
public class ItemCreator {

    public static Item criarItem(String nomeItem, int nivelFase, double modDificuldade) {
        switch (nomeItem) {
            case "Fragmento Estelar":
                return new ArmaEstelar("Fragmento Estelar", (int)((15 + nivelFase) * modDificuldade), 1);
            case "GosmaX":
                return new ArmaGosmaX("GosmaX", (int)((10 + nivelFase) * modDificuldade), 0);
            case "Distorcedor a Vácuo":
                return new ArmaVacuosa("Distorcedor a Vácuo", (int)((20 + nivelFase) * modDificuldade), 2);
            case "Projetor de Ilusões":
                return new ArmaIlusao("Projetor de Ilusões", (int)((18 + nivelFase) * modDificuldade), 1);
            case "Lâmina de Antimatéria":
                return new ArmaLuzNegra("Lâmina de Antimatéria", (int)((25 + nivelFase) * modDificuldade), 3);
            case "Cubo Hipergeométrico":
                return new ArmaGeometrica("Cubo Hipergeométrico", (int)((22 + nivelFase) * modDificuldade), 2);
            case "Tubo de Oxigênio":
                return new ItemGenerico("Tubo de Oxigênio");
            default:
                System.err.println("Aviso: ItemFactory não conseguiu criar o item: " + nomeItem);
                return null;
        }
    }
}