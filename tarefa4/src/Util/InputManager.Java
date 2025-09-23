package Util;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputManager {

    private static final Scanner scanner = new Scanner(System.in);

    // Lê um número inteiro dentro de um intervalo
    public static int lerInteiro(String mensagem, int min, int max) {
        int valor = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensagem + " (" + min + " - " + max + "): ");
            String entrada = null;

            try {
                entrada = scanner.nextLine().trim();

                if (!entrada.isEmpty()) {
                    valor = Integer.parseInt(entrada);  // converte para inteiro
                    if (valor >= min && valor <= max) { // verifica se está dentro do intervalo
                        valido = true;
                    } else {
                        System.out.println("Fora do intervalo!");
                    }
                } else {
                    System.out.println("Entrada vazia.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Valor inválido.");
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada não disponível.", e);
            }
        }

        return valor;
    }

    // Lê uma string
    public static String lerString(String mensagem) {
        String entrada = "";
        while (entrada.isEmpty()) {
            System.out.print(mensagem + ": ");
            try {
                entrada = scanner.nextLine().trim();
                if (entrada.isEmpty()) {
                    System.out.println("Entrada vazia.");
                }
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada não disponível.", e);
            }
        }
        return entrada;
    }

    // Lê um "s" ou "n"
    public static boolean lerSimNao(String mensagem) {
        while (true) {
            System.out.print(mensagem + " (s/n): ");
            String entrada;
            try {
                entrada = scanner.nextLine().toLowerCase().trim();
                if (entrada.equals("s")) {
                    return true;
                } else if (entrada.equals("n")) {
                    return false;
                } else {
                    System.out.println("Digite apenas 's' ou 'n'.");
                }
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada não disponível.", e);
            }
        }
    }

    // Espera o usuário apertar Enter
    public static void esperarEnter(String mensagem) {
        System.out.println(mensagem);
        try {
            scanner.nextLine();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Entrada não disponível.", e);
        }
    }

    // Fecha o Scanner
    public static void fecharScanner() {
        scanner.close();
    }
}
