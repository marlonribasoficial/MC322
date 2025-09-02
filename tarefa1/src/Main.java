public class Main {
    public static void main(String[] args) {
        Astronauta astronauta = new Astronauta("Capitã Fernanda", 120, 30, 0, 0, 100, 100);

        AlienSlime alienSlime = new AlienSlime("Alien Slime", 90, 25, 50, false);
        AlienParadoxo alienParadoxo = new AlienParadoxo("Alien Paradoxo", 100, 20, 40, false);
        Alien4D alien4D = new Alien4D("Alien 4D", 100, 30, 60, false);

        Item tuboOxigenio = new Item("Tubo de Oxigênio");

        Experiencia exp = new Experiencia(astronauta);

        long tempo = 3000;

        // adicionar um atributo de maxima vida em todos os personagens, apenas nos concretos

        // imprimir uma introducao da historia
        // exibir o status do astronauta de uma maneira elegante

        // para subir para o nivel 1: 50 xp
        //      - ganha 10 de vida
        //      - ganha 15 de oxigenio
        //      - ganha 15 de traje espacial

        // para subir para o nivel 2: 80 xp
        //      - ganha 20 de vida
        //      - ganha 15 de oxigenio
        //      - ganha 15 de traje espacial

        // para subir para o nivel 3: 120 xp
        //      - ganha 30 de vida
        //      - ganha 15 de oxigenio
        //      - ganha 15 de traje espacial

        // Flag para controle do jogo
        boolean jogoAtivo = true;

        while (jogoAtivo) { 

            System.out.println("========================================\n");
            System.out.println("---- PRIMEIRO ROUND ----\n");
            
            // anunciar a chegada do monstro
            System.out.println("O " + alienSlime.nome + " apareceu!\n");

            Main.tempoDeTexto(tempo);

            while (alienSlime.pontosDeVida > 0 && astronauta.pontosDeVida > 0) {
                // astronauta ataca
                // monstro ataca

                exp.alterarNivel(astronauta);

                if (alienSlime.astronautaContaminado) {
                    astronauta.receberDano(astronauta, (int)(alienSlime.forca / 2));
                    System.out.println("[-" + (int)(alienSlime.forca / 2) + " de pontos de vida da " + astronauta.nome + " pela radiação]\n");
                    alienSlime.astronautaContaminado = false;
                }

                Main.tempoDeTexto(tempo);

                astronauta.atacar(alienSlime);
                if (astronauta.soproUsado) {
                    astronauta.ganharExperiencia(astronauta.forca * 3);
                } else {
                    astronauta.ganharExperiencia(astronauta.forca);
                }

                Main.tempoDeTexto(tempo);

                if (alienSlime.pontosDeVida > 0) {
                    alienSlime.atacar(astronauta);
                    alienSlime.usarHabilidadeEspecial(astronauta);
                }

                Main.tempoDeTexto(tempo);

                if (astronauta.pontosDeVida <= 0) {
                    jogoAtivo = false;
                    break;
                }

                // Pegar um tubo de oxigênio
                if (Math.random() < 0.1) {
                    astronauta.pegarItem(tuboOxigenio);
                }

                // Usar tubo de oxigênio (se tiver)
                if (!astronauta.inventario.isEmpty()) {
                    astronauta.usarTuboOxigenio();
                }
            }

            if (astronauta.pontosDeVida > 0) {
                astronauta.ganharExperiencia(alienSlime.xpConcedido);
                System.out.println("****************");
                System.out.println("A " + astronauta.nome + " acaba de ganhar " + alienSlime.xpConcedido + " de experiência apos derrotar o " + alienSlime.nome + ".");
                System.out.println("****************");
            }

            // exibir o status do astronauta e do alien
            System.out.println("========================================");
            astronauta.exibirStatus();
            System.out.println("========================================");
            alienSlime.exibirStatus();

            if (!jogoAtivo) break;







            System.out.println("========================================\n");
            System.out.println("---- SEGUNDO ROUND ----\n");

            // anunciar a chegada do monstro
            System.out.println("O " + alienParadoxo.nome + " apareceu!\n");

            Main.tempoDeTexto(tempo);

            while (alienParadoxo.pontosDeVida > 0 && astronauta.pontosDeVida > 0) {
                // astronauta ataca
                // monstro ataca

                exp.alterarNivel(astronauta);

                if (alienParadoxo.refletido) {
                    astronauta.atacar(astronauta);
                    System.out.println("O ataque da " + astronauta.nome + " foi refletido contra ela mesma!\n");
                    alienParadoxo.refletido = false;
                } else {
                    astronauta.atacar(alienParadoxo);
                    if (astronauta.soproUsado) {
                        astronauta.ganharExperiencia(astronauta.forca * 3);
                    } else {
                        astronauta.ganharExperiencia(astronauta.forca);
                    }
                }

                Main.tempoDeTexto(tempo);

                if (alienParadoxo.pontosDeVida > 0) {
                    alienParadoxo.atacar(astronauta);
                    alienParadoxo.usarHabilidadeEspecial(astronauta);
                }

                Main.tempoDeTexto(tempo);

                if (astronauta.pontosDeVida <= 0) {
                    jogoAtivo = false;
                    break;
                }

                // Pegar um tubo de oxigênio
                if (Math.random() < 0.15) {
                    astronauta.pegarItem(tuboOxigenio);
                }

                // Usar tubo de oxigênio (se tiver)
                if (!astronauta.inventario.isEmpty()) {
                    astronauta.usarTuboOxigenio();
                }
            }
            
            if (astronauta.pontosDeVida > 0) {
                astronauta.ganharExperiencia(alienParadoxo.xpConcedido);
                System.out.println("****************");
                System.out.println("A " + astronauta.nome + " acaba de ganhar " + alienParadoxo.xpConcedido + " de experiência apos derrotar o " + alienParadoxo.nome + ".");
                System.out.println("****************");
            }

            // exibir o status do astronauta e do alien
            System.out.println("========================================");
            astronauta.exibirStatus();
            System.out.println("========================================");
            alienParadoxo.exibirStatus();

            if (!jogoAtivo) break;






            
            System.out.println("========================================\n");
            System.out.println("---- TERCEIRO ROUND ----\n");

            // anunciar a chegada do monstro
            System.out.println("O " + alien4D.nome + " apareceu!\n");

            Main.tempoDeTexto(tempo);

            while (alien4D.pontosDeVida > 0 && astronauta.pontosDeVida > 0) {
                // astronauta ataca
                // monstro ataca

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

                Main.tempoDeTexto(tempo);

                if (alien4D.pontosDeVida > 0) {
                    alien4D.atacar(astronauta);
                    alien4D.usarHabilidadeEspecial(astronauta);
                }

                Main.tempoDeTexto(tempo);

                if (astronauta.pontosDeVida <= 0) {
                    jogoAtivo = false;
                    break;
                }

                // Pegar um tubo de oxigênio
                if (Math.random() < 0.2) {
                    astronauta.pegarItem(tuboOxigenio);
                }

                // Usar tubo de oxigênio (se tiver)
                if (!astronauta.inventario.isEmpty()) {
                    astronauta.usarTuboOxigenio();
                }
            }
            if (astronauta.pontosDeVida > 0) {
                astronauta.ganharExperiencia(alien4D.xpConcedido);
                System.out.println("****************");
                System.out.println("A " + astronauta.nome + " acaba de ganhar " + alien4D.xpConcedido + " de experiência apos derrotar o " + alien4D.nome + ".");
                System.out.println("****************");
            }

            // exibir o status do astronauta e do alien
            System.out.println("========================================");
            astronauta.exibirStatus();
            System.out.println("========================================");
            alien4D.exibirStatus();
            

            break;
        }

        System.out.println("========================================");
        if (astronauta.pontosDeVida <= 0) {
            System.out.println("\nGAME OVER! O astronauta não resistiu...");
        } else {
            System.out.println("\nPARABÉNS! O astronauta venceu todos os alienígenas!");
        }
    }

    private static void tempoDeTexto(long tempo) {
        try {
            Thread.sleep(tempo); // pausa de 1,5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}