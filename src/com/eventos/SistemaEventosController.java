package com.eventos;

import java.io.Serializable;
import java.util.Scanner;

public class SistemaEventosController implements Serializable {

    private final GerenciadorEventos gerenciador;
    private final SistemaEventosView view;
    private final Scanner sc;

    public SistemaEventosController() {
        this.gerenciador = new GerenciadorEventos();
        this.view = new SistemaEventosView();
        this.sc = new Scanner(System.in);
    }

    public void executar() {
        int opcao = -1;
        do {
            view.exibirMenu();
            opcao = view.lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarEvento();
                    break;
                case 2:
                    gerenciador.listarEventos();
                    break;
                case 3:
                    buscarPorCategoria();
                    break;
                case 4:
                    atualizarEvento();
                    break;
                case 5:
                    removerEvento();
                    break;
                case 0:
                    view.exibirMensagem("👋 Saindo do sistema. Até logo!");
                    break;
                default:
                    view.exibirMensagem("❌ Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 0);
        sc.close();
    }

    private void cadastrarEvento() {
        String nomeUsuario = view.lerString("Digite o nome do usuário: ");
        String emailUsuario = view.lerString("Digite o e-mail do usuário: ");
        Usuario usuario = new Usuario(nomeUsuario, emailUsuario);

        String nome = view.lerString("Digite o nome do evento: ");
        String endereco = view.lerString("Digite o endereço: ");
        String categoria = view.lerString("Digite a categoria: ");
        String horario = view.lerString("Digite o horário: ");
        String descricao = view.lerString("Digite a descrição: ");

        Evento evento = new Evento(nome, endereco, categoria, horario, descricao, usuario);
        gerenciador.adicionarEvento(evento);
    }

    private void buscarPorCategoria() {
        String categoriaBusca = view.lerString("Digite a categoria para busca: ");
        gerenciador.buscarPorCategoria(categoriaBusca);
    }

    private void atualizarEvento() {
        gerenciador.listarEventos();
        int idUpdate = view.lerInt("Digite o ID do evento que deseja atualizar: ");
        if (idUpdate > 0) {
            String novoNome = view.lerString("Novo nome do evento: ");
            String novoEndereco = view.lerString("Novo endereço: ");
            String novaCategoria = view.lerString("Nova categoria: ");
            String novoHorario = view.lerString("Novo horário: ");
            String novaDescricao = view.lerString("Nova descrição: ");

            gerenciador.atualizarEvento(idUpdate, novoNome, novoEndereco, novaCategoria, novoHorario, novaDescricao);
        } else {
            view.exibirMensagem("❌ ID inválido!");
        }
    }

    private void removerEvento() {
        gerenciador.listarEventos();
        int idDelete = view.lerInt("Digite o ID do evento que deseja remover: ");
        if (idDelete > 0) {
            gerenciador.removerEvento(idDelete);
        } else {
            view.exibirMensagem("❌ ID inválido!");
        }
    }
}