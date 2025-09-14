package Armas;

import Personagem.Personagem;
import Utilidades.Utilidades;

public class ArmaIlusao extends Arma {

    public ArmaIlusao(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        String linha = "=====================================================================";
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Artefato que cria ilusões e confunde o inimigo");
        System.out.println(linha + "\n");
        Utilidades.tempoDeTexto();
    }

    @Override
    // Calcula o dano do ataque (com arma ou sem)
    public int atacarComArma(Personagem atacante, Personagem alvo) {
        int danoTotal;

        if (Math.random() < 0.5) { // 50% de usar arma
            danoTotal = atacante.getForca() + this.getDano();
            System.out.printf("🌌 %s cria uma ilusão devastadora com %s contra %s, causando %d de dano!\n\n",
                                atacante.getNome(), this.getNome(), alvo.getNome(), danoTotal);
            Utilidades.tempoDeTexto();
            return danoTotal;
        }
        
        return atacante.getForca();
    }
}