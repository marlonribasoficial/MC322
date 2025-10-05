import Entidades.Heroi.Astronauta;
import Entidades.Monstros.Monstro;
import Interfaces.*;
import Itens.Arma;
import Motor.*;
import Util.InputManager;
import Util.Menu;
import java.util.List;
import java.util.Random;


public class Main {

    public static void main(String[] args) {

        int opcaoMenu = 0;
        while (opcaoMenu != 4) {
            opcaoMenu = Menu.mostrarMenuPrincipal();

            switch (opcaoMenu) {
                case 1:

                    // Preparação
                    Dificuldade dificuldade = Menu.escolherDificuldade();
                    Astronauta astronauta = criarHeroina();
                    GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
                    List<Fase> fases = gerador.gerar(3, dificuldade);
                    
                    // Início
                    Narrador.introducao(astronauta);
                    rodarJogo(astronauta, fases, dificuldade);

                    // Conclusão
                    exibirConclusao(astronauta);
                    break;
                    
                case 2:
                    Menu.mostrarClasseHeroi();
                    break;

                case 3:
                    Menu.mostrarClassesMonstros();
                    break;

                case 4:
                    Menu.mostrarSaida();
                    InputManager.fecharScanner(); // fecha o scanner antes de sair
            }

        }
    }

    /**
     * Cria a heroína jogável com atributos iniciais.
     *
     * @return um objeto Astronauta já inicializado
     */
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

    /**
     * Executa o loop principal do jogo, percorrendo todas as fases.
     *
     * @param astronauta herói controlado pelo jogador
     * @param fases lista de fases a serem jogadas
     * @param dificuldade nível de dificuldade escolhido
     */
    private static void rodarJogo(Astronauta astronauta, List<Fase> fases, Dificuldade dificuldade) {
        for (Fase faseAtual : fases) {
            executarFase(astronauta, faseAtual, dificuldade);
            
            // Se a astronauta morreu, o jogo acaba
            if (!astronauta.estaVivo()) {
                break;
            }
        }
    }

    /**
     * Executa uma fase, incluindo a lógica de combates e conclusão.
     *
     * @param astronauta herói controlado pelo jogador
     * @param fase fase atual
     * @param dificuldade dificuldade do jogo
     */
    private static void executarFase(Astronauta astronauta, Fase fase, Dificuldade dificuldade) {
        fase.iniciar(astronauta);

        FaseDeCombate faseDeCombate = (FaseDeCombate) fase;
        for (Monstro monstro : faseDeCombate.getMonstros()) {
            if (!astronauta.isDesistente()) {
                boolean heroiSobreviveu = iniciarCombate(astronauta, monstro);

                if (heroiSobreviveu) {
                    processarPosCombate(astronauta, monstro, dificuldade);
                } else {
                    return; // Sai da fase se a astronauta morrer
                }
            }
        }
        
        // Exibe o status no final
        if (fase.isConcluida() && !astronauta.isDesistente()) {
            System.out.println("Fase concluída! Status da heroína:");
            astronauta.exibirStatus();
        }
    }

    /**
     * Inicia um combate entre a heroína e um monstro.
     *
     * @param astronauta Herói controlado pelo jogador.
     * @param monstro Inimigo da fase que será enfrentado.
     * @return {@code true} se a heroína sobreviveu ao combate, 
     * {@code false} caso tenha sido derrotada.
     */
    private static boolean iniciarCombate(Astronauta astronauta, Monstro monstro) {
        Narrador.narrarChegada(monstro);

        while (astronauta.estaVivo() && monstro.estaVivo()) {
            executarTurnoHeroi(astronauta, monstro);
            if (!monstro.estaVivo()) break;
            executarTurnoMonstro(astronauta, monstro);
        }
        return astronauta.estaVivo();
    }

    /**
     * Executa o turno do herói, permitindo a escolha de ações.
     *
     * @param astronauta herói controlado pelo jogador
     * @param monstro inimigo atual
     */
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

    /**
     * Executa o turno do monstro, escolhendo e aplicando sua ação.
     *
     * @param astronauta herói alvo do ataque
     * @param monstro inimigo que ataca
     */
    private static void executarTurnoMonstro(Astronauta astronauta, Monstro monstro) {
        AcaoDeCombate acaoMonstro = monstro.escolherAcao(astronauta);
        acaoMonstro.executar(monstro, astronauta);
    }
    
    /**
     * Processa os eventos após o combate: XP, loot e desistência.
     *
     * @param astronauta herói controlado pelo jogador
     * @param monstro inimigo derrotado
     * @param dificuldade nível de dificuldade que altera recompensas
     */
    private static void processarPosCombate(Astronauta astronauta, Monstro monstro, Dificuldade dificuldade) {
        Narrador.narrarVitoria(astronauta, monstro);
        int xpGanho = (int) (monstro.getXpConcedido() * dificuldade.getModificador());
        astronauta.ganharExperiencia(xpGanho);

        Item loot = null;
        if (monstro instanceof Lootavel) {
            Random random = new Random();
            if (random.nextDouble() < astronauta.getSorte() + 0.2) {
                loot = ((Lootavel) monstro).droparLoot();
                System.out.println("💎 Você encontrou um loot: " + loot.getNome() + "💎");
                System.out.println();
            }
        }

        boolean menuPosCombate = true;
        while (menuPosCombate) {
            boolean continuar = false;
            int escolha = Menu.mostrarMenuPosTurno();
            switch (escolha) {

                // Continuar (avisa caso haja loot não visualizado)
                case 1:
                    if (loot != null) {
                        continuar = InputManager.lerSimNao("⚠️ Ei! Você ainda tem um loot não analisado. Deseja continuar mesmo assim?");
                        if (continuar) {
                            menuPosCombate = false; 
                        } else {
                            System.out.println("🔍 Volte e analise seu loot antes de continuar!\n");
                            continuar = true; // vai direto pro menu pós combate
                        }
                    }
                    else {
                        menuPosCombate = false;
                    }
                    break;

                // Interagir com o loot
                case 2:
                    if (loot != null) {
                        if (loot instanceof Arma) {
                            boolean equipar = InputManager.lerSimNao("Você encontrou a arma " + loot.getNome() + ". Que tal abrir o painel de análise de armas antes de decidir equipá-la?");
                            if (equipar) {
                                astronauta.equiparArma((Arma) loot);
                                loot = null; // já usou
                            }
                        } else {
                            boolean guardar = InputManager.lerSimNao(
                                "Você encontrou o item " + loot.getNome() + ". Deseja guardar no inventário?");
                            if (guardar) {
                                astronauta.adicionarItemAoInventario(loot);
                                loot = null; // já guardou
                            }
                        }
                    } else {
                        System.out.println("Você não possui loot para interagir no momento.\n");
                    }
                    break;

                // Ver informações do personagem
                case 3:
                    astronauta.exibirStatus();
                    break;

                // Desistir do jogo
                case 4:
                    boolean confirmar = InputManager.lerSimNao("Tem certeza que deseja desistir da missão?");
                    if (confirmar) {
                        astronauta.setDesistiu(true); 
                        astronauta.setPontosDeVida(0);
                        menuPosCombate = false; // sai do menu de ações
                    }
                    break;
            }

            if (menuPosCombate) {
                if (!continuar && loot == null) { // não pergunta somente quando o jogador precisa visualizar algum loot
                    menuPosCombate = InputManager.lerSimNao("Deseja voltar ao menu de ações?");
                }
            }

        }
    }

    /**
     * Exibe a conclusão do jogo, variando entre vitória, derrota ou desistência.
     *
     * @param astronauta herói controlado pelo jogador
     */
    private static void exibirConclusao(Astronauta astronauta) {
        if (astronauta.isDesistente()) {
            Narrador.narrarDesistencia(astronauta);
        } else if (astronauta.estaVivo()) {
            Narrador.narrarVitoriaFinal(astronauta);
        } else {
            Narrador.narrarDerrota(astronauta);
        }
    }
}