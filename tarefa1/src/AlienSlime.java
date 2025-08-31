/* 
Atributos do Alien Slime:
    - Nome
	- Pontos de vida
	- Força
    - Experiência concedida
*/

public class AlienSlime extends Monstro {

    public AlienSlime(String nome, int pontosDeVida, int forca, double xpConcedido) {
        super(nome, pontosDeVida, forca, xpConcedido);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println("O " + this.nome + " arremessa uma gosma radioativa contra a " + alvo.nome + "!");

        alvo.receberDano(alvo, forca);

        if (Math.random() < 0.8) {
            System.out.println("A " + alvo.nome + " é contaminado pela radioatividade e começará a enfraquecer... Perde " + (int)(forca / 5) + " de vida no próximo turno.");

        }
        // aplicar dano no herói na main
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.3) {
            System.out.println("Com um movimento grotesco, o " + this.nome + " se fragmenta em duas massas e recupera 25% de sua vida!");
            pontosDeVida = (int)(pontosDeVida + pontosDeVida / 4);
        }
    }
}