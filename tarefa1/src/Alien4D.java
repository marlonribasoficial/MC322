/* 
Atributos do Alien Slime:
    - Nome
	- Pontos de vida
	- Força
    - Experiência concedida
    - Aprisionado
*/

public class Alien4D extends Monstro {
    boolean aprisionado;

    public Alien4D(String nome, int pontosDeVida, int forca, double xpConcedido, boolean aprisionado) {
        super(nome, pontosDeVida, forca, xpConcedido);
        this.aprisionado = aprisionado;
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(this.nome + " atravessa dimensões e ataca " + alvo.nome + ", causando " + this.forca + " de dano!\n");
        alvo.receberDano(alvo, forca); 

        if (pontosDeVida < 35) {
            usarHabilidadeEspecial(alvo);
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.2) {
            System.out.println("Ah não! A " + alvo.nome + " foi aprisionado entre dimensões!");
            System.out.println("[" + alvo.nome + " perde o próximo turno]\n");
            this.aprisionado = true;
        }
    }
}