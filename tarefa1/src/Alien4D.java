class Alien4D extends Monstro {

    public Alien4D(String nome, int pontosDeVida, int forca, double xpConcedido) {
        super(nome, pontosDeVida, forca, xpConcedido);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.printf("%s ataca!\n", nome);
        alvo.receberDano(alvo, forca); 

        if (pontosDeVida < 35) {
            usarHabilidadeEspecial(alvo);
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.4) {
            System.out.printf("Ah não! %s está preso entre dimensões.\n", alvo.nome);
            System.out.printf("%s perde o turno.\n", alvo.nome);
            // pula a vez do herói
        }
    }
}