public abstract class Arma {
    private String nome;
    private int dano;
    private int minNivel;

    public Arma(String nome, int dano, int minNivel) {
        this.nome = nome;
        this.dano = dano;
        this.minNivel = minNivel;
    }

    // Getters
    public String getNome() { return nome; }
    public int getDano() { return dano; }
    public int getMinNivel() { return minNivel; }

    public void exibirDescricao() {
        String linha = "========================================";
        System.out.println("\n" + linha);
        System.out.printf("| 🗡️ Arma: %-32s\n", this.nome);
        System.out.printf("| ⚔️ Dano: %-32d\n", this.dano);
        System.out.printf("| 🔰 Nível mínimo: %-32d\n", this.minNivel);
        System.out.println(linha + "\n");
        Main.tempoDeTexto();
    }

    // Calcula o dano do ataque (com arma ou sem)
    public int atacarComArma(Personagem atacante, Personagem alvo) {
        if (Math.random() < 0.5) { // 50% de usar arma
            System.out.printf("💥 %s acerta um ataque crítico com %s!\n\n", atacante.getNome(), this.nome);
            Main.tempoDeTexto();
            return atacante.forca + this.dano;
        } else {
            System.out.printf("🚀 %s ataca %s com força %d!\n\n", atacante.getNome(), alvo.getNome(), atacante.getForca());
            Main.tempoDeTexto();
            return atacante.forca; // apenas a força normal
        }
    }
}
