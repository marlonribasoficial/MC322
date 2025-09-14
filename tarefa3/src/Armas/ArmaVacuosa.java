package Armas;

import Personagem.Personagem;
import Utilidades.Utilidades;

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


    @Override
    // Calcula o dano do ataque (com arma ou sem)
    public int atacarComArma(Personagem atacante, Personagem alvo) {
        int danoTotal;

        if (Math.random() < 0.5) { // 50% de usar arma
            danoTotal = atacante.getForca() + this.getDano();
            System.out.printf("🌌 %s distorce o espaço com %s, sugando %s e causando %d de dano!\n\n",
                                atacante.getNome(), this.getNome(), alvo.getNome(), danoTotal);
            Utilidades.tempoDeTexto();
            return danoTotal;
        } 

        return atacante.getForca();
    }
}