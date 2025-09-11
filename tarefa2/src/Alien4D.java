import java.util.List;

/* 
Alien 4D:
- Atributos: Nome, Vida, Força, XP concedida, Estado de aprisionamento
- Ataques: atravessa dimensões causando dano
- Habilidade Especial: pode aprisionar o inimigo no vácuo (perde 1 turno)
*/

public class Alien4D extends Monstro {
    private int pontosDeVidaMaximo;

    public Alien4D(String nome,
                        int pontosDeVida,
                        int forca,
                        int xpConcedido,
                        int pontosDeVidaMaximo,
                        Arma arma,
                        List<Arma> listaDeArmasParaLargar) {
        super(nome, pontosDeVida, forca, xpConcedido, arma, listaDeArmasParaLargar);
        this.pontosDeVidaMaximo = pontosDeVidaMaximo;
    }

    // Getter
    @Override
    public int getPontosDeVidaMaximo() { return pontosDeVidaMaximo; }

    // Setter
    public void setPontosDeVidaMax(int novaVidaMax) {
        this.pontosDeVidaMaximo = novaVidaMax;
    }

    @Override
    public void atacar(Personagem alvo) {
        int danoTotal;

        // Ataque com arma, se tiver
        danoTotal = arma.atacarComArma(this, alvo);

        // se não houve ataque com arma
        if (danoTotal == this.forca) {
            System.out.printf("🌀 %s atravessa dimensões e ataca %s causando %d de dano!\n\n", 
                                this.nome, alvo.getNome(), danoTotal);
            Main.tempoDeTexto();
        }

        alvo.receberDano(danoTotal);

        if (pontosDeVida < 40) {
            usarHabilidadeEspecial(alvo);
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.25) { // 25% de chance
            System.out.printf("🌀 %s aprisiona %s no vácuo dimensional!\n", this.nome, alvo.getNome());
            Main.tempoDeTexto();
            System.out.printf("[%s perde o próximo turno]\n\n", alvo.getNome());
            Main.tempoDeTexto();
            alvo.setAprisionado(true);
        }
    }
}