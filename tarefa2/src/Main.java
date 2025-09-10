import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Criando a heroína
        Astronauta astronauta = new Astronauta(
            "Capitã Fernanda", 
            120,
            25,
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
            imprimirTituloFase(fase);

            for (Monstro monstro : fase.getMonstros()) {
                // Narrador mostra chegada
                Narrador.narrarChegada(monstro, "Surge {monstro}, vindo das profundezas do espaço!");

                jogoAtivo = simularCombate(astronauta, monstro, tuboOxigenio);

                if (!jogoAtivo) break;

                // Narrador mostra vitória
                Narrador.narrarVitoria(astronauta, monstro, "O inimigo foi derrotado e desapareceu no vazio cósmico.");
            }
            if (!jogoAtivo) break;
        }

        // Encerramento (usa Narrador)
        if (astronauta.getVida() > 0) {
            Narrador.narrarVitoriaFinal(astronauta);
        } else {
            Narrador.narrarDerrota(astronauta);
        }
    }

    // ======= MÉTODOS AUXILIARES ======= //

    private static boolean simularCombate(Astronauta astronauta, Monstro inimigo, Item tubo) {
        while (astronauta.getVida() > 0 && inimigo.getVida() > 0) {

            astronauta.atacar(inimigo);
            astronauta.ganharExperiencia(astronauta.getForca());

            if (inimigo.getVida() > 0) {
                inimigo.atacar(astronauta);
                inimigo.usarHabilidadeEspecial(astronauta);
            }

            if (Math.random() < 0.2) astronauta.pegarItem(tubo);
            if (!astronauta.inventario.isEmpty()) astronauta.usarTuboOxigenio();

            imprimirStatus(astronauta, inimigo);
        }

        if (astronauta.getVida() <= 0) return false;

        astronauta.ganharExperiencia(inimigo.getXpConcedido());

        // Drop de arma (aqui pode continuar direto ou também mover pro Narrador se quiser)
        if (Math.random() < 0.5) {
            Arma drop = inimigo.largaArma();
            System.out.printf("🎁 %s dropou a arma %s!\n", inimigo.getNome(), drop.getNome());
            astronauta.equiparArma(drop);
        }

        return true;
    }

    private static void imprimirTituloFase(Fase f) {
        System.out.println("\n════════════════════════════════════════════");
        System.out.printf("🌌 FASE %d — Ambiente: %s\n", f.getNivel(), f.getAmbiente());
        System.out.println("════════════════════════════════════════════\n");
        tempoDeTexto();
    }

    public static void imprimirStatus(Astronauta astronauta, Personagem inimigo) {
        astronauta.exibirStatus();
        inimigo.exibirStatus();
    }

    public static void tempoDeTexto() {
        try {
            Thread.sleep(Config.VELOCIDADE_TEXTO);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String gerarBarra(int valor, int maximo, int tamanho) {
        int preenchidos = (int) ((double) valor / maximo * tamanho);
        StringBuilder barra = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            barra.append(i < preenchidos ? "█" : "░");
        }
        return barra.toString();
    }
}
