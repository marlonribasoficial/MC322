/* 
Atributos do Alien Slime:
    - Nome
	- Pontos de vida
	- Força
    - Experiência concedida
    - Astronauta contaminado
*/

import java.util.List;

public class AlienSlime extends Monstro {
    boolean astronautaContaminado;

    public AlienSlime(String nome, int pontosDeVida, int forca, int xpConcedido, boolean astronautaContaminado, Arma arma, List<Arma> listaDeArmasParaLargar) {
        super(nome, pontosDeVida, forca, xpConcedido, arma, listaDeArmasParaLargar);
        this.astronautaContaminado = astronautaContaminado;
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.printf("🟢 %s arremessa uma gosma radioativa contra %s!\n\n", this.nome, alvo.nome);
        Main.tempoDeTexto();
        alvo.receberDano(alvo, forca);

        if (Math.random() < 0.5) {
            int danoContaminacao = (int)(forca / 2);
            System.out.printf("☣️ %s foi contaminada! Perderá %d de vida no próximo turno.\n\n", alvo.nome, danoContaminacao);
            Main.tempoDeTexto();
            this.astronautaContaminado = true;
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.4) {
            System.out.printf("💀 %s se fragmenta em duas massas e recupera 25%% da sua vida!\n\n", this.nome);
            Main.tempoDeTexto();
            pontosDeVida += pontosDeVida / 4;
            if (pontosDeVida > 70) pontosDeVida = 70;
        }
    }
}