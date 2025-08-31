/* 
Atributos do Alien Paradoxo:
    - Nome
	- Pontos de vida
	- Força
    - Experiência concedida
*/

public class AlienParadoxo extends Monstro {

    public AlienParadoxo(String nome, int pontosDeVida, int forca, double xpConcedido) {
        super(nome, pontosDeVida, forca, xpConcedido);
    }

    @Override
    public void atacar(Personagem alvo){
        // 50% de chance de atacar, 50% de chance de curar
        if (Math.random() < 0.5) {
            System.out.println(this.nome + " desfere um ataque caótico contra a " + alvo.nome + ", causando " + this.forca + " de dano!");
            alvo.receberDano(alvo, forca);

        } else {
            System.out.println("Ops! Em um paradoxo estranho, " + this.nome + " cura " + alvo.nome + " em 15 pontos de vida!");
            alvo.pontosDeVida = alvo.pontosDeVida + 15;
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.4) {
            System.out.println(this.nome + " ativa o espelho temporal!");
            System.out.println("O próximo ataque da " + alvo.nome + " será refletido contra ele mesmo!");
            // tratar isso na main
        }
    }
}
