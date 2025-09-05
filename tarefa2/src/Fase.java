import java.util.List;

public class Fase {
    int nivel;
    String ambiente;
    List<Monstro> monstros;

    public Fase(int nivel, String ambiente, List<Monstro> monstros) {
        this.nivel = nivel;
        this.ambiente = ambiente;
        this.monstros = monstros;
    }
}