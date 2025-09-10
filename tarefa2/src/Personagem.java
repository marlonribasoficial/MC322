public abstract class Personagem {
    protected String nome;
    protected int pontosDeVida;
    protected int forca;
    protected Arma arma;

    public Personagem(String nome,
                    int pontosDeVida,
                    int forca,
                    Arma arma) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
    }

    // Getters
    public String getNome() { return nome; }
    public int getVida() { return pontosDeVida; }
    public int getForca() { return forca; }
    public Arma getArma() { return arma; }

    // Reduz os pontos de vida com base no dano recebido
    public void receberDano(int dano) {
        this.pontosDeVida -= dano;
        if (this.pontosDeVida < 0) this.pontosDeVida = 0;
    }

    // Cura a vida
    public abstract void curar(int quantidade);

    // Imprime as informações do personagem
    public abstract void exibirStatus();

    // Método abstrato para ataque
    public abstract void atacar(Personagem alvo);
}