public abstract class Heroi extends Personagem {
    protected int nivelAtual;
    protected int exp;
    protected int expProximoNivel;
    protected double sorte; // 0.0 a 1.0

    public Heroi(String nome, int pontosDeVida, int forca,
                 int nivelAtual, int exp, Arma arma,
                 int expProximoNivel, double sorte) {
        super(nome, pontosDeVida, forca, arma);
        this.nivelAtual = nivelAtual;
        this.exp = exp;
        this.expProximoNivel = expProximoNivel;
        this.sorte = sorte;
    }

    public int getNivel() { return nivelAtual; }
    public int getExp() { return exp; }
    public int getExpProximoNivel() { return expProximoNivel; }
    public double getSorte() { return sorte; }

    // Troca de arma respeitando nível mínimo
    public void equiparArma(Arma novaArma) {
        if (nivelAtual >= novaArma.getMinNivel()) {
            if (this.arma == null || this.arma.getDano() < novaArma.getDano()) {
            this.arma = novaArma;
            System.out.printf("🔄 %s equipou %s!\n", this.nome, novaArma.getNome());
            }
        } else {
            System.out.printf("❌ %s não tem nível suficiente para usar %s!\n",
                               this.nome, novaArma.getNome());
        }
    }

    public abstract void usarHabilidadeEspecial(Personagem alvo);
}