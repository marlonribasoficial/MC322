import java.util.List;

import Heroi.Astronauta;
import Monstros.Monstro;
import Utilidades.ConstrutorDeCenario;
import Utilidades.Fase;
import Utilidades.Item;
import Utilidades.Narrador;
import Utilidades.Simulador;
import Utilidades.Utilidades;

public class Main {
    public static void main(String[] args) {

        // Criando a heroína
        Astronauta astronauta = new Astronauta(
            "Capitã Fernanda", 
            120,
            35,
            0,
            0,
            100,
            120,
            100,
            null,
            0,
            0.3 // sorte = 30% de chance de usar habilidade
        );

        // Criando fases com monstros
        List<Fase> fases = ConstrutorDeCenario.gerarFases(3);

        // Item genérico
        Item tuboOxigenio = new Item("Tubo de Oxigênio");

        // Introdução (usa Narrador)
        Narrador.introducao(astronauta);

        boolean jogoAtivo = true;

        // Loop de fases
        for (Fase fase : fases) {
            Utilidades.imprimirTituloFase(fase);

            // Status do herói no início da fase
            astronauta.exibirStatus();

            for (Monstro monstro : fase.getMonstros()) {
                // Narrador mostra chegada
                Narrador.narrarChegada(monstro, "Surge {monstro}, vindo das profundezas do espaço!");

                jogoAtivo = Simulador.simularCombate(astronauta, monstro, tuboOxigenio);

                if (!jogoAtivo) break;

                // Narrador mostra vitória
                Narrador.narrarVitoria(astronauta, monstro, "O inimigo foi derrotado e desapareceu no vazio cósmico.");
            }

            // Status ao terminar a fase (só se ainda estiver vivo)
            if (jogoAtivo) astronauta.exibirStatus();

            if (!jogoAtivo) break;
        }

        // Encerramento (usa Narrador)
        if (astronauta.getVida() > 0) {
            Narrador.narrarVitoriaFinal(astronauta);
        } else {
            Narrador.narrarDerrota(astronauta);
        }
    }
}