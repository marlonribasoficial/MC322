public abstract class Personagem {
    protected  String nome;
    protected  int pontosDeVida;
    protected  int forca;
    protected  Arma arma;

    // protected para poder ser acessada pelas subclasses

    // Construtor
    public Personagem(String nome, int pontosDeVida, int forca, Arma arma) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = arma;
    }

    // Funções Getters
    // Depois conferir se está sendo útil
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return pontosDeVida;
    }

    public int getForca() {
        return forca;
    }

    public Arma getArma() {
        return arma;
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