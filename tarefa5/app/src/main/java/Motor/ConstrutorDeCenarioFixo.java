package Motor;


import Interfaces.*;
import Itens.*;
import java.util.ArrayList;
import java.util.List;

import Combatentes.Monstros.*;
import Entidades.Monstros.Alien4D;
import Entidades.Monstros.AlienParadoxo;
import Entidades.Monstros.AlienSlime;
import Entidades.Monstros.Monstro;

/**
 * Gera fases com monstros e loot fixos, garantindo consistência 
 * entre diferentes execuções.
 */
public class ConstrutorDeCenarioFixo implements GeradorDeFases {

    private static final TipoCenario[] CENARIOS = {
            TipoCenario.LUA_SOMBRIA,
            TipoCenario.BASE_ABANDONADA,
            TipoCenario.BURACO_NEGRO
    };

    /**
     * Cria uma lista de fases com base na quantidade e dificuldade.
     * Cada fase contém monstros específicos e itens dropáveis.
     *
     * @param quantidadeDeFases Quantidade de fases a serem geradas.
     * @param dificuldade Nível de dificuldade que altera atributos e loot dos monstros.
     * @return Lista de fases geradas para o jogo.
     */
    @Override
    public List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade) {
        List<Fase> fases = new ArrayList<>();
        double mod = dificuldade.getModificador();

        for (int i = 1; i <= quantidadeDeFases; i++) {
            TipoCenario cenario = CENARIOS[(i - 1) % CENARIOS.length];
            List<Monstro> monstros = new ArrayList<>();

            // Monstro 1: Slime
            List<Item> lootSlime = new ArrayList<>();
            if (dificuldade.equals(Dificuldade.DIFICIL)) {
                lootSlime.add(new ArmaEstelar("Fragmento Estelar", (int)((15 + i) * mod), 1));
                lootSlime.add(new ItemGenerico("Tubo de Oxigênio"));
            }
            lootSlime.add(new ArmaGosmaX("GosmaX", (int)((10 + i) * mod), 0));
            lootSlime.add(new ArmaEstelar("Fragmento Estelar", (int)((15 + i) * mod), 1));
            lootSlime.add(new ItemGenerico("Tubo de Oxigênio"));
            
            monstros.add(new AlienSlime(
                    "Slime Mutante Lvl" + i,
                    (int)((60 + (i * 15)) * mod),
                    (int)((12 + (i * 5)) * mod),
                    (int)((20 + (i * 5)) * mod),
                    (int)((60 + (i * 15)) * mod),
                    new ArmaGosmaX("Gosma Corrosiva", 8 + i, 0),
                    lootSlime));

            // Monstro 2: Paradoxo
            List<Item> lootParadoxo = new ArrayList<>();
            if (dificuldade.equals(Dificuldade.DIFICIL)) {
                lootParadoxo.add(new ArmaVacuosa("Distorcedor a Vácuo", (int)((20 + i) * mod), 2));
            }
            lootParadoxo.add(new ArmaVacuosa("Distorcedor a Vácuo", (int)((20 + i) * mod), 2));
            lootParadoxo.add(new ArmaIlusao("Projetor de Ilusões", (int)((18 + i) * mod), 1));

            monstros.add(new AlienParadoxo(
                    "Alien Paradoxo Lvl" + i,
                    (int)((70 + (i * 20)) * mod),
                    (int)((15 + (i * 6)) * mod),
                    (int)((25 + (i * 6)) * mod),
                    (int)((70 + (i * 20)) * mod),
                    new ArmaIlusao("Orbe da Confusão", 11 + i, 0),
                    lootParadoxo));

            // Monstro 3: 4D
            if (i >= 2) {
                List<Item> loot4D = new ArrayList<>();
                if (dificuldade.equals(Dificuldade.DIFICIL)) {
                    loot4D.add(new ArmaLuzNegra("Lâmina de Antimatéria", (int)((25 + i) * mod), 3));
                    loot4D.add(new ItemGenerico("Tubo de Oxigênio"));
                }
                loot4D.add(new ArmaLuzNegra("Lâmina de Antimatéria", (int)((25 + i) * mod), 3));
                loot4D.add(new ArmaGeometrica("Cubo Hipergeométrico", (int)((22 + i) * mod), 2));
                loot4D.add(new ItemGenerico("Tubo de Oxigênio"));

                monstros.add(new Alien4D(
                        "Alien 4D Lvl" + i,
                        (int)((80 + (i * 15)) * mod),
                        (int)((18 + (i * 7)) * mod),
                        (int)((30 + (i * 7)) * mod),
                        (int)((80 + (i * 15)) * mod),
                        new ArmaGeometrica("Tesserato Afiado", 14 + i, 0),
                        loot4D));
            }

            fases.add(new FaseDeCombate(i, cenario, monstros));
        }
        return fases;
    }
}