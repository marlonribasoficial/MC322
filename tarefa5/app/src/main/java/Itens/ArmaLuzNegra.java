package Itens;

import Util.Utilidades;

/**
 * Arma que emite luz escura e drena energia do inimigo.
 */
public class ArmaLuzNegra extends Arma {

    public ArmaLuzNegra(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        String linha = "=====================================================================";
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Lâmina que emite luz escura e drena energia \ndo inimigo");
        System.out.println(linha);
        Utilidades.tempoDeTexto();
    }
}