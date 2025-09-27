package Motor;

public enum Dificuldade {
    FACIL(0.8),
    NORMAL(1.0),
    DIFICIL(1.2);

    private final double modificador;

    Dificuldade(double modificador) {
        this.modificador = modificador;
    }

    public double getModificador() {
        return modificador;
    }
}
