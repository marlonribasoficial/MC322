public class ArmaGeometrica extends Arma {

    public ArmaGeometrica(String nome, int dano, int minNivel) {
        super(nome, dano, minNivel);
    }

    @Override
    public void exibirDescricao() {
        super.exibirDescricao();
        System.out.println("| 📝 Descrição: Instrumento que gera padrões geométricos complexos e afiados.");
    }

    @Override
    // Calcula o dano do ataque (com arma ou sem)
    public int atacarComArma(Personagem atacante, Personagem alvo) {
        int danoTotal;

        if (Math.random() < 0.5) { // 50% de usar arma
            danoTotal = atacante.forca + this.getDano();
            System.out.printf("📐 %s invoca formas geométricas afiadas e perfura %s com %s, causando %d de dano!\n\n", 
                                atacante.getNome(), alvo.getNome(), this.getNome(), danoTotal);         
            Main.tempoDeTexto();
            return danoTotal;
        }
        
        return atacante.getForca();
    }
}