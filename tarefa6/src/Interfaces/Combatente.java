package Interfaces;

/**
 * Define o comportamento de qualquer personagem que participa do combate (heróis ou monstros).
 */
public interface Combatente {

    /**
     * @return O nome do combatente.
     */
    String getNome();

    /**
     * @return {@code true} se o combatente ainda tiver pontos de vida, 
     *         {@code false} caso contrário.
     */
    boolean estaVivo();

    /**
     * Reduz os pontos de vida do combatente.
     *
     * @param dano Quantidade de dano recebido.
     */
    void receberDano(int dano);

    /**
     * Recupera pontos de vida do combatente.
     *
     * @param cura Quantidade de vida recuperada.
     */
    void receberCura(int cura);

    /**
     * Escolhe a ação que o combatente realizará em seu turno.
     *
     * @param alvo O combatente que será afetado.
     * @return A ação escolhida.
     */
    AcaoDeCombate escolherAcao(Combatente alvo);

    /**
     * @return A força base do combatente, usada para calcular dano.
     */
    int getForca();
}