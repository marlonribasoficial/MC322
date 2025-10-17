package Combatentes;

import Entidades.Heroi.Astronauta;
import Entidades.Monstros.AlienSlime;
import Interfaces.AcaoDeCombate;
import Interfaces.Combatente;
import Interfaces.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class HeroiTest {

    private Astronauta heroi;
    private AlienSlime monstro;

    @BeforeEach
    void setUp() {
        heroi = new Astronauta("Astronauta de Teste", 100, 15, 1, 0, 100, 100, 100, null, 0.5);
        List<Item> lootTable = new ArrayList<>();
        monstro = new AlienSlime("Slime de Teste", 50, 5, 10, 50, null, lootTable);
    }

    @Test
    public void testReceberDano() {
        int vidaInicial = heroi.getPontosDeVida();
        int dano = 10;
        heroi.receberDano(dano);
        assertEquals(vidaInicial - dano, heroi.getPontosDeVida());
    }

    @Test
    public void testAtacarMonstro() {
        int vidaInicialMonstro = monstro.getPontosDeVida();
        AcaoDeCombate acaoEscolhida = heroi.escolherAcao(monstro);
        acaoEscolhida.executar(heroi, monstro);
        assertTrue(monstro.getPontosDeVida() < vidaInicialMonstro, "A vida do monstro deveria diminuir após o ataque.");
    }

    @Test
    void testHeroiCombatente() {
        Astronauta heroi = new Astronauta("Astronauta de Teste", 100, 15, 1, 0, 100, 100, 100, null, 0.5);
        assertTrue(heroi instanceof Combatente, "A classe Heroi (e suas filha) deve implementar a interface Combatente.");
    }
}