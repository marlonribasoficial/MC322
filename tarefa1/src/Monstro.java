public abstract class Monstro extends Personagem {
    double xpConcedido; // Experiência que o monstro concede ao ser derrotado.

    public Monstro(String nome, int pontosDeVida, int forca, double xpConcedido) {
        super(nome, pontosDeVida, forca);
        this.xpConcedido = xpConcedido;
    }

    // Imprime as informações do personagem
    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Experiência concedida: " + this.xpConcedido);
    }

    public abstract void usarHabilidadeEspecial(Personagem alvo);

}