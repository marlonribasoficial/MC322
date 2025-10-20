package Motor;

import Entidades.Heroi.Astronauta;
import Entidades.Monstros.Monstro;
import Util.Utilidades;

/**
 * Classe responsável por narrar os eventos do jogo,
 * como introdução, chegada de inimigos, vitórias, derrotas e conclusão das fases.
 * Utiliza delays e prints estilizados para criar imersão no jogo.
 */
public class Narrador {

    public static void introducao(Astronauta astronauta) {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("  __  __ _                                _       _           ");
        System.out.println(" |  \\/  (_)                         /\\   | |     | |          ");
        System.out.println(" | \\  / |_ ___ ___  __ _  ___      /  \\  | |_ __ | |__   __ _ ");
        System.out.println(" | |\\/| | / __/ __|/ _` |/ _ \\    / /\\ \\ | | '_ \\| '_ \\ / _` |");
        System.out.println(" | |  | | \\__ \\__ \\ (_| | (_) |  / ____ \\| | |_) | | | | (_| |");
        System.out.println(" |_|  |_|_|___/___/\\__,_|\\___/  /_/    \\_\\_| .__/|_| |_|\\__,_|");
        System.out.println("                                           | |                ");
        System.out.println("                                           |_|                ");

        System.out.println(" ");
        System.out.println(" ");

        printComDelay("         U M A   A V E N T U R A   E S P A C I A L\n");
        System.out.println(" ");
        printComDelay("A bordo da nave Zênite, a corajosa " + astronauta.getNome() + " da AEB (Agência Espacial Brasileira) é lançada para uma galáxia desconhecida após uma colisão inesperada com um buraco de minhoca.\n");
        printComDelay("Ao emergirem, a tripulação se depara com um buraco negro supermassivo, cuja gravidade é capaz de dilacerar qualquer nave em instantes.\n");
        printComDelay("Mas não estão sozinhos: seres alienígenas de forças inimagináveis começam a surgir, distorcendo o espaço e o tempo ao redor.\n");
        printComDelay(astronauta.getNome() + " precisará de toda sua coragem e habilidades para derrotá-los e escapar da ameaça do buraco negro.\n");
        astronauta.exibirStatus();
    }

    public static void imprimirTituloFase(FaseDeCombate f) {
        System.out.println("\n═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═");
        System.out.printf("🌌 FASE %d — Ambiente: %s\n", f.getNivel(), f.getTipoDeCenario().getDescricao());
        System.out.println("═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═ ═\n");
        Utilidades.tempoDeTexto();
    }

    public static void narrarChegada(Monstro monstro) {
        System.out.println(" ");
        System.out.println("----------------------------------------------------------------------");
        printComDelay("\n⚠️ Surge " + monstro.getNome() + ", vindo das profundezas do espaço!\n");
        System.out.println("----------------------------------------------------------------------");
        monstro.exibirStatus();
    }

    public static void narrarVitoria(Astronauta astronauta, Monstro monstro) {
        String bloco =
            "\n═══════════════════════════════════════════════════════════════\n" +
            " 🛰️ Vitória! " + astronauta.getNome() + " derrotou " + monstro.getNome() + "!\n" +
            " ➤ Experiência obtida: +" + monstro.getXpConcedido() + "\n" +
            "═══════════════════════════════════════════════════════════════\n";
        printComDelay(bloco);
    }

    public static void narrarDerrota(Astronauta astronauta) {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("  ____                         ___                    ");
        System.out.println(" / ___| __ _ _ __ ___   ___   / _ \\__   _____ _ __    ");
        System.out.println("| |  _ / _` | '_ ` _ \\ / _ \\ | | | \\ \\ / / _ \\ '__|   ");
        System.out.println("| |_| | (_| | | | | | |  __/ | |_| |\\ V /  __/ |_ _ _ ");
        System.out.println(" \\____|\\__,_|_| |_| |_|\\___|  \\___/  \\_/ \\___|_(_|_|_)");
        System.out.println(" ");
        System.out.println(astronauta.getNome() + " não resistiu aos poderes dos Aliens...\n");
        System.out.println("A nave Zênite foi engolida pelo buraco negro, e a galáxia desconhecida permanece inexplorada.\n");
        System.out.println(" ");
        astronauta.exibirStatus();
    }

    public static void narrarVitoriaFinal(Astronauta astronauta) {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ____                 _                    ");
        System.out.println("|  _ \\ __ _ _ __ __ _| |__   ___ _ __  ___ ");
        System.out.println("| |_) / _` | '__/ _` | '_ \\ / _ \\ '_ \\/ __|");
        System.out.println("|  __/ (_| | | | (_| | |_) |  __/ | | \\__ \\");
        System.out.println("|_|   \\__,_|_|  \\__,_|_.__/ \\___|_| |_|___/");
        System.out.println(" ");
        System.out.println(astronauta.getNome() + " derrotou todos os alienígenas e escapou do buraco negro!\n");
        System.out.println("A galáxia desconhecida agora está segura graças à coragem da nossa heroína.\n");
        System.out.println(" ");
        astronauta.exibirStatus();
    }

    public static void narrarDesistencia(Astronauta astronauta) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("\n🌌 " + astronauta.getNome() + " encerrou a missão.");
        System.out.println("\nA tripulação retorna à Terra em segurança...");
        System.out.println("Mas a galáxia misteriosa continua aguardando por um novo explorador...\n");
        System.out.println("----------------------------------------------------------------------------------");
    }

    /**
     * Método auxiliar para imprimir texto com delay para criar efeito de narrativa.
     *
     * @param texto Texto a ser exibido
     */
    private static void printComDelay(String texto) {
        System.out.println(texto);
        Utilidades.tempoDeTexto();
    }
}