public class Experiencia {
    Astronauta alvo;

    // Construtor
    public Experiencia(Astronauta alvo) {
        this.alvo = alvo;
    }

    public void alterarNivel(Astronauta alvo) {
        if (alvo.exp >= 80 && alvo.nivel < 1) {
            subirNivel(alvo, 1, 10, 15, 15);
        } else if (alvo.exp >= 160 && alvo.nivel < 2) {
            subirNivel(alvo, 2, 20, 15, 15);
        } else if (alvo.exp >= 240 && alvo.nivel < 3) {
            subirNivel(alvo, 3, 30, 15, 15);
        }
    }

    private void subirNivel(Astronauta alvo, int novoNivel, int vidaGanha, int oxigenioGanho, int trajeGanho) {
        alvo.nivel = novoNivel;
        alvo.pontosDeVida = Math.min(alvo.pontosDeVida + vidaGanha, 120);
        alvo.oxigenio = Math.min(alvo.oxigenio + oxigenioGanho, 100);
        alvo.trajeEspacial = Math.min(alvo.trajeEspacial + trajeGanho, 100);

        String linha = "========================================";
        String titulo = "         ✨✨✨ LEVEL UP! ✨✨✨";

        System.out.println("\n" + linha);
        System.out.printf("%-36s\n", titulo);
        System.out.println(linha + "\n");
        Main.tempoDeTexto();
    }
}
