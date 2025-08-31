public class Main {
    public static void main(String[] args) {
        Astronauta astronauta = new Astronauta("Capitã Fernanda", 120, 25, 0, 0, 100, 100);

        AlienSlime alienSlime = new AlienSlime("Alien Slime", 70, 25, 0);
        AlienParadoxo alienParadoxo = new AlienParadoxo("Alien Paradoxo", 80, 20, 0);
        Alien4D alien4D = new Alien4D("Alien 4D", 80, 30, 0);

        // imprimir uma introducao da historia
        // exibir o status do heroi de uma maneira elegante

        // Flag para controle do jogo
        boolean jogoAtivo = true;

        while (jogoAtivo) { 
            while (alienSlime.pontosDeVida <= 0 && astronauta.pontosDeVida > 0) {

                if (astronauta.pontosDeVida <= 0) {
                    jogoAtivo = false;
                    break;
                }
            }

            if (!jogoAtivo) break;

            while (alienParadoxo.pontosDeVida <= 0 && astronauta.pontosDeVida > 0) {
            
                if (astronauta.pontosDeVida <= 0) {
                    jogoAtivo = false;
                    break;
                }
            }

            if (!jogoAtivo) break;

            while (alien4D.pontosDeVida <= 0 && astronauta.pontosDeVida > 0) {
                
                if (astronauta.pontosDeVida <= 0) {
                    jogoAtivo = false;
                    break;
                }
            }

            if (!jogoAtivo) break;
        }
    }
}