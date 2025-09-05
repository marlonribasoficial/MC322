import java.util.List;

public abstract class Monstro extends Personagem {
    int xpConcedido;
    List<Arma> listaDeArmasParaLargar;

    public Monstro(String nome, int pontosDeVida, int forca, int xpConcedido, Arma arma, List<Arma> listaDeArmasParaLargar) {
        super(nome, pontosDeVida, forca, arma);
        this.xpConcedido = xpConcedido;
        this.listaDeArmasParaLargar = listaDeArmasParaLargar;
    }

    // Imprime as informações do personagem
    @Override
    public void exibirStatus() {
        String linha = "========================================";
        System.out.println("\n" + linha);
        System.out.printf("| 👾 Nome: %-32s\n", this.nome);
        System.out.printf("| 💖 Pontos de Vida: %-11s %3d\n", Main.gerarBarra(this.pontosDeVida, 120, 10), this.pontosDeVida);
        System.out.printf("| ⚔️ Força: %-28d\n", this.forca);
        System.out.printf("| ⭐ XP concedida: %-20d\n", this.xpConcedido);
        System.out.println(linha + "\n");
        Main.tempoDeTexto();
    }

    public Arma largaArma(List<Arma> listaDeArmasParaLargar) {
        
    }

    public abstract void usarHabilidadeEspecial(Personagem alvo);

}