public abstract class Heroi extends Personagem {
    int nivel;
    double exp;

    public Heroi(String nome, int pontosDeVida, int forca, int nivel, double exp) {
        super(nome, pontosDeVida, forca);
        this.nivel = nivel;
        this.exp = exp;
    }

    public void ganharExperiencia(int ataque) {
        this.exp += (int)ataque/2;
    }

    // Imprime as informações do personagem
    @Override
    public abstract void exibirStatus();


    // Método abstrato: 
    public abstract void usarHabilidadeEspecial(Personagem alvo);
}
