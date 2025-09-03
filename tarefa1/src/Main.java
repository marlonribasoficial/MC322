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
        printComDelay.accept("========================================");
        printComDelay.accept("      UMA AVENTURA ESPACIAL COMEÇA!\n");
        printComDelay.accept("Astronauta " + astronauta.nome + " se prepara para enfrentar alienígenas perigosos.\n");
        astronauta.exibirStatus();
        tempoDeTexto(); // pausa maior para a introdução

        while (jogoAtivo) {

            // ===== ROUND 1 =====
            printComDelay.accept("\n========================================");
            printComDelay.accept("        ---- PRIMEIRO ROUND ----");
            printComDelay.accept("        O " + alienSlime.nome + " apareceu!\n\n");

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
                printComDelay.accept("**************************************************************************");
                printComDelay.accept(astronauta.nome + " ganhou " + alienSlime.xpConcedido + " de experiência após derrotar o " + alienSlime.nome + "!");
                printComDelay.accept("**************************************************************************");
            }

            imprimirStatus(astronauta, alienSlime);

            if (!jogoAtivo) break;

            // ===== ROUND 2 =====
            printComDelay.accept("\n========================================");
            printComDelay.accept("        ---- SEGUNDO ROUND ----");
            printComDelay.accept("       O " + alienParadoxo.nome + " apareceu!\n");

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
                printComDelay.accept("**************************************************************************");
                printComDelay.accept(astronauta.nome + " ganhou " + alienParadoxo.xpConcedido + " de experiência após derrotar o " + alienParadoxo.nome + "!");
                printComDelay.accept("**************************************************************************");
            }

            imprimirStatus(astronauta, alienParadoxo);

            if (!jogoAtivo) break;

            // ===== ROUND 3 =====
            printComDelay.accept("\n========================================");
            printComDelay.accept("        ---- TERCEIRO ROUND ----");
            printComDelay.accept("          O " + alien4D.nome + " apareceu!\n");

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

            if (astronauta.pontosDeVida > 0) {
                astronauta.ganharExperiencia(alien4D.xpConcedido);
                printComDelay.accept("**************************************************************************");
                printComDelay.accept(astronauta.nome + " ganhou " + alien4D.xpConcedido + " de experiência após derrotar o " + alien4D.nome + "!");
                printComDelay.accept("**************************************************************************\n");
            }

            imprimirStatus(astronauta, alien4D);

            break;
        }

        printComDelay.accept("\n===================================================");
        if (astronauta.pontosDeVida <= 0) {
            printComDelay.accept("GAME OVER! O astronauta não resistiu...");
        } else {
            printComDelay.accept("PARABÉNS! O astronauta venceu todos os alienígenas!");
        }
        printComDelay.accept("===================================================\n");
    }

    public static void tempoDeTexto() {
        try {
            Thread.sleep(Config.VELOCIDADE_TEXTO);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void imprimirStatus(Astronauta astronauta, Personagem alien) {
        System.out.println("\n========================================");
        System.out.println("              STATUS ATUAL");
        System.out.println("========================================");
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