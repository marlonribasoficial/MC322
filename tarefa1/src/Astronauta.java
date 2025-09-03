import java.util.ArrayList;

/* 
Atributos do Astronauta:
    - Nome
	- Pontos de vida
	- Força
    - Nível
    - Experiência
    - Traje Espacial
    - Oxigênio
*/

public class Astronauta extends Heroi {
    int trajeEspacial;
    int oxigenio;
    boolean soproUsado;
    ArrayList<Item> inventario = new ArrayList<>();

    public Astronauta(String nome, int pontosDeVida, int forca, int nivel, double exp, int trajeEspacial, int oxigenio) {
        super(nome, pontosDeVida, forca, nivel, exp);
        this.trajeEspacial = trajeEspacial;
        this.oxigenio = oxigenio;
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.printf("🚀 %s ataca %s com força %d!\n", this.nome, alvo.nome, this.forca);
        Main.tempoDeTexto();
        alvo.receberDano(alvo, this.forca);

        if (Math.random() < 0.2) { // 20% chance de sopro criogênico
            soproCriogenico(alvo);
        } else {
            usarHabilidadeEspecial(alvo);
        }
    }

    public void soproCriogenico(Personagem alvo) {
        if (this.oxigenio >= 40) {
            System.out.printf("❄️ O QUE FOI ISSO? %s usa o sopro criogênico em %s causando %d de dano!\n",
                    this.nome, alvo.nome, this.forca * 3);
            Main.tempoDeTexto();
            alvo.receberDano(alvo, this.forca * 3);
            this.oxigenio -= 40;
            if (this.oxigenio < 0) this.oxigenio = 0;
            this.soproUsado = true;
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.3) { // 30% chance
            if (trajeEspacial >= 40) {
                System.out.printf("🛡️ %s ativa o modo de defesa máxima do traje espacial!\n", this.nome);
                Main.tempoDeTexto();
                this.pontosDeVida += 30;
                if (this.pontosDeVida > 120) this.pontosDeVida = 120;

                this.trajeEspacial -= 30;
                this.oxigenio -= 10;
                if (this.oxigenio < 0) this.oxigenio = 0;
            } else {
                System.out.printf("⚠️ %s não tem energia suficiente para usar a habilidade especial do traje!\n", this.nome);
                Main.tempoDeTexto();
            }
        }
    }

    public void pegarItem(Item item) {
        if (Math.random() < 0.4) { // 40% chance
            inventario.add(item);
            System.out.printf("🎁 %s pegou um %s!\n", this.nome, item.getNome());
            Main.tempoDeTexto();
        }
    }

    public void usarTuboOxigenio() {
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getNome().equals("Tubo de Oxigênio")) {
                oxigenio += 40;
                if (oxigenio > 100) oxigenio = 100;

                inventario.remove(i);
                System.out.printf("💨 %s usou um Tubo de Oxigênio! Oxigênio agora em %d%%\n", this.nome, oxigenio);
                Main.tempoDeTexto();
                return;
            }
        }
        System.out.printf("⚠️ %s não tem nenhum Tubo de Oxigênio para usar!\n", this.nome);
        Main.tempoDeTexto();
    }

    @Override
    public void exibirStatus() {
        String linha = "========================================";
        System.out.println("\n" + linha);
        System.out.printf("| 🚀 Nome: %-32s\n", this.nome);
        System.out.printf("| 💖 Pontos de Vida: %-11s %3d\n", Main.gerarBarra(this.pontosDeVida, 120, 10), this.pontosDeVida);
        System.out.printf("| ⚔️ Força: %-28d\n", this.forca);
        System.out.printf("| 🆙 Nível: %-29d\n", this.nivel);
        System.out.printf("| ⭐ Experiência: %-24.1f\n", this.exp);
        System.out.printf("| 🫁 Oxigênio: %-18s %3d%%\n", Main.gerarBarra(this.oxigenio, 100, 10), this.oxigenio);
        System.out.printf("| 🛰️ Traje Espacial: %-13s %3d%%\n", Main.gerarBarra(this.trajeEspacial, 100, 10), this.trajeEspacial);
        System.out.println(linha + "\n");
        Main.tempoDeTexto();
    }
}
