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

    public static void narrarChegada(Monstro monstro, String descricao) {
        System.out.println(" ");
        System.out.println(" ");
        printComDelay("⚠️ " + descricao.replace("{monstro}", monstro.getNome()) + "\n");
        monstro.exibirStatus();
    }

    public static void narrarVitoria(Astronauta astronauta, Monstro monstro, String descricao) {
        String bloco =
            "\n═══════════════════════════════════════════════════════════════\n" +
            " 🛰️ Vitória! " + astronauta.getNome() + " derrotou " + monstro.getNome() + "!\n" +
            " ▸ " + descricao + "\n" +
            " ➤ Experiência obtida: +" + monstro.getXpConcedido() + "\n" +
            "═══════════════════════════════════════════════════════════════\n";
        printComDelay(bloco);
    }

    public static void narrarDerrota(Astronauta astronauta) {
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
    }

    public static void narrarVitoriaFinal(Astronauta astronauta) {
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
    }

    // ========= UTILITÁRIOS ========= //

    private static void printComDelay(String texto) {
        System.out.println(texto);
        Utilidades.tempoDeTexto();
    }
}