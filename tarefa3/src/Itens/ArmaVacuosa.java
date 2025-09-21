package Itens;

import Util.Utilidades;

public class ArmaVacuosa extends Arma {

    public ArmaVacuosa(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        String linha = "=====================================================================";
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Dispositivo que manipula o vácuo, distorcendo a gravidade dos inimigos");
        System.out.println(linha + "\n");
        Utilidades.tempoDeTexto();
    }
}