package Itens;

import Util.Utilidades;

public class ArmaGeometrica extends Arma {

    public ArmaGeometrica(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        String linha = "=================================================================================";
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Instrumento que gera padrões geométricos complexos e afiados");
        System.out.println(linha + "\n");
        Utilidades.tempoDeTexto();
    }
}