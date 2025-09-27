package Motor;


import Entidades.Monstros.*;
import Interfaces.*;
import Itens.*;
import java.util.ArrayList;
import java.util.List;

public class ConstrutorDeCenarioFixo implements GeradorDeFases {

    private static final TipoCenario[] CENARIOS = {
            TipoCenario.LUA_SOMBRIA,
            TipoCenario.BASE_ABANDONADA,
            TipoCenario.BURACO_NEGRO
    };

    @Override
    public List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade) {
        List<Fase> fases = new ArrayList<>();
        double mod = dificuldade.getModificador();

        for (int i = 1; i <= quantidadeDeFases; i++) {
            TipoCenario cenario = CENARIOS[(i - 1) % CENARIOS.length];
            List<Monstro> monstros = new ArrayList<>();

            // Monstro 1: Slime
            List<Item> lootSlime = new ArrayList<>();
            lootSlime.add(new ArmaGosmaX("GosmaX", 10 + i, 1));
            lootSlime.add(new ArmaEstelar("Fragmento Estelar", 15 + i, 2));
            lootSlime.add(new ItemGenerico("Tubo de Oxigênio"));
            
            monstros.add(new AlienSlime(
                    "Slime Mutante Lvl" + i,
                    (int)((50 + (i * 15)) * mod),
                    (int)((12 + (i * 5)) * mod),
                    (int)((20 + (i * 5)) * mod),
                    (int)((50 + (i * 15)) * mod),
                    new ArmaGosmaX("Gosma Corrosiva", 8 + i, 0),
                    lootSlime));

            // Monstro 2: Paradoxo
            List<Item> lootParadoxo = new ArrayList<>();
            lootParadoxo.add(new ArmaVacuosa("Distorcedor a Vácuo", 20 + i, 2));
            lootParadoxo.add(new ArmaIlusao("Projetor de Ilusões", 18 + i, 2));

            monstros.add(new AlienParadoxo(
                    "Alien Paradoxo Lvl" + i,
                    (int)((60 + (i * 20)) * mod),
                    (int)((15 + (i * 6)) * mod),
                    (int)((25 + (i * 6)) * mod),
                    (int)((60 + (i * 20)) * mod),
                    new ArmaIlusao("Orbe da Confusão", 11 + i, 0),
                    lootParadoxo));

            // Monstro 3: 4D
            if (i >= 2) {
                List<Item> loot4D = new ArrayList<>();
                loot4D.add(new ArmaLuzNegra("Lâmina de Antimatéria", 25 + i * 2, 3));
                loot4D.add(new ArmaGeometrica("Cubo Hipergeométrico", 22 + i * 2, 3));
                loot4D.add(new ItemGenerico("Tubo de Oxigênio"));

                monstros.add(new Alien4D(
                        "Alien 4D Lvl" + i,
                        (int)((75 + (i * 15)) * mod),
                        (int)((18 + (i * 7)) * mod),
                        (int)((30 + (i * 7)) * mod),
                        (int)((75 + (i * 15)) * mod),
                        new ArmaGeometrica("Tesserato Afiado", 14 + i, 0),
                        loot4D));
            }

            fases.add(new FaseDeCombate(i, cenario, monstros));
        }
        return fases;
    }
}