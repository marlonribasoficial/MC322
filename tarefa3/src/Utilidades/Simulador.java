package Utilidades;
import Armas.Arma;
import Heroi.Astronauta;
import Monstros.Alien4D;
import Monstros.Monstro;
import Personagem.Personagem;

public class Simulador {

    public static boolean simularCombate(Astronauta astronauta, Monstro inimigo, Item tubo) {
        boolean turnoAstronauta = true;

        while (astronauta.getVida() > 0 && inimigo.getVida() > 0) {

            // --- EFEITOS ATIVOS ---
            if (astronauta.getContaminado()) {
                int dano = inimigo.getForca() / 2;
                astronauta.receberDano(dano);
                System.out.printf("☣️ %s sofre %d de dano pela contaminação!\n\n", astronauta.getNome(), dano);
                astronauta.setContaminado(false); // reset
            }

            if (turnoAstronauta) {
                if (astronauta.getAprisionado()) {
                    System.out.printf("🌀 %s está aprisionado e perde o turno!\n\n", astronauta.getNome());
                    astronauta.setAprisionado(false); // reset
                } else {
                    Personagem alvoAtual = inimigo; // alvo normal
                    boolean refletido = astronauta.getRefletido();

                    if (refletido) {
                        alvoAtual = astronauta; // ataque refletido
                        astronauta.setRefletido(false); // reset
                    }

                    astronauta.atacar(alvoAtual);
                    astronauta.ganharExperiencia((astronauta.getForca())/2);
                }
            } else {
                if (inimigo.getVida() > 0) {
                    inimigo.atacar(astronauta);
                    if (!(inimigo instanceof Alien4D)) {
                        inimigo.usarHabilidadeEspecial(astronauta);
                    }
                }
            }

            // Chance de pegar item
            if (Math.random() < 0.2) astronauta.pegarItem(tubo);
            if (!astronauta.inventario.isEmpty()) astronauta.usarTuboOxigenio();

            turnoAstronauta = !turnoAstronauta; // alterna turno
        }

        if (astronauta.getVida() <= 0) return false;

        astronauta.ganharExperiencia(inimigo.getXpConcedido() / 3);

        // Drop de arma
        if (Math.random() < 0.5) {
            Arma drop = inimigo.largaArma();
            if (drop != null) {
                System.out.printf("🎁 %s dropou a arma %s!\n", inimigo.getNome(), drop.getNome());
                astronauta.equiparArma(drop);
            }
        }

        return true;
    }
}
