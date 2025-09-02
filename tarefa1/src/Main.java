public class Main {
    public static void main(String[] args) {
        Astronauta astronauta = new Astronauta("Capitã Fernanda", 120, 30, 0, 0, 100, 100);

        AlienSlime alienSlime = new AlienSlime("Alien Slime", 90, 25, 0, false);
        AlienParadoxo alienParadoxo = new AlienParadoxo("Alien Paradoxo", 100, 20, 0, false);
        Alien4D alien4D = new Alien4D("Alien 4D", 100, 30, 0.0, false);

        Item tuboOxigenio = new Item("Tubo de Oxigênio");

        long tempo = 500;

        // adicionar um atributo de maxima vida em todos os personagens, apenas nos concretos

        // imprimir uma introducao da historia
        // exibir o status do astronauta de uma maneira elegante

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

                if (alienSlime.astronautaContaminado) {
                    astronauta.receberDano(astronauta, (int)(alienSlime.forca / 2));
                    System.out.println("[-" + (int)(alienSlime.forca / 2) + " de pontos de vida da " + astronauta.nome + " pela radiação]\n");
                    alienSlime.astronautaContaminado = false;
                }

                Main.tempoDeTexto(tempo);

                astronauta.atacar(alienSlime);

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

                if (alienParadoxo.refletido) {
                    astronauta.atacar(astronauta);
                    System.out.println("O ataque da " + astronauta.nome + " foi refletido contra ela mesma!\n");
                    alienParadoxo.refletido = false;
                } else {
                    astronauta.atacar(alienParadoxo);
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

                if (!alien4D.aprisionado) {
                    astronauta.atacar(alien4D);
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