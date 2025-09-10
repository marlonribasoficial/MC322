public class ArmaLuzNegra extends Arma {

    public ArmaLuzNegra(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Lâmina que emite luz escura e drena energia do inimigo.");
    }

    @Override
    // Calcula o dano do ataque (com arma ou sem)
    public int atacarComArma(Personagem atacante, Personagem alvo) {
        int danoTotal;

        if (Math.random() < 0.5) { // 50% de usar arma
            danoTotal = atacante.forca + this.getDano();
            System.out.printf("🌑 %s dispara um feixe sombrio de %s em %s, causando %d de dano!\n\n",
                                atacante.getNome(), this.getNome(), alvo.getNome(), danoTotal);
            Main.tempoDeTexto();
            return danoTotal;
        } else {
            System.out.printf("🚀 %s ataca %s com força %d!\n\n", atacante.getNome(), alvo.getNome(), atacante.getForca());
            Main.tempoDeTexto();
            return atacante.getForca(); // apenas a força normal
        }
    }
}