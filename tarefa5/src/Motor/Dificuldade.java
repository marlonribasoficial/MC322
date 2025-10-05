package Motor;

/**
 * Enumeração dos níveis de dificuldade do jogo.
 * Cada nível possui um modificador que altera atributos de monstros e recompensas.
 */
public enum Dificuldade {
    FACIL(0.8),
    NORMAL(1.0),
    DIFICIL(1.2);

    private final double modificador;

    Dificuldade(double modificador) {
        this.modificador = modificador;
    }
    
    /**
     * Retorna o modificador associado ao nível de dificuldade.
     *
     * @return modificador como {@code double}
     */
    public double getModificador() {
        return modificador;
    }
}
