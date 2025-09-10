import java.util.ArrayList;
import java.util.List;

public class ConstrutorDeCenario {

    private static final String[] AMBIENTES = {
        "🌑 Lua Sombria",
        "🏚️ Base Abandonada",
        "🌀 Buraco Negro"
    };

    public static List<Fase> gerarFases(int nFases) {
        List<Fase> fases = new ArrayList<>();

        for (int i = 1; i <= nFases; i++) {
            String ambiente = AMBIENTES[(i - 1) % AMBIENTES.length];

            // Cria monstros da fase
            List<Monstro> monstros = new ArrayList<>();
            monstros.add(new AlienSlime(
                    "Slime Mutante Lvl" + i,
                    40 + (i * 10),       // Vida escala
                    10 + (i * 3),        // Força escala
                    20 + (i * 5),        // XP concedida
                    40 + (i * 10),       // Vida máxima
                    false,
                    null,                // sem arma inicial
                    new ArrayList<>()    // lista de armas que pode largar
            ));

            monstros.add(new AlienParadoxo(
                    "Alien Paradoxo Lvl" + i,
                    50 + (i * 12),
                    12 + (i * 4),
                    25 + (i * 6),
                    50 + (i * 12),
                    false,
                    null,
                    new ArrayList<>()
            ));

            // Se o nível for mais alto, adiciona Alien4D
            if (i >= 2) {
                monstros.add(new Alien4D(
                        "Alien 4D Lvl" + i,
                        60 + (i * 15),
                        15 + (i * 5),
                        30 + (i * 7),
                        60 + (i * 15),
                        false,
                        null,
                        new ArrayList<>()
                ));
            }

            fases.add(new Fase(i, ambiente, monstros));
        }

        return fases;
    }
}