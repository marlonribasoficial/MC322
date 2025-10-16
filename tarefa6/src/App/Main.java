package App;

import Motor.*;
import Util.InputManager;
import Util.Menu;


public class Main {

    public static void main(String[] args) {

        int opcaoMenu = 0;
        while (opcaoMenu != 5) {
            opcaoMenu = Menu.mostrarMenuPrincipal();

            switch (opcaoMenu) {
                case 1:                
                    // Início
                    Batalha batalha = new Batalha();
                    batalha.iniciarNovoJogo();
                    batalha.executarProxFase(); // roda todas as fases

                    // Conclusão
                    Narrador.exibirConclusao(batalha.getAstronauta());
                    break;

                case 2:
                    Batalha batalhaCarregada = new Batalha();
                    int carregada = batalhaCarregada.carregarJogo("jogo.xml");
                    if (carregada == 1) {
                        batalhaCarregada.executarProxFase();
                    }
                    // Conclusão
                    Narrador.exibirConclusao(batalhaCarregada.getAstronauta());
                    break;

                case 3:
                    Menu.mostrarClasseHeroi();
                    break;

                case 4:
                    Menu.mostrarClassesMonstros();
                    break;

                case 5:
                    Menu.mostrarSaida();
                    InputManager.fecharScanner(); // fecha o scanner antes de sair
                    break;
            }
        }
    }
}

