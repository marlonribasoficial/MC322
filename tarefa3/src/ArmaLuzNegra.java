public class ArmaLuzNegra extends Arma {

    public ArmaLuzNegra(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        String linha = "===============================================================================";
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Lâmina que emite luz escura e drena energia do inimigo");
        System.out.println(linha + "\n");
        Utilidades.tempoDeTexto();
    }

    @Override
    // Calcula o dano do ataque (com arma ou sem)
    public int atacarComArma(Personagem atacante, Personagem alvo) {
        int danoTotal;

        if (Math.random() < 0.5) { // 50% de usar arma
            danoTotal = atacante.forca + this.getDano();
            System.out.printf("🌑 %s dispara um feixe sombrio de %s em %s, causando %d de dano!\n\n",
                                atacante.getNome(), this.getNome(), alvo.getNome(), danoTotal);
            Utilidades.tempoDeTexto();
            return danoTotal;
        }
        
        return atacante.getForca();
    }
}