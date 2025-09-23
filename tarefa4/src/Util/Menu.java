package Util;

public class Menu {

    public static int mostrarMenuPrincipal() {
        return InputManager.lerInteiro("""
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

    public static int escolherDificuldade() {
        return InputManager.lerInteiro("""
            ==============================================
            ESCOLHA A DIFICULDADE
            ==============================================
            [1] Fácil
            [2] Normal
            [3] Difícil
            ==============================================
            Digite sua opção""", 1, 3);
    }

    public static int mostrarMenuPosTurno() {
        return InputManager.lerInteiro("""
            ==============================================
            [1] Interagir com o Loot
            [2] Ver Informações do Personagem
            [3] Desistir do Jogo
            ==============================================
            Digite sua opção""", 1, 3);
    }
}
