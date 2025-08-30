package tarefa1.src;

class AlienSlime extends Monstro {

    public AlienSlime(String nome, int pontosDeVida, int forca, double xpConcedido) {
        super(nome, pontosDeVida, forca, xpConcedido);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.printf("%s ataca com uma gosma radioativa!", nome);
        alvo.receberDano(alvo, forca);

        if (Math.random() < 0.8) {
            System.out.printf("%s foi contaminado! Perde %d de vida no próximo turno.", alvo.nome, (int)(forca / 5));
        }
        // aplicar dano no herói na main
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.3) {
            System.out.printf("%s se dividiu! Recupera 25% de vida.", nome);
            pontosDeVida = (int)(pontosDeVida + pontosDeVida / 4);
        }
    }
}