public class Main {
    public static void main(String[] args) {
        Astronauta astronauta = new Astronauta("Capitã Fernanda", 120, 25, 0, 0, 100, 100);

        AlienSlime alienSlime = new AlienSlime("Alien Slime", 90, 25, 50, false);
        AlienParadoxo alienParadoxo = new AlienParadoxo("Alien Paradoxo", 100, 20, 40, false);
        Alien4D alien4D = new Alien4D("Alien 4D", 100, 30, 60, false);

        Item tuboOxigenio = new Item("Tubo de Oxigênio");

        Experiencia exp = new Experiencia(astronauta);

        boolean jogoAtivo = true;

        // Função para imprimir com delay
        java.util.function.Consumer<String> printComDelay = texto -> {
            System.out.println(texto);
            tempoDeTexto();
        };

        // Introdução
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

        printComDelay.accept("         U M A   A V E N T U R A   E S P A C I A L\n");
        System.out.println(" ");
        printComDelay.accept("A bordo da nave Zênite, a corajosa " + astronauta.nome + " da AEB (Agência Espacial Brasileira) é lançada para uma galáxia desconhecida após uma colisão inesperada com um buraco de minhoca.\n");
        printComDelay.accept("Ao emergirem, a tripulação se depara com um buraco negro supermassivo, cuja gravidade é capaz de dilacerar qualquer nave em instantes.\n");
        printComDelay.accept("Mas não estão sozinhos: seres alienígenas de forças inimagináveis começam a surgir, distorcendo o espaço e o tempo ao redor.\n");
        printComDelay.accept(astronauta.nome + " precisará de toda sua coragem e habilidades para derrotá-los e escapar da ameaça do buraco negro.\n");
        tempoDeTexto();

        astronauta.exibirStatus();
        tempoDeTexto();

        while (jogoAtivo) {

            // ===== ROUND 1 =====
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ___ ___ _ __ __ ___ _ ___  __    ___  __  _  _ __  _ __  ");
            System.out.println("| _,\\ _ \\ |  V  | __| | _ \\/__\\  | _ \\/__\\| || |  \\| | _\\ ");
            System.out.println("| v_/ v / | \\_/ | _|| | v / \\/ | | v / \\/ | \\/ | | ' | v |");
            System.out.println("|_| |_|_\\_|_| |_|___|_|_|_\\\\__/  |_|_\\\\__/ \\__/|_|\\__|__/ ");
            System.out.println(" ");
            System.out.println(" ");

            // Chegada Alien Slime
            printComDelay.accept("Alerta! Uma massa amorfa e translúcida emerge das sombras do espaço: " + alienSlime.nome + "!\n");
            printComDelay.accept("Seus tentáculos viscosos se movem rapidamente, prontos para contaminar tudo com radiação alienígena.\n");
            printComDelay.accept("Prepare-se, " + astronauta.nome + ", a batalha pela sobrevivência começa!\n");

            System.out.println(" ");
            System.out.println(" ");


            while (alienSlime.pontosDeVida > 0 && astronauta.pontosDeVida > 0) {
                exp.alterarNivel(astronauta);

                if (alienSlime.astronautaContaminado) {
                    astronauta.receberDano(astronauta, (int)(alienSlime.forca / 2));
                    printComDelay.accept("[-" + (int)(alienSlime.forca / 2) + " de vida da " + astronauta.nome + " pela radiação]\n");
                    alienSlime.astronautaContaminado = false;
                }

                astronauta.atacar(alienSlime);
                if (astronauta.soproUsado) {
                    astronauta.ganharExperiencia(astronauta.forca * 3);
                } else {
                    astronauta.ganharExperiencia(astronauta.forca);
                }

                if (alienSlime.pontosDeVida > 0) {
                    alienSlime.atacar(astronauta);
                    alienSlime.usarHabilidadeEspecial(astronauta);
                }

                if (astronauta.pontosDeVida <= 0) {
                    jogoAtivo = false;
                    break;
                }

                if (Math.random() < 0.1) {
                    astronauta.pegarItem(tuboOxigenio);
                }

                if (!astronauta.inventario.isEmpty()) {
                    astronauta.usarTuboOxigenio();
                }
            }

            if (astronauta.pontosDeVida > 0) {
                astronauta.ganharExperiencia(alienSlime.xpConcedido);

                String bloco =
                    "\n═══════════════════════════════════════════════════════════════\n" +
                    " 🛰️ Vitória! " + astronauta.nome + " reduziu o " + alienSlime.nome + " a uma poça viscosa.\n" +
                    " ▸ A gosma borbulhou e se dissolveu no chão metálico da nave,\n" +
                    "   deixando apenas o silêncio do espaço como testemunha.\n" +
                    " ➤ Experiência obtida: +" + alienSlime.xpConcedido + "\n" +
                    "═══════════════════════════════════════════════════════════════\n";

                printComDelay.accept(bloco);
            }


            imprimirStatus(astronauta, alienSlime);

            if (!jogoAtivo) break;

            // ===== ROUND 2 =====
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("  __  ___ __ _  _ __  _ __   __    ___  __  _  _ __  _ __  ");
            System.out.println("/' _/| __/ _] || |  \\| | _\\ /__\\  | _ \\/__\\| || |  \\| | _\\ ");
            System.out.println("`._`.| _| [/\\ \\/ | | ' | v | \\/ | | v / \\/ | \\/ | | ' | v |");
            System.out.println("|___/|___\\__/\\__/|_|\\__|__/ \\__/  |_|_\\\\__/ \\__/|_|\\__|__/ ");
            System.out.println(" ");
            System.out.println(" ");

            // Chegada Alien Paradoxo
            printComDelay.accept("O espaço se distorce em padrões impossíveis! Surge o " + alienParadoxo.nome + ", um ser que desafia a lógica e reflete seus ataques contra você!\n");
            printComDelay.accept("O ambiente parece dobrar-se sobre si mesmo, dificultando qualquer movimento.\n");
            printComDelay.accept(astronauta.nome + ", cada ação deve ser calculada com precisão: um erro pode ser fatal!\n");

            System.out.println(" ");
            System.out.println(" ");

            while (alienParadoxo.pontosDeVida > 0 && astronauta.pontosDeVida > 0) {
                exp.alterarNivel(astronauta);

                if (alienParadoxo.refletido) {
                    astronauta.atacar(astronauta);
                    printComDelay.accept("[O ataque da " + astronauta.nome + " foi refletido contra ela mesma]\n");
                    alienParadoxo.refletido = false;
                } else {
                    astronauta.atacar(alienParadoxo);
                    if (astronauta.soproUsado) {
                        astronauta.ganharExperiencia(astronauta.forca * 3);
                    } else {
                        astronauta.ganharExperiencia(astronauta.forca);
                    }
                }

                if (alienParadoxo.pontosDeVida > 0) {
                    alienParadoxo.atacar(astronauta);
                    alienParadoxo.usarHabilidadeEspecial(astronauta);
                }

                if (astronauta.pontosDeVida <= 0) {
                    jogoAtivo = false;
                    break;
                }

                if (Math.random() < 0.15) {
                    astronauta.pegarItem(tuboOxigenio);
                }

                if (!astronauta.inventario.isEmpty()) {
                    astronauta.usarTuboOxigenio();
                }
            }

            if (astronauta.pontosDeVida > 0) {
                astronauta.ganharExperiencia(alienParadoxo.xpConcedido);

                String bloco =
                    "\n═══════════════════════════════════════════════════════════════\n" +
                    " ⏳ O paradoxo foi vencido! " + astronauta.nome + " resistiu ao colapso do impossível.\n" +
                    " ▸ As fendas no espaço-tempo começaram a se fechar lentamente,\n" +
                    "   e o eco distorcido da criatura desapareceu no vazio.\n" +
                    " ➤ Experiência obtida: +" + alienParadoxo.xpConcedido + "\n" +
                    "═══════════════════════════════════════════════════════════════\n";

                printComDelay.accept(bloco);
            }


            imprimirStatus(astronauta, alienParadoxo);

            if (!jogoAtivo) break;

            // ===== ROUND 3 =====
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" _____ ___ ___  ______ _ ___  __    ___  __  _  _ __  _ __  ");
            System.out.println("|_   _| __| _ \\/ _/ __| | _ \\/__\\  | _ \\/__\\| || |  \\| | _\\ ");
            System.out.println("  | | | _|| v / \\_| _|| | v / \\/ | | v / \\/ | \\/ | | ' | v |");
            System.out.println("  |_| |___|_|_\\\\__/___|_|_|_\\\\__/  |_|_\\\\__/ \\__/|_|\\__|__/ ");
            System.out.println(" ");
            System.out.println(" ");
            // Chegada Alien 4D
            printComDelay.accept("Uma presença indescritível atravessa dimensões: " + alien4D.nome + "!\n");
            printComDelay.accept("Sua forma se move em direções que a mente humana não consegue compreender, torcendo o espaço-tempo ao redor da nave.\n");
            printComDelay.accept("Ele tenta puxar " + astronauta.nome + " para o buraco negro, drenando sua energia vital.\n");
            printComDelay.accept("Esta é a batalha final, " + astronauta.nome + ". Derrote-o ou será engolida pelo abismo do buraco negro!\n");

            System.out.println(" ");
            System.out.println(" ");

            while (alien4D.pontosDeVida > 0 && astronauta.pontosDeVida > 0) {
                exp.alterarNivel(astronauta);

                if (!alien4D.aprisionado) {
                    astronauta.atacar(alien4D);
                    if (astronauta.soproUsado) {
                        astronauta.ganharExperiencia(astronauta.forca * 3);
                    } else {
                        astronauta.ganharExperiencia(astronauta.forca);
                    }
                } else {
                    alien4D.aprisionado = false;
                }

                if (alien4D.pontosDeVida > 0) {
                    alien4D.atacar(astronauta);
                    alien4D.usarHabilidadeEspecial(astronauta);
                }

                if (astronauta.pontosDeVida <= 0) {
                    jogoAtivo = false;
                    break;
                }

                if (Math.random() < 0.2) {
                    astronauta.pegarItem(tuboOxigenio);
                }

                if (!astronauta.inventario.isEmpty()) {
                    astronauta.usarTuboOxigenio();
                }
            }

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
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            break;
        }

        if (astronauta.pontosDeVida <= 0) {
            // Derrota
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("  ____                         ___                    ");
            System.out.println(" / ___| __ _ _ __ ___   ___   / _ \\__   _____ _ __    ");
            System.out.println("| |  _ / _` | '_ ` _ \\ / _ \\ | | | \\ \\ / / _ \\ '__|   ");
            System.out.println("| |_| | (_| | | | | | |  __/ | |_| |\\ V /  __/ |_ _ _ ");
            System.out.println(" \\____|\\__,_|_| |_| |_|\\___|  \\___/  \\_/ \\___|_(_|_|_)");
            System.out.println(" ");
            System.out.println(astronauta.nome + " não resistiu aos poderes dos Aliens...\n");
            System.out.println("A nave Zênite foi engolida pelo buraco negro, e a galáxia desconhecida permanece inexplorada.\n");
        } else {
            // Vitória
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ____                 _                    ");
            System.out.println("|  _ \\ __ _ _ __ __ _| |__   ___ _ __  ___ ");
            System.out.println("| |_) / _` | '__/ _` | '_ \\ / _ \\ '_ \\/ __|");
            System.out.println("|  __/ (_| | | | (_| | |_) |  __/ | | \\__ \\");
            System.out.println("|_|   \\__,_|_|  \\__,_|_.__/ \\___|_| |_|___/");
            System.out.println(" ");
            System.out.println(astronauta.nome + " derrotou todos os alienígenas e escapou do buraco negro!\n");
            System.out.println("A galáxia desconhecida agora está segura graças à coragem da nossa heroína.\n");
        }
        
        System.out.println(" ");
        System.out.println(" ");
        imprimirStatus(astronauta, alien4D);
    }

    public static void tempoDeTexto() {
        try {
            Thread.sleep(Config.VELOCIDADE_TEXTO);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void imprimirStatus(Astronauta astronauta, Personagem alien) {
        System.out.println("              STATUS ATUAL");
        astronauta.exibirStatus();
        alien.exibirStatus();
        tempoDeTexto();
    }

    // Função auxiliar para gerar barras
    public static String gerarBarra(int valor, int maximo, int tamanho) {
        int preenchidos = (int) ((double) valor / maximo * tamanho);
        StringBuilder barra = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            if (i < preenchidos) {
                barra.append("█"); // cheio
            } else {
                barra.append("░"); // vazio
            }
        }
        return barra.toString();
    }
}