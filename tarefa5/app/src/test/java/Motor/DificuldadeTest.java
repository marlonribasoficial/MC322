package Motor;

import Entidades.Monstros.Monstro;
import Interfaces.Fase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DificuldadeTest {

    private ConstrutorDeCenarioFixo geradorDeFases;

    @BeforeEach
    void setUp() {
        geradorDeFases = new ConstrutorDeCenarioFixo();
    }

    @Test
    void testAtributos() {
        List<Fase> fasesFaceis = geradorDeFases.gerar(1, Dificuldade.FACIL);
        List<Fase> fasesDificeis = geradorDeFases.gerar(1, Dificuldade.DIFICIL);

        Monstro monstroFacil = ((FaseDeCombate) fasesFaceis.get(0)).getMonstros().get(0);
        Monstro monstroDificil = ((FaseDeCombate) fasesDificeis.get(0)).getMonstros().get(0);

        assertTrue(monstroDificil.getPontosDeVida() > monstroFacil.getPontosDeVida(),
                "O monstro na dificuldade DIFÍCIL deveria ter mais pontos de vida que no FÁCIL.");

        assertTrue(monstroDificil.getForca() > monstroFacil.getForca(),
                "O monstro na dificuldade DIFÍCIL deveria ter mais força que no FÁCIL.");

        assertTrue(monstroDificil.getXpConcedido() > monstroFacil.getXpConcedido(),
                "O monstro na dificuldade DIFÍCIL deveria conceder mais XP que no FÁCIL.");
    }
}