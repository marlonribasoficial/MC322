package Util;

import Motor.Dificuldade;

public class Menu {

    public static int mostrarMenuPrincipal() {
        return InputManager.lerInteiro("""
            \n\n
            ==============================================
                            MISSÃO ALPHA
            ==============================================
            [1] Iniciar Novo Jogo
            [2] Ver Informações das Classes de Heróis
            [3] Ver Informações das Classes de Monstros
            [4] Sair do Jogo
            ==============================================
            Digite sua opção""", 1, 4);
    }

    public static Dificuldade escolherDificuldade() {
        int resultado = InputManager.lerInteiro("""
            ==============================================
            ESCOLHA A DIFICULDADE
            ==============================================
            [1] Fácil
            [2] Normal
            [3] Difícil
            ==============================================
            Digite sua opção""", 1, 3);
        
        switch (resultado) {
            case 1:
                return Dificuldade.FACIL;
            case 2:
                return Dificuldade.NORMAL;
            case 3:
                return Dificuldade.DIFICIL;
            default:
                return Dificuldade.NORMAL;
        }
    }

    public static int mostrarMenuPosTurno() {
        return InputManager.lerInteiro("""
            ==============================================
            MENU DE AÇÕES
            ==============================================
            [1] Continuar
            [2] Interagir com o Loot
            [3] Ver Informações do Personagem
            [4] Desistir do Jogo
            ==============================================
            Digite sua opção""", 1, 4);
    }

    public static void mostrarClasseHeroi() {
        String linha = "==============================================================";

        System.out.println("\n" + linha);
        System.out.println("                        👑 HERÓI 👑                   ");
        System.out.println(linha);

        System.out.println("\n🚀 ASTRONAUTA 🚀");
        System.out.println("❤️ Vida: 120   ⚔️ Força: 30   🍀 Sorte: 0.3   🌬️ Oxigênio: 100");
        System.out.println("\nDescrição: Especialista em exploração espacial.\nPode usar sopro criogênico e possui equipamento avançado para \nsobreviver no espaço.");
        System.out.println(linha + "\n");
        
        System.out.println("*Atributos podem variar dependendo da fase e da dificuldade.");
        InputManager.esperarEnter("Pressione ENTER para voltar ao menu principal");
    }

    public static void mostrarClassesMonstros() {
        String linha = "==============================================================";

        System.out.println("\n" + linha);
        System.out.println("                        👹 MONSTROS 👹                   ");
        System.out.println(linha);

        // Alien Slime
        System.out.println("\n👾 ALIEN SLIME 👾");
        System.out.println("❤️ Vida: 50   ⚔️ Força: 12   🌟 XP: 20");
        System.out.println("\nDescrição: Slime mutante viscoso que adora grudar.");
        System.out.println(linha);

        // Alien Paradoxo
        System.out.println("\n👽 ALIEN PARADOXO 👽");
        System.out.println("❤️ Vida: 60   ⚔️ Força: 15   🌟 XP: 25");
        System.out.println("\nDescrição: Criatura enigmática do espaço-tempo, imprevisível \nem ataques.");
        System.out.println(linha);

        // Alien 4D
        System.out.println("\n🌀 ALIEN 4D 🌀");
        System.out.println("❤️ Vida: 75   ⚔️ Força: 18   🌟 XP: 30");
        System.out.println("\nDescrição: Alien ágil e traiçoeiro, sempre pronto para \nemboscadas.");
        System.out.println(linha + "\n");

        System.out.println("*Atributos podem variar dependendo da fase e da dificuldade.");
        InputManager.esperarEnter("Pressione ENTER para voltar ao menu principal");
    }

    public static void mostrarSaida() {
        String linha = "----------------------------------------------------------------------";

        System.out.println("\n" + linha);
        System.out.println("                            SAINDO DO JOGO...                     ");
        Utilidades.tempoDeTexto();
        System.out.println("                    Conexão encerrada com sucesso 🛸             ");
        System.out.println(linha + "\n");
    }
}
