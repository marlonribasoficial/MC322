package Interfaces;

/**
 * Indica que uma entidade pode fornecer recompensas (itens)
 * quando for derrotada.
 */
public interface Lootavel {
    /**
     * @param nivelFase O nível da fase atual, para calcular os atributos do item.
     * @param modDificuldade O modificador da dificuldade, para escalar os atributos.
     * @return O {@code Item} dropado, ou {@code null} se não houver loot.
     */
    Item droparLoot(int nivelFase, double modDificuldade);
}