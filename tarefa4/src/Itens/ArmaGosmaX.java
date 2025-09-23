package Itens;

import Util.Utilidades;

public class ArmaGosmaX extends Arma {

    public ArmaGosmaX(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        String linha = "=====================================================================";
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Esfera de gosma alienígena pegajosa e corrosiva");
        System.out.println(linha + "\n");
        Utilidades.tempoDeTexto();
    }
}