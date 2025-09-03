public abstract class Personagem {
    String nome;
    int pontosDeVida; // podemos mudar o tipo de acordo com o que a gente for fazer
    int forca; // podemos mudar o tipo de acordo com o que a gente for fazer

    // Construtor
    public Personagem(String nome, int pontosDeVida, int forca) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
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