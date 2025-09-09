
public abstract class Heroi extends Personagem {
    protected int nivelAtual;
    protected int exp;
    protected int expProximoNivel;
    protected int sorte;

    public Heroi(String nome,
                int pontosDeVida,
                int forca,
                int nivelAtual,
                int exp,
                Arma arma,
                int expProximoNivel,
                int sorte) {
        super(nome, pontosDeVida, forca, arma);
        this.nivelAtual = nivelAtual;
        this.exp = exp;
        this.expProximoNivel = expProximoNivel;
        this.sorte = sorte;
    }

    // GETTERS
    // Depois conferir se está sendo útil

    public int getNivel() {
        return nivelAtual;
    }

    public int getExp() {
        return exp;
    }

    public int getExpProximoNivel() {
        return expProximoNivel;
    }

    public void equiparArma(Arma novaArma) {
        // troca arma do heroi, respeitando o nivel minimo requerido pela arma
    }

    // MÉTODOS ABSTRATOS

    @Override
    public abstract void exibirStatus();

    public abstract void usarHabilidadeEspecial(Personagem alvo); // deve ser relacionado com a sorte do heroi 

}