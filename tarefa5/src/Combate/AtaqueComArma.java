package Combate;

import Entidades.Personagem;
import Interfaces.*;
import Itens.Arma;
import Util.Utilidades;

public class AtaqueComArma implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        if (usuario instanceof Personagem && ((Personagem) usuario).getArma() != null) {
            Personagem pUsuario = (Personagem) usuario;
            Arma arma = pUsuario.getArma();
            int danoTotal = pUsuario.getForca() + arma.getDano();

            System.out.printf("🔫 %s ataca com %s contra %s, causando %d de dano!\n\n",
                    usuario.getNome(), arma.getNome(), alvo.getNome(), danoTotal);
            Utilidades.tempoDeTexto();
            alvo.receberDano(danoTotal);
        } else {
            // Se chamado sem arma, executa um ataque físico normal
            new AtaqueFisico().executar(usuario, alvo);
        }
    }
}