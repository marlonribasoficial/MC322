/* 
Atributos do Alien Slime:
    - Nome
	- Pontos de vida
	- Força
    - Experiência concedida
    - Astronauta contaminado
*/

public class AlienSlime extends Monstro {
    boolean astronautaContaminado;

    public AlienSlime(String nome, int pontosDeVida, int forca, double xpConcedido, boolean astronautaContaminado) {
        super(nome, pontosDeVida, forca, xpConcedido);
        this.astronautaContaminado = astronautaContaminado;
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println("O " + this.nome + " arremessa uma gosma radioativa contra a " + alvo.nome + "!");

        alvo.receberDano(alvo, forca);

        if (Math.random() < 0.5) {
            System.out.println("A " + alvo.nome + " é contaminado pela radioatividade e começará a enfraquecer... Perde " + (int)(forca / 2) + " de vida no próximo turno.");
            this.astronautaContaminado = true;
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.4) {
            System.out.println("Com um movimento grotesco, o " + this.nome + " se fragmenta em duas massas e recupera 25% de sua vida!");
            pontosDeVida = (int)(pontosDeVida + pontosDeVida / 4);

            if (this.pontosDeVida > 70) this.pontosDeVida = 70;
        }
    }
}