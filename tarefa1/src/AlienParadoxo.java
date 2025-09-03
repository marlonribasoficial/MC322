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

    public AlienParadoxo(String nome, int pontosDeVida, int forca, int xpConcedido, boolean refletido) {
        super(nome, pontosDeVida, forca, xpConcedido);
        this.refletido = refletido;
    }

    @Override
    public void atacar(Personagem alvo) {
        if (Math.random() < 0.5) {
            System.out.printf("⚡ %s desfere um ataque caótico contra %s causando %d de dano!\n", this.nome, alvo.nome, this.forca);
            Main.tempoDeTexto();
            alvo.receberDano(alvo, forca);
        } else {
            int cura = 15;
            System.out.printf("✨ %s entra em paradoxo e cura %s em %d pontos de vida!\n", this.nome, alvo.nome, cura);
            Main.tempoDeTexto();
            alvo.pontosDeVida += cura;
            if (alvo.pontosDeVida > 120) alvo.pontosDeVida = 120;
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.3) {
            System.out.printf("🪞 %s ativa o Espelho Temporal!\n", this.nome);
            Main.tempoDeTexto();
            System.out.printf("⚠️ O próximo ataque de %s será refletido contra ela mesma!\n", alvo.nome);
            Main.tempoDeTexto();
            this.refletido = true;
        }
    }
}
