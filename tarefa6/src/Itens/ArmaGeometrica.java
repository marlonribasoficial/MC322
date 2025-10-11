package Itens;

import Util.Utilidades;

/**
 * Arma que gera padrões geométricos complexos e afiados.
 */
public class ArmaGeometrica extends Arma {

    public ArmaGeometrica(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        String linha = "=====================================================================";
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Instrumento que gera padrões geométricos \ncomplexos e afiados");
        System.out.println(linha);
        Utilidades.tempoDeTexto();
    }
}