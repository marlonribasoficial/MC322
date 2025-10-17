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
        // Cria um herói com todos os parâmetros necessários
        heroi = new Astronauta("Astronauta de Teste", 100, 15, 1, 0, 100, 100, 100, null, 0.5);

        // Cria um monstro concreto para o teste
        List<Item> lootTable = new ArrayList<>();
        monstro = new AlienSlime("Slime de Teste", 50, 5, 10, 50, null, lootTable);
    }

    @Test
    public void testReceberDano() {
        int vidaInicial = monstro.getPontosDeVida(); // Nome correto do método
        int dano = 10;
        monstro.receberDano(dano);
        assertEquals(vidaInicial - dano, monstro.getPontosDeVida());
    }

    @Test
    public void testAtacarHeroi() {
        int vidaInicialHeroi = heroi.getPontosDeVida(); // Nome correto

        // Lógica de ataque correta
        AcaoDeCombate acaoMonstro = monstro.escolherAcao(heroi);
        acaoMonstro.executar(monstro, heroi);

        assertTrue(heroi.getPontosDeVida() < vidaInicialHeroi, "A vida do heroi deveria diminuir após o ataque.");
    }

    @Test
    void testMonstroLootavel() {
        List<Item> lootTableVazia = new ArrayList<>();
        AlienSlime monstro = new AlienSlime("Slime Teste", 50, 5, 10, 50, null, lootTableVazia);
        assertTrue(monstro instanceof Lootavel, "A classe Monstro (e suas filhas) deve implementar a interface Lootavel.");
    }

    @Test
    void testMonstroCombatente() {
        List<Item> lootTableVazia = new ArrayList<>();
        AlienSlime monstro = new AlienSlime("Slime Teste", 50, 5, 10, 50, null, lootTableVazia);
        assertTrue(monstro instanceof Combatente, "A classe Monstro (e suas filhas) deve implementar a interface Combatente.");
    }
}