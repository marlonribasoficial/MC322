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
    ArrayList<Item> inventario = new ArrayList<>();

    public Astronauta(String nome, int pontosDeVida, int forca, int nivel, double exp, int trajeEspacial, int oxigenio) {
        super(nome, pontosDeVida, forca, nivel, exp);
        this.trajeEspacial = trajeEspacial;
        this.oxigenio = oxigenio;
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println("A " + this.nome + " ataca o " + alvo.nome + " com força " + this.forca + "!");
        alvo.receberDano(alvo, this.forca);

        if (Math.random() < 0.2) soproCriogenico(alvo);

    }

    // Ataca usando um supro criogênico
    public void soproCriogenico(Personagem alvo) {
        if (this.oxigenio >= 40) {
                System.out.println("O QUE FOI ISSO? A astronauta " + this.nome + " acaba de atacar o "
                + alvo.nome + " com seu mega potente sopro criogênico de força " + this.forca * 3 + "!!!");
                alvo.receberDano(alvo, this.forca * 3);
                this.oxigenio -= 40;

                // Caso se estourar o limite
                if (this.oxigenio < 0) this.oxigenio = 0;
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.3) {
            // Super defesa com o traje espacial
            if (trajeEspacial > 50) {
                System.out.println(this.nome + " ativa o modo de defesa máxima do traje espacial!");
                this.pontosDeVida += 30;
                this.trajeEspacial -= 30; // gasta energia do traje
                this.oxigenio -= 10; // gasta oxigênio

                // Casos se estoura o limite
                if (this.oxigenio < 0) this.oxigenio = 0;

                // definir o maximo de pontos de vida que vai ter
                if (this.pontosDeVida > 100) this.pontosDeVida = 100;

            } else {
                System.out.println("A " + this.nome + " não tem energia suficiente para usar a habilidade especial de traje espacial!");
            }
        }
    }

    // Pegar item
    public void pegarItem(Item item) {
        if (Math.random() < 0.2) {
            inventario.add(item);
            System.out.println(this.nome + " pegou um " + item.getNome() + "!");
        }
    }

    // Usar tubo de oxigênio (se existir no inventário)
    public void usarTuboOxigenio() {
        for (Item item : inventario) {
            if (item.getNome().equals("Tubo de Oxigênio")) {
                oxigenio += 60;
                if (oxigenio > 100) oxigenio = 100; // limite

                inventario.remove(item);
                System.out.println(this.nome + " usou um Tubo de Oxigênio! Oxigênio agora em " + oxigenio + "%");
                return;
            }
        }
        System.out.println(this.nome + " não tem nenhum Tubo de Oxigênio para usar!");
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Oxigênio: " + this.oxigenio + "%");
        System.out.println("Energia do Traje Espacial: " + this.oxigenio + "%");
    }
}
