public abstract class Heroi extends Personagem {
    int nivel;
    double exp;

    public Heroi(String nome, int pontosDeVida, int forca, int nivel, double exp) {
        super(nome, pontosDeVida, forca);
        this.nivel = nivel;
        this.exp = exp;
    }

    public void ganharExperiencia(int ataque) {
        this.exp = (int)ataque/2;
    }

    // Imprime as informações do personagem
    @Override
    public void exibirStatus() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Pontos de Vida: " + this.pontosDeVida);
        System.out.println("Força: " + this.forca);
        System.out.println("Nível: " + this.nivel);
        System.out.println("Experiência: " + this.exp);
    }

    // Método abstrato: 
    public abstract void usarHabilidadeEspecial(Personagem alvo);
}
