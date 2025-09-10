import java.util.List;

/* 
Alien Slime:
- Atributos: Nome, Vida, Força, XP concedida, Estado de contaminação
- Ataques: joga gosma radioativa, chance de contaminar
- Habilidade Especial: se fragmenta e regenera parte da vida
*/

public class AlienSlime extends Monstro {
    private int pontosDeVidaMaximo;
    private boolean astronautaContaminado;

    public AlienSlime(String nome,
                    int pontosDeVida,
                    int forca,
                    int xpConcedido,
                    int pontosDeVidaMaximo,
                    boolean astronautaContaminado,
                    Arma arma,
                    List<Arma> listaDeArmasParaLargar) {
        super(nome, pontosDeVida, forca, xpConcedido, arma, listaDeArmasParaLargar);
        this.pontosDeVidaMaximo = pontosDeVidaMaximo;
        this.astronautaContaminado = astronautaContaminado;
    }

    // Getter
    public int getPontosDeVidaMaximo() { return pontosDeVidaMaximo; }
    public boolean isContaminado() { return astronautaContaminado; }

    // Setter
    public void setContaminado(boolean astronautaContaminado) {
        this.astronautaContaminado = astronautaContaminado;
    }
    public void setPontosDeVidaMax(int novaVidaMax) {
        this.pontosDeVidaMaximo = novaVidaMax;
    }

    @Override
    public void curar(int quantidade) {
        this.pontosDeVida += quantidade;
        if (this.pontosDeVida > pontosDeVidaMaximo) {
            this.pontosDeVida = pontosDeVidaMaximo;
        }
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.printf("🟢 %s arremessa uma gosma radioativa contra %s!\n\n", this.nome, alvo.getNome());
        Main.tempoDeTexto();
        alvo.receberDano(forca);

        if (Math.random() < 0.5) { // 50% de chance de contaminar
            int danoContaminacao = forca / 2;
            System.out.printf("☣️ %s foi contaminado! Perderá %d de vida no próximo turno.\n\n", alvo.getNome(), danoContaminacao);
            Main.tempoDeTexto();
            this.astronautaContaminado = true;
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.4) { // 40% de chance de regenerar
            System.out.printf("💀 %s se fragmenta em duas massas e recupera 25%% da sua vida!\n\n", this.nome);
            Main.tempoDeTexto();
            pontosDeVida += pontosDeVida / 4;
            if (pontosDeVida > pontosDeVidaMaximo) pontosDeVida = pontosDeVidaMaximo;
        }
    }
}