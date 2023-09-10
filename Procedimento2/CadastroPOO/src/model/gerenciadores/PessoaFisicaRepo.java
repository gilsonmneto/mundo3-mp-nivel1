
package model.gerenciadores;

import model.PessoaFisica;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepo {
    private final List<PessoaFisica> listaPessoasFisicas;

    public PessoaFisicaRepo() {
        listaPessoasFisicas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoaFisica) {
        listaPessoasFisicas.add(pessoaFisica);
    }

    public void alterar(PessoaFisica pessoaFisica) {
        int index = encontrarIndicePorId(pessoaFisica.getId());
        if (index != -1) {
            listaPessoasFisicas.set(index, pessoaFisica);
        }
    }

    public void excluir(int id) {
        int index = encontrarIndicePorId(id);
        if (index != -1) {
            listaPessoasFisicas.remove(index);
        }
    }

    public PessoaFisica obter(int id) {
        int index = encontrarIndicePorId(id);
        if (index != -1) {
            return listaPessoasFisicas.get(index);
        }
        return null;
    }

    public List<PessoaFisica> obterTodos() {
        return listaPessoasFisicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(listaPessoasFisicas);
            System.out.println("Dados de Pessoa Física Armazenados no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            throw new IOException("Erro ao persistir os dados", e);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            List<PessoaFisica> pessoasFisicasRecuperadas = (List<PessoaFisica>) inputStream.readObject();
            listaPessoasFisicas.clear();
            listaPessoasFisicas.addAll(pessoasFisicasRecuperadas);
            System.out.println("Dados de Pessoa Física Recuperados do arquivo: " + nomeArquivo);
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Erro ao recuperar os dados", e);
        }
    }

    private int encontrarIndicePorId(int id) {
        for (int i = 0; i < listaPessoasFisicas.size(); i++) {
            if (listaPessoasFisicas.get(i).getId() == id) {
                return i;
            }
        }
        return -1; // Retorna -1 se não encontrar o ID
    }
}