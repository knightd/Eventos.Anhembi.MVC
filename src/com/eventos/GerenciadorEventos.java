package com.eventos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorEventos {
    private List<Evento> eventos;
    private final String ARQUIVO = "eventos.data";

    public GerenciadorEventos() {
        eventos = carregarEventos();
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
        salvarEventos();
        System.out.println("✅ Evento adicionado com sucesso!");
    }

    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("⚠ Nenhum evento cadastrado ainda.");
        } else {
            int i = 1;
            for (Evento e : eventos) {
                System.out.println("ID " + i + " -> " + e);
                i++;
            }
        }
    }

    public void buscarPorCategoria(String categoria) {
        boolean encontrado = false;
        for (Evento e : eventos) {
            if (e.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(e);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("⚠ Nenhum evento encontrado na categoria: " + categoria);
        }
    }

    public void atualizarEvento(int id, String nome, String endereco, String categoria, String horario, String descricao) {
        if (id < 1 || id > eventos.size()) {
            System.out.println("❌ Evento não encontrado!");
            return;
        }
        Evento evento = eventos.get(id - 1);

        evento.setNome(nome);
        evento.setEndereco(endereco);
        evento.setCategoria(categoria);
        evento.setHorario(horario);
        evento.setDescricao(descricao);

        salvarEventos();
        System.out.println("✅ Evento atualizado com sucesso!");
    }

    public void removerEvento(int id) {
        if (id < 1 || id > eventos.size()) {
            System.out.println("❌ Evento não encontrado!");
            return;
        }
        eventos.remove(id - 1);
        salvarEventos();
        System.out.println("🗑 Evento removido com sucesso!");
    }

    private void salvarEventos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(eventos);
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar eventos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private List<Evento> carregarEventos() {
        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (List<Evento>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠ Nenhum evento carregado (arquivo vazio ou corrompido). Criando lista nova.");
            return new ArrayList<>();
        }
    }
}