package Motor;


import Entidades.Monstros.*;
import Interfaces.*;
import Itens.*;
import java.util.ArrayList;
import java.util.List;

import Combate.AtaqueContaminante;
import Combate.AtaqueDimensional;
import Combate.AtaqueParadoxal;
import Combate.HabilidadeAprisionar;
import Combate.HabilidadeEspelhoTemporal;
import Combate.HabilidadeFragmentar;

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

    private static final List<AcaoDeCombate> ACOES_SLIME = List.of(new AtaqueContaminante(), new HabilidadeFragmentar());
    private static final List<AcaoDeCombate> ACOES_PARADOXO = List.of(new AtaqueParadoxal(), new HabilidadeEspelhoTemporal());
    private static final List<AcaoDeCombate> ACOES_4D = List.of(new AtaqueDimensional(), new HabilidadeAprisionar());

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
            List<String> lootSlime = new ArrayList<>(List.of("GosmaX", "Fragmento Estelar", "Tubo de Oxigênio"));
            if (dificuldade.equals(Dificuldade.DIFICIL)) {
                lootSlime.add("Fragmento Estelar"); // Adiciona um extra no difícil
            }

            monstros.add(new AlienSlime(
                    "Slime Mutante Lvl" + i,
                    (int)((60 + (i * 15)) * mod),
                    (int)((12 + (i * 5)) * mod),
                    (int)((20 + (i * 5)) * mod),
                    (int)((60 + (i * 15)) * mod),
                    new ArmaGosmaX("Gosma Corrosiva", 8 + i, 0),
                    lootSlime,
                    ACOES_SLIME)); // Passa a lista de ações compartilhadas

            // Monstro 2: Paradoxo
            List<String> lootParadoxo = new ArrayList<>(List.of("Distorcedor a Vácuo", "Projetor de Ilusões"));
            if (dificuldade.equals(Dificuldade.DIFICIL)) {
                lootParadoxo.add("Distorcedor a Vácuo");
            }

            monstros.add(new AlienParadoxo(
                    "Alien Paradoxo Lvl" + i,
                    (int)((70 + (i * 20)) * mod),
                    (int)((15 + (i * 6)) * mod),
                    (int)((25 + (i * 6)) * mod),
                    (int)((70 + (i * 20)) * mod),
                    new ArmaIlusao("Orbe da Confusão", 11 + i, 0),
                    lootParadoxo,
                    ACOES_PARADOXO));

            // Monstro 3: 4D
            if (i >= 2) {
                List<String> loot4D = new ArrayList<>(List.of("Lâmina de Antimatéria", "Cubo Hipergeométrico", "Tubo de Oxigênio"));
                if (dificuldade.equals(Dificuldade.DIFICIL)) {
                    loot4D.add("Lâmina de Antimatéria");
                }

                monstros.add(new Alien4D(
                        "Alien 4D Lvl" + i,
                        (int)((80 + (i * 15)) * mod),
                        (int)((18 + (i * 7)) * mod),
                        (int)((30 + (i * 7)) * mod),
                        (int)((80 + (i * 15)) * mod),
                        new ArmaGeometrica("Tesserato Afiado", 14 + i, 0),
                        loot4D,
                        ACOES_4D));
            }

            fases.add(new FaseDeCombate(i, cenario, monstros));
        }
        return fases;
    }
}