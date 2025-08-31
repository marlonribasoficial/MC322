/* 
Atributos do Alien Paradoxo:
    - Nome
	- Pontos de vida
	- Força
    - Experiência concedida
    - Refletido
*/

public class AlienParadoxo extends Monstro {
    boolean refletido;

    public AlienParadoxo(String nome, int pontosDeVida, int forca, double xpConcedido, boolean refletido) {
        super(nome, pontosDeVida, forca, xpConcedido);
        this.refletido = refletido;
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
            if (alvo.pontosDeVida > 120) alvo.pontosDeVida = 120;
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.2) {
            System.out.println(this.nome + " ativa o espelho temporal!");
            System.out.println("O próximo ataque da " + alvo.nome + " será refletido contra ela mesmo!");
            this.refletido = true;
        }
    }
}
