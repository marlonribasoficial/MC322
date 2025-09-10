import java.util.List;

/* 
Alien 4D:
- Atributos: Nome, Vida, Força, XP concedida, Estado de aprisionamento
- Ataques: atravessa dimensões causando dano
- Habilidade Especial: pode aprisionar o inimigo no vácuo (perde 1 turno)
*/
public class Alien4D extends Monstro {
    private boolean aprisionado;

    public Alien4D(String nome,
                    int pontosDeVida,
                    int forca,
                    int xpConcedido,
                    boolean aprisionado,
                    Arma arma,
                    List<Arma> listaDeArmasParaLargar) {
        super(nome, pontosDeVida, forca, xpConcedido, arma, listaDeArmasParaLargar);
        this.aprisionado = aprisionado;
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.printf("🌀 %s atravessa dimensões e ataca %s causando %d de dano!\n\n", this.nome, alvo.getNome(), this.forca);
        Main.tempoDeTexto();
        alvo.receberDano(forca);

        // Só tenta aprisionar se estiver com pouca vida
        if (pontosDeVida < 40) {
            usarHabilidadeEspecial(alvo);
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (Math.random() < 0.25) { // 25% de chance
            System.out.printf("🌀 %s aprisiona %s no vácuo dimensional!\n", this.nome, alvo.getNome());
            Main.tempoDeTexto();
            System.out.printf("[%s perde o próximo turno]\n\n", alvo.getNome());
            Main.tempoDeTexto();
            this.aprisionado = true;
        }
    }

    public boolean isAprisionado() {
        return aprisionado;
    }

    public void setAprisionado(boolean aprisionado) {
        this.aprisionado = aprisionado;
    }
}