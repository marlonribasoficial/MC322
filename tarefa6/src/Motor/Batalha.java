package Motor;

import Entidades.Heroi.Astronauta;
import Entidades.Monstros.Monstro;
import Interfaces.*;
import Itens.Arma;
import Util.InputManager;
import Util.Menu;

import java.util.List;
import java.util.Random;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "batalha")
@XmlAccessorType(XmlAccessType.FIELD)
public class Batalha {

    @XmlElement(name = "astronauta")
    private Astronauta astronauta;

    @XmlElements({
        @XmlElement(name = "faseDeCombate", type = FaseDeCombate.class)
    })
    private List<Fase> fases;

    @XmlElement(name = "dificuldade")
    private Dificuldade dificuldade;

    @XmlElements({
        @XmlElement(name = "faseAtual", type = FaseDeCombate.class)
    })
    private Fase faseAtual;

    public Batalha() {}

    public Batalha(Astronauta astronauta, List<Fase> fases, Dificuldade dificuldade) {
        this.astronauta = astronauta;
        this.fases = fases;
        this.dificuldade = dificuldade;
        this.faseAtual = null;
    }

    // Getters
    public Astronauta getAstronauta() { return this.astronauta; }
    public List<Fase> getFases() { return this.fases; }
    public Dificuldade getDificuldade() { return this.dificuldade; }
    public Fase getFaseAtual() { return this.faseAtual; }

    /**
     * Cria um novo jogo: inicializa o herói e gera as fases
     */
    public void iniciarNovoJogo() {
        // escolhe a dificuldade
        this.dificuldade = Menu.escolherDificuldade();

        // cria a heroína
        this.astronauta = new Astronauta(
        "Capitã Fernanda",
        120, 30, 0, 0,
        100, 120, 100, 
        null,                 
        0.3                   
        );

        // gera as fases
        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        this.fases = gerador.gerar(3, dificuldade);

        // inicializa fase atual como null
        this.faseAtual = null;

        // narração de introdução
        Narrador.introducao(astronauta);
    }

    /**
     * Executa uma fase, incluindo a lógica de combates e conclusão.
     */
    public void executarProxFase() {
        if (astronauta.isDesistente()) return;

        // percorre as fases
        for (Fase fase : fases) {

            if (astronauta.isDesistente()) return;

            // pula fases já concluídas se o herói carregou o jogo
            if (fase.getNivel() < astronauta.getFaseAtual()) {
                continue; // já concluiu esta fase
            }
            
            faseAtual = fase;
            astronauta.setFaseAtual(fase.getNivel());
            
            FaseDeCombate faseDeCombate = (FaseDeCombate) faseAtual;

            // inicia no monstro posterior ao último atacado
            int inicio = astronauta.getMonstroAtual();
            List<Monstro> monstros = faseDeCombate.getMonstros();

            if (!faseAtual.isConcluida() && inicio == 0) {
                faseAtual.iniciar(astronauta);
            }

            // percorre a lista de monstros da fase
            for (int i = inicio; i < monstros.size(); i++) {
                if (astronauta.isDesistente()) return;

                Monstro monstro = monstros.get(i);
                monstro.setPontosDeVida(monstro.getVidaMax());
                monstro.inicializarAcoes();
                monstro.inicializarLoot(this.dificuldade.getModificador());

                boolean heroiSobreviveu = iniciarCombate(astronauta, monstro);
                if (heroiSobreviveu) {
                    astronauta.setMonstroAtual(i + 1);
                    // Exibe o status no final
                    if (faseAtual.isConcluida()) {
                        System.out.println("\n========================================");
                        System.out.println("\n        🔘🟢 FASE CONCLUÍDA 🟢🔘");
                        astronauta.exibirStatus();

                        if (fase.getNivel() == fases.size()) {
                            return;
                        }
                    }

                    processarPosCombate(astronauta, monstro, dificuldade);

                } else {
                    return; // Sai da fase se a astronauta morrer
                }
            }
            astronauta.setMonstroAtual(0);
            astronauta.setFaseAtual(faseAtual.getNivel());
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
    private boolean iniciarCombate(Astronauta astronauta, Monstro monstro) {
        Narrador.narrarChegada(monstro);

        while (astronauta.estaVivo() && monstro.estaVivo()) {
            executarTurnoHeroi(astronauta, monstro);
            if (!monstro.estaVivo()) break;
            executarTurnoMonstro(astronauta, monstro);
        }
        return astronauta.estaVivo();
    }

    /**
     * Executa o turno do herói
     *
     * @param astronauta herói controlado pelo jogador
     * @param monstro inimigo atual
     */
    private void executarTurnoHeroi(Astronauta astronauta, Monstro monstro) {
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
    private void executarTurnoMonstro(Astronauta astronauta, Monstro monstro) {
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
    private void processarPosCombate(Astronauta astronauta, Monstro monstro, Dificuldade dificuldade) {
        Narrador.narrarVitoria(astronauta, monstro);
        int xpGanho = (int) (monstro.getXpConcedido() * dificuldade.getModificador());
        astronauta.ganharExperiencia(xpGanho);

        Item loot = null;
        if (monstro instanceof Lootavel) {
            Random random = new Random();
            if (random.nextDouble() < astronauta.getSorte() + 0.2) {
                loot = ((Lootavel) monstro).droparLoot(faseAtual.getNivel(), dificuldade.getModificador());

                if (loot != null) { // Checa se o loot não é nulo antes de imprimir
                    System.out.println("💎 Você encontrou um loot: " + loot.getNome() + "💎");
                    System.out.println();
                }
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
                    } else {
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
                            boolean guardar = InputManager.lerSimNao("Você encontrou o item " + loot.getNome() + ". Deseja guardar no inventário?");
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

                // Salvar jogo
                case 4:
                    GerenciadorDePersistencia.salvarBatalha(this, "jogo.xml");
                    boolean sair = InputManager.lerSimNao("Deseja sair agora?");
                    if (sair) {
                        astronauta.setDesistiu(true);
                        menuPosCombate = false;
                    }
                    continuar = true; // volta diretamente pro menu pós combate
                    break;

                // Desistir do jogo
                case 5:
                    boolean confirmar = InputManager.lerSimNao("Tem certeza que deseja desistir da missão?");
                    if (confirmar) {
                        astronauta.setDesistiu(true);
                        astronauta.setPontosDeVida(0);
                        menuPosCombate = false; // sai do menu de ações
                    }
                    break;
            }

            if (menuPosCombate) {
                if (!continuar && loot == null) { // pergunta somente quando o jogador não precisa visualizar algum loot obrigatoriamente
                    menuPosCombate = InputManager.lerSimNao("Deseja voltar ao menu de ações?");
                }
            }
        }
    }

    public int carregarJogo(String nome) {
        Batalha batalhaCarregada = GerenciadorDePersistencia.carregarBatalha(nome);
        if (batalhaCarregada != null) {

            this.astronauta = batalhaCarregada.getAstronauta();
            this.fases = batalhaCarregada.getFases();
            this.dificuldade = batalhaCarregada.getDificuldade();
            this.faseAtual = batalhaCarregada.getFaseAtual();
            System.out.println("✅ Batalha carregada com sucesso!");
            return 1;
        } else {
            System.out.println("❌ Nenhum jogo salvo encontrado. Por favor, crie um novo jogo!");
            return 0;
        }
    }
}
