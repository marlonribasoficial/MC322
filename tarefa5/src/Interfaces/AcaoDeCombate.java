package Interfaces;

/**
 * Representa uma ação que pode ser realizada durante o combate,
 * como atacar ou usar uma habilidade especial.
 */
public interface AcaoDeCombate {

    /**
     * Executa a ação de combate.
     *
     * @param usuario Combatente que está realizando a ação.
     * @param alvo Combatente que receberá o efeito da ação.
     */
    void executar(Combatente usuario, Combatente alvo);
}