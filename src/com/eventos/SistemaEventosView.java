package com.eventos;

import java.util.Scanner;

public class SistemaEventosView {

    private final Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("\n--- Sistema de Eventos ---");
        System.out.println("1. Cadastrar evento");
        System.out.println("2. Listar eventos");
        System.out.println("3. Buscar eventos por categoria");
        System.out.println("4. Atualizar evento");
        System.out.println("5. Remover evento");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public int lerOpcao() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Digite um número válido!");
            return -1;
        }
    }

    public String lerString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public int lerInt(String prompt) {
        try {
            System.out.print(prompt);
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}