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

    public AlienSlime(String nome, int pontosDeVida, int forca, int xpConcedido, boolean astronautaContaminado) {
        super(nome, pontosDeVida, forca, xpConcedido);
        this.astronautaContaminado = astronautaContaminado;
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.printf("🟢 %s arremessa uma gosma radioativa contra %s!\n", this.nome, alvo.nome);
        Main.tempoDeTexto();
        alvo.receberDano(alvo, forca);

        if (Math.random() < 0.5) { // 50% chance de contaminação
            int danoContaminacao = (int)(forca / 2);
            System.out.printf("☣️ %s foi contaminada! Perderá %d de vida no próximo turno.\n", alvo.nome, danoContaminacao);
            Main.tempoDeTexto();
            this.astronautaContaminado = true;
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.4) { // 40% chance de fragmentação
            System.out.printf("💀 %s se fragmenta em duas massas e recupera 25%% da sua vida!\n", this.nome);
            Main.tempoDeTexto();
            pontosDeVida += pontosDeVida / 4;
            if (pontosDeVida > 70) pontosDeVida = 70;
        }
    }
}