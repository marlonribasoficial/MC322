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
    public List<Fase> gerar(int quantidadeDeFases) {
        List<Fase> fases = new ArrayList<>();

        for (int i = 1; i <= quantidadeDeFases; i++) {
            TipoCenario cenario = CENARIOS[(i - 1) % CENARIOS.length];
            List<Monstro> monstros = new ArrayList<>();

            // Monstro 1: Slime
            List<Item> lootSlime = new ArrayList<>();
            lootSlime.add(new ArmaGosmaX("GosmaX", 10 + i, 1));
            lootSlime.add(new ArmaEstelar("Fragmento Estelar", 15 + i, 2));
            lootSlime.add(new ItemGenerico("Tubo de Oxigênio"));
            
            monstros.add(new AlienSlime(
                    "Slime Mutante Lvl" + i, // Nome
                    50 + (i * 15), // Pontos de vida
                    12 + (i * 5), // Força
                    20 + (i * 5), // XP concedido
                    50 + (i * 15), // Pontos de vida máximo
                    new ArmaGosmaX("Gosma Corrosiva", 8 + i, 0), lootSlime)); // Arma

            // Monstro 2: Paradoxo
            List<Item> lootParadoxo = new ArrayList<>();
            lootParadoxo.add(new ArmaVacuosa("Distorcedor a Vácuo", 20 + i, 2));
            lootParadoxo.add(new ArmaIlusao("Projetor de Ilusões", 18 + i, 2));
            monstros.add(new AlienParadoxo(
                    "Alien Paradoxo Lvl" + i, // Nome
                    60 + (i * 20), // Pontos de vida
                    15 + (i * 6), // Força
                    25 + (i * 6), // XP concedido
                    60 + (i * 20), // Pontos de vida máximo
                    new ArmaIlusao("Orbe da Confusão", 11 + i, 0), lootParadoxo)); // Arma

            // Monstro 3: 4D (Aparece a partir da fase 2)
            if (i >= 2) {
                List<Item> loot4D = new ArrayList<>();
                loot4D.add(new ArmaLuzNegra("Lâmina de Antimatéria", 25 + i * 2, 3));
                loot4D.add(new ArmaGeometrica("Cubo Hipergeométrico", 22 + i * 2, 3));
                loot4D.add(new ItemGenerico("Tubo de Oxigênio"));
                monstros.add(new Alien4D(
                        "Alien 4D Lvl" + i, // Nome
                        75 + (i * 15), // Pontos de vida
                        18 + (i * 7), // Força
                        30 + (i * 7), // XP concedido
                        75 + (i * 15), // Pontos de vida máximo
                        new ArmaGeometrica("Tesserato Afiado", 14 + i, 0), loot4D)); // Arma
            }

            fases.add(new FaseDeCombate(i, cenario, monstros));
        }
        return fases;
    }
}