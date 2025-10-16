package Itens;

import Util.Utilidades;

/**
 * Arma que manipula o vácuo, distorcendo a gravidade dos inimigos.
 */
public class ArmaVacuosa extends Arma {

    public ArmaVacuosa() {
        super();
    }

    public ArmaVacuosa(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        String linha = "=====================================================================";
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Dispositivo que manipula o vácuo, distorcendo a \ngravidade dos inimigos");
        System.out.println(linha);
        Utilidades.tempoDeTexto();
    }
}