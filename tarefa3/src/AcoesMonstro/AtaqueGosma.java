package AcoesMonstro;

import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;
import Personagem.Personagem;
import Utilidades.Utilidades;

/**
 * Alien Slime lança gosma radioativa, com chance de contaminar.
 */
public class AtaqueGosma implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (!(usuario instanceof Personagem) || !(alvo instanceof Personagem)) return;

        Personagem slime = (Personagem) usuario;
        Personagem inimigo = (Personagem) alvo;

        int dano = slime.getForca();
        System.out.printf("🟢 %s arremessa gosma radioativa em %s!\n\n",
                slime.getNome(), inimigo.getNome());
        inimigo.receberDano(dano);

        if (Math.random() < 0.5) {
            int danoContaminacao = dano / 2;
            System.out.printf("☣️ %s foi contaminado e perderá %d de vida no próximo turno!\n\n",
                    inimigo.getNome(), danoContaminacao);
            inimigo.setContaminado(true);
        }

        Utilidades.tempoDeTexto();
    }
}