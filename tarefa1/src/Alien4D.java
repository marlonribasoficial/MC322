/* 
Atributos do Alien Slime:
    - Nome
	- Pontos de vida
	- Força
    - Experiência concedida
*/

public class Alien4D extends Monstro {

    public Alien4D(String nome, int pontosDeVida, int forca, double xpConcedido) {
        super(nome, pontosDeVida, forca, xpConcedido);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(this.nome + " atravessa dimensões e ataca " + alvo.nome + ", causando " + this.forca + " de dano!");
        alvo.receberDano(alvo, forca); 

        if (pontosDeVida < 35) {
            usarHabilidadeEspecial(alvo);
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.4) {
            System.out.println("Ah não! A " + alvo.nome + " foi aprisionado entre dimensões!");
            System.out.println(alvo.nome + " perde o próximo turno.");
            // aqui você aplicaria a lógica para pular o turno do herói
        }
    }
}