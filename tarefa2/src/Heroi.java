public abstract class Heroi extends Personagem {
    int nivel;
    double exp;
    double expProximoNivel;
    int sorte;

    public Heroi(String nome, int pontosDeVida, int forca, int nivel, double exp, Arma arma, double expProximoNivel, int sorte) {
        super(nome, pontosDeVida, forca, arma);
        this.nivel = nivel;
        this.exp = exp;
        this.expProximoNivel = expProximoNivel;
        this.sorte = sorte;
    }

    public void ganharExperiencia(int ataque) {
        this.exp += (int)ataque/2;
    }

    private void subirDeNivel() {
        //subir de nivel deve atualizar a exp necessaria p/ o proximo nivel e fortalecer os atibutos atuais do heroi
    }

    public void equiparArma(Arma novaArma) {
        // troca arma do heroi, respeitando o nivel minimo requerido pela arma
    }

    // Imprime as informações do personagem
    @Override
    public abstract void exibirStatus();


    // Método abstrato: 
    public abstract void usarHabilidadeEspecial(Personagem alvo); // deve ser relacionado com a sorte do heroi 

}