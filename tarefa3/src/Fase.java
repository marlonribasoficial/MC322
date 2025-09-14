import java.util.List;

public class Fase {
    private int nivel;
    private String ambiente;
    private List<Monstro> monstros;

    public Fase(int nivel,
                String ambiente,
                List<Monstro> monstros) {
        this.nivel = nivel;
        this.ambiente = ambiente;
        this.monstros = monstros;
    }

    // Getters
    public int getNivel() { return nivel; }
    public String getAmbiente() { return ambiente; }
    public List<Monstro> getMonstros() { return monstros; }

    public void exibirResumo() {
        System.out.printf("🌌 Fase %d: %s [%d monstros]\n", nivel, ambiente, monstros.size());
    }
}
