public class ArmaIlusao extends Arma {

    public ArmaIlusao(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Artefato que cria ilusões e confunde o inimigo.");
    }
}