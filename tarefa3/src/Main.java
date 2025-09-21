import Entidades.Heroi.Astronauta;
import Entidades.Monstros.Monstro;
import Interfaces.*;
import Itens.Arma;
import Motor.*;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Preparação
        Astronauta astronauta = criarHeroina();
        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        List<Fase> fases = gerador.gerar(3);
        
        // Ínicio
        Narrador.introducao(astronauta);
        rodarJogo(astronauta, fases);

        // Conclusão
        exibirConclusao(astronauta);
    }

    // Instancia a astronauta
    private static Astronauta criarHeroina() {
        return new Astronauta(
                "Capitã Fernanda",
                120,
                30,
                0,
                0,
                100,
                120,
                100,
                null,
                0.3);
    }

    // Loop principal do jogo
    private static void rodarJogo(Astronauta astronauta, List<Fase> fases) {
        for (Fase faseAtual : fases) {
            executarFase(astronauta, faseAtual);
            
            // Se a astronauta morreu, o jogo acaba
            if (!astronauta.estaVivo()) {
                break;
            }
        }
    }

    // Executa uma fase
    private static void executarFase(Astronauta astronauta, Fase fase) {
        fase.iniciar(astronauta);
        astronauta.exibirStatus();

        FaseDeCombate faseDeCombate = (FaseDeCombate) fase;
        for (Monstro monstro : faseDeCombate.getMonstros()) {
            boolean heroiSobreviveu = iniciarCombate(astronauta, monstro);

            if (heroiSobreviveu) {
                processarPosCombate(astronauta, monstro);
            } else {
                return; // Sai da fase se a astronauta morrer
            }
        }
        
        // Exibe o status no final
        if (fase.isConcluida()) {
            System.out.println("Fase concluída! Status da heroína:");
            astronauta.exibirStatus();
        }
    }

    // Loop do combate
    private static boolean iniciarCombate(Astronauta astronauta, Monstro monstro) {
        Narrador.narrarChegada(monstro);

        while (astronauta.estaVivo() && monstro.estaVivo()) {
            executarTurnoHeroi(astronauta, monstro);
            if (!monstro.estaVivo()) break;
            executarTurnoMonstro(astronauta, monstro);
        }
        return astronauta.estaVivo();
    }

    // Turno da astronauta
    private static void executarTurnoHeroi(Astronauta astronauta, Monstro monstro) {
        if (astronauta.isAprisionado()) {
            System.out.printf("🌀 %s está aprisionado e perde o turno!\n\n", astronauta.getNome());
            astronauta.setAprisionado(false);
        } else {
            Combatente alvoHeroi = astronauta.isRefletido() ? astronauta : monstro;
            if (astronauta.isRefletido()) {
                System.out.printf("🪞 O ataque de %s foi refletido de volta!\n\n", astronauta.getNome());
                astronauta.setRefletido(false);
            }
            AcaoDeCombate acaoHeroi = astronauta.escolherAcao(alvoHeroi);
            acaoHeroi.executar(astronauta, alvoHeroi);
        }
    }

    // Turno dos aliens
    private static void executarTurnoMonstro(Astronauta astronauta, Monstro monstro) {
        AcaoDeCombate acaoMonstro = monstro.escolherAcao(astronauta);
        acaoMonstro.executar(monstro, astronauta);
    }
    
    // Lógica do pós combate
    private static void processarPosCombate(Astronauta astronauta, Monstro monstro) {
        Narrador.narrarVitoria(astronauta, monstro);
        astronauta.ganharExperiencia(monstro.getXpConcedido());

        if (monstro instanceof Lootavel) {
            Random random = new Random();
            if (random.nextDouble() < astronauta.getSorte() + 0.2) {
                Item loot = ((Lootavel) monstro).droparLoot();
                if (loot instanceof Arma) {
                    astronauta.equiparArma((Arma) loot);
                } else {
                    astronauta.adicionarItemAoInventario(loot);
                }
            }
        }
    }

    // Exibe a conclusão
    private static void exibirConclusao(Astronauta astronauta) {
        if (astronauta.estaVivo()) {
            Narrador.narrarVitoriaFinal(astronauta);
        } else {
            Narrador.narrarDerrota(astronauta);
        }
    }
}