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

    public Alien4D(String nome, int pontosDeVida, int forca, int xpConcedido, boolean aprisionado) {
        super(nome, pontosDeVida, forca, xpConcedido);
        this.aprisionado = aprisionado;
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.printf("🌀 %s atravessa dimensões e ataca %s causando %d de dano!\n", this.nome, alvo.nome, this.forca);
        Main.tempoDeTexto();
        alvo.receberDano(alvo, forca);

        // Só tenta aprisionar se estiver com pouca vida
        if (pontosDeVida < 35) {
            usarHabilidadeEspecial(alvo);
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.3) { // aumentada de 0.2 para 0.3
            System.out.printf("🌀 %s aprisiona %s no vácuo dimensional!\n", this.nome, alvo.nome);
            Main.tempoDeTexto();
            System.out.printf("❌ %s perde o próximo turno!\n", alvo.nome);
            Main.tempoDeTexto();
            this.aprisionado = true;
        }
    }
}