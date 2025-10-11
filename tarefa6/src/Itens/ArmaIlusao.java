package Itens;

import Util.Utilidades;

/**
 * Arma que cria ilusões para confundir o inimigo.
 */
public class ArmaIlusao extends Arma {

    public ArmaIlusao(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        String linha = "=====================================================================";
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Artefato que cria ilusões e confunde o inimigo");
        System.out.println(linha);
        Utilidades.tempoDeTexto();
    }
}