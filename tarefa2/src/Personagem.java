public abstract class Personagem {
    String nome;
    int pontosDeVida;
    int forca;
    Arma arma;

    // Construtor
    public Personagem(String nome, int pontosDeVida, int forca, Arma arma) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
    }   

    // Reduz os pontos de vida com base no dano recebido
    public void receberDano(Personagem alvo, int dano) {
        alvo.pontosDeVida = alvo.pontosDeVida - dano;
    }

    // Imprime as informações do personagem (nome, vida, etc.)
    public abstract void exibirStatus();

    // Método abstrato
    public abstract void atacar(Personagem alvo);

}