public class ArmaEstelar extends Arma {

    public ArmaEstelar(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Espada com fragmentos de estrelas cadentes.");
    }
}  