
package model.gerenciadores;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.PessoaJuridica;

public class PessoaJuridicaRepo {
    private final List<PessoaJuridica> listaPessoasJuridicas;

    public PessoaJuridicaRepo() {
        listaPessoasJuridicas = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoaJuridica) {
        listaPessoasJuridicas.add(pessoaJuridica);
    }

    public void alterar(PessoaJuridica pessoaJuridica) {
        int index = encontrarIndicePorId(pessoaJuridica.getId());
        if (index != -1) {
            listaPessoasJuridicas.set(index, pessoaJuridica);
        }
    }

    public void excluir(int id) {
        int index = encontrarIndicePorId(id);
        if (index != -1) {
            listaPessoasJuridicas.remove(index);
        }
    }

    public PessoaJuridica obter(int id) {
        int index = encontrarIndicePorId(id);
        if (index != -1) {
            return listaPessoasJuridicas.get(index);
        }
        return null;
    }

    public List<PessoaJuridica> obterTodos() {
        return listaPessoasJuridicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(listaPessoasJuridicas);
            System.out.println("Dados de Pessoa Jurídica Armazenados no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            throw new IOException("Erro ao persistir os dados", e);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            List<PessoaJuridica> pessoasJuridicasRecuperadas = (List<PessoaJuridica>) inputStream.readObject();
            listaPessoasJuridicas.clear();
            listaPessoasJuridicas.addAll(pessoasJuridicasRecuperadas);
            System.out.println("Dados de Pessoa Jurídica Recuperados do arquivo: " + nomeArquivo);
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Erro ao recuperar os dados", e);
        }
    }

    private int encontrarIndicePorId(int id) {
        for (int i = 0; i < listaPessoasJuridicas.size(); i++) {
            if (listaPessoasJuridicas.get(i).getId() == id) {
                return i;
            }
        }
        return -1; // Retorna -1 se não encontrar o ID
    }
}
