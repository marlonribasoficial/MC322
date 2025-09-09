public class ArmaGeométrica extends Arma {

    public ArmaGeométrica(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Instrumento que gera padrões geométricos complexos e afiados.");
    }
}