package Combate;

import Entidades.Heroi.Astronauta;
import Interfaces.*;
import Util.Utilidades;
import java.util.List;

/**
 * Ação de combate que permite ao {@link Astronauta} usar um item de cura.
 * Neste caso, o item é um "Tubo de Oxigênio", que restaura até 40% de oxigênio,
 * sem ultrapassar o limite máximo de 100%.
 */
public class AcaoUsarItem implements AcaoDeCombate {

    private final String nomeDoItem = "Tubo de Oxigênio";

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (!(usuario instanceof Astronauta)) { return; }

        Astronauta astronauta = (Astronauta) usuario;
        List<Item> inventario = astronauta.getInventario();

        // Procura o item no inventário
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getNome().equals(nomeDoItem)) {
                
                // Efeito do item
                int oxigenioAtual = astronauta.getOxigenio();
                int oxigenioRecuperado = 40;
                int novoOxigenio = Math.min(100, oxigenioAtual + oxigenioRecuperado);
                astronauta.setOxigenio(novoOxigenio);

                System.out.printf("💨 %s usou um %s! [Oxigênio agora em %d%%]\n\n", astronauta.getNome(), nomeDoItem, novoOxigenio);
                Utilidades.tempoDeTexto();

                // Remove o item do inventário
                inventario.remove(i);
                return;
            }
        }

        // Se chegou aqui, o item não foi encontrado
        System.out.printf("⚠️ %s tentou usar um %s, mas não tem nenhum!\n\n", astronauta.getNome(), nomeDoItem);
        Utilidades.tempoDeTexto();
    }
}