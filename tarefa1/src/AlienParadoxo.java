class AlienParadoxo extends Monstro {

    public AlienParadoxo(String nome, int pontosDeVida, int forca, double xpConcedido) {
        super(nome, pontosDeVida, forca, xpConcedido);
    }

    @Override
    public void atacar(Personagem alvo){
        // 50% de chance de atacar, 50% de chance de curar
        if (Math.random() < 0.5) {
            System.out.printf("%s causa um dano caótico!\n", nome);
            alvo.receberDano(forca);

        } else {
            System.out.printf("Ops! %s inesperadamente cura %s.\n", nome, alvo.nome);
            alvo.pontosDeVida = alvo.pontosDeVida + 15;
        }

        // habilidade especial
        if (Math.random() < 0.3) {
            System.out.printf("%s ativa o espelho temporal!\n", nome);
            System.out.printf("O próximo ataque de %s será refletido!\n", alvo.nome);
        }

    }
}