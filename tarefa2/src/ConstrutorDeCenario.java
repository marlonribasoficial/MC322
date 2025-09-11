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


            List<Arma> armasSlime = new ArrayList<>();
            armasSlime.add(new ArmaGosmaX("Arma GosmaX", 5, 1));
            armasSlime.add(new ArmaEstelar("Arma Estelar", 12 + i, 1));
            Arma gosmaX = new ArmaGosmaX("GosmaX", 8 + i, 0);

            monstros.add(new AlienSlime(
                    "Slime Mutante Lvl" + i,
                    40 + (i * 10),       // Vida escala
                    10 + (i * 3),        // Força escala
                    20 + (i * 5),        // XP concedida
                    40 + (i * 10),       // Vida máxima
                    gosmaX,              // Arma inicial 
                    armasSlime    // lista de armas que pode largar
            ));


            List<Arma> armasParadoxo = new ArrayList<>();
            armasParadoxo.add(new ArmaVacuosa("Arma Vacuosa", 20 + i * 2, 2));
            armasParadoxo.add(new ArmaIlusao("Arma Ilusão", 16 + i, 2));
            Arma ilusao = new ArmaIlusao("Arma Ilusão", 13 + i, 0);

            monstros.add(new AlienParadoxo(
                    "Alien Paradoxo Lvl" + i,
                    50 + (i * 12),
                    12 + (i * 4),
                    25 + (i * 6),
                    50 + (i * 12),
                    ilusao,
                    armasParadoxo
            ));

            
            // Se o nível for mais alto, adiciona Alien4D
            if (i >= 2) {

                List<Arma> armas4D = new ArrayList<>();
                armas4D.add(new ArmaLuzNegra("Arma Luz Negra", 25 + i * 3, 3));
                armas4D.add(new ArmaGeometrica("Arma Geométrica", 17 + i, 2));
                Arma geometrica = new ArmaGeometrica("Arma Geométrica", 12 + i, 0);


                monstros.add(new Alien4D(
                        "Alien 4D Lvl" + i,
                        60 + (i * 15),
                        15 + (i * 5),
                        30 + (i * 7),
                        60 + (i * 15),
                        geometrica,
                        armas4D
                ));
            }

            fases.add(new Fase(i, ambiente, monstros));
        }

        return fases;
    }
}