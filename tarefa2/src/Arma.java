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

    public abstract int atacarComArma(Personagem atacante, Personagem alvo);
}
