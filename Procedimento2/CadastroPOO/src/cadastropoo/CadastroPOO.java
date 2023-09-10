
package cadastropoo;

import java.io.IOException;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;
import java.util.Scanner;

public class CadastroPOO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        while (true) {
            System.out.println("======================================");
            System.out.println("1. Incluir Pessoa");
            System.out.println("2. Alterar Pessoa");
            System.out.println("3. Excluir Pessoa");
            System.out.println("4. Busca pelo ID");
            System.out.println("5. Exibir todos");
            System.out.println("6. Persistir dados");
            System.out.println("7. Recuperar dados");
            System.out.println("0. Finalizar Programa");
            System.out.println("======================================");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):");
                    String tipoPessoa = scanner.nextLine();

                    if ("F".equalsIgnoreCase(tipoPessoa)) {
                        System.out.println("Digite os dados da Pessoa Física:");
                        System.out.print("ID: ");
                        int idFisica = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nomeFisica = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha

                        PessoaFisica pessoaFisica = new PessoaFisica(idFisica, nomeFisica, cpf, idade);
                        repoFisica.inserir(pessoaFisica);
                    } else if ("J".equalsIgnoreCase(tipoPessoa)) {
                        System.out.println("Digite os dados da Pessoa Jurídica:");
                        System.out.print("ID: ");
                        int idJuridica = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nomeJuridica = scanner.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();

                        PessoaJuridica pessoaJuridica = new PessoaJuridica(idJuridica, nomeJuridica, cnpj);
                        repoJuridica.inserir(pessoaJuridica);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    System.out.println("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):");
                    String tipoAlterar = scanner.nextLine();

                    System.out.print("Digite o ID da pessoa que deseja alterar: ");
                    int idAlterar = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    if ("F".equalsIgnoreCase(tipoAlterar)) {
                        PessoaFisica pessoaFisica = repoFisica.obter(idAlterar);
                        if (pessoaFisica != null) {
                            System.out.println("Dados atuais da Pessoa Física:");
                            pessoaFisica.exibir();

                            System.out.println("Digite os novos dados da Pessoa Física:");
                            System.out.print("Nome: ");
                            String novoNome = scanner.nextLine();
                            System.out.print("CPF: ");
                            String novoCpf = scanner.nextLine();
                            System.out.print("Idade: ");
                            int novaIdade = scanner.nextInt();
                            scanner.nextLine(); // Consumir a quebra de linha

                            pessoaFisica.setNome(novoNome);
                            pessoaFisica.setCpf(novoCpf);
                            pessoaFisica.setIdade(novaIdade);

                            repoFisica.alterar(pessoaFisica);
                        } else {
                            System.out.println("Pessoa Física não encontrada com o ID informado.");
                        }
                    } else if ("J".equalsIgnoreCase(tipoAlterar)) {
                        PessoaJuridica pessoaJuridica = repoJuridica.obter(idAlterar);
                        if (pessoaJuridica != null) {
                            System.out.println("Dados atuais da Pessoa Jurídica:");
                            pessoaJuridica.exibir();

                            System.out.println("Digite os novos dados da Pessoa Jurídica:");
                            System.out.print("Nome: ");
                            String novoNome = scanner.nextLine();
                            System.out.print("CNPJ: ");
                            String novoCnpj = scanner.nextLine();

                            pessoaJuridica.setNome(novoNome);
                            pessoaJuridica.setCnpj(novoCnpj);

                            repoJuridica.alterar(pessoaJuridica);
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada com o ID informado.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    System.out.println("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):");
                    String tipoExcluir = scanner.nextLine();

                    System.out.print("Digite o ID da pessoa que deseja excluir: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    if ("F".equalsIgnoreCase(tipoExcluir)) {
                        repoFisica.excluir(idExcluir);
                    } else if ("J".equalsIgnoreCase(tipoExcluir)) {
                        repoJuridica.excluir(idExcluir);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 4:
                    System.out.println("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):");
                    String tipoObter = scanner.nextLine();
                    System.out.print("Digite o ID da pessoa que deseja obter: ");
                    int idObter = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    if ("F".equalsIgnoreCase(tipoObter)) {
                        PessoaFisica pessoaFisica = repoFisica.obter(idObter);
                        if (pessoaFisica != null) {
                            System.out.println("Dados da Pessoa Física:");
                            pessoaFisica.exibir();
                        } else {
                            System.out.println("Pessoa Física não encontrada com o ID informado.");
                        }
                    } else if ("J".equalsIgnoreCase(tipoObter)) {
                        PessoaJuridica pessoaJuridica = repoJuridica.obter(idObter);
                        if (pessoaJuridica != null) {
                            System.out.println("Dados da Pessoa Jurídica:");
                            pessoaJuridica.exibir();
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada com o ID informado.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 5:
                    System.out.println("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica):");
                    String tipoExibirTodos = scanner.nextLine();

                    if ("F".equalsIgnoreCase(tipoExibirTodos)) {
                        System.out.println("Pessoas Físicas:");
                        for (PessoaFisica pessoa : repoFisica.obterTodos()) {
                            pessoa.exibir();
                        }
                    } else if ("J".equalsIgnoreCase(tipoExibirTodos)) {
                        System.out.println("Pessoas Jurídicas:");
                        for (PessoaJuridica pessoa : repoJuridica.obterTodos()) {
                            pessoa.exibir();
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 6:
                    System.out.print("Digite o prefixo dos arquivos para salvar os dados: ");
                    String prefixoSalvar = scanner.nextLine();
                    try {
                        repoFisica.persistir(prefixoSalvar + ".fisica.bin");
                        repoJuridica.persistir(prefixoSalvar + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (IOException e) {
                        e.printStackTrace(System.out);
                        System.out.println("Erro ao salvar os dados.");
                    }
                    break;

                case 7:
                    System.out.print("Digite o prefixo dos arquivos para recuperar os dados: ");
                    String prefixoRecuperar = scanner.nextLine();
                    try {
                        repoFisica.recuperar(prefixoRecuperar + ".fisica.bin");
                        repoJuridica.recuperar(prefixoRecuperar + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso.");
                    } catch (IOException e) {
                        e.printStackTrace(System.out);
                        System.out.println("Erro ao recuperar os dados.");
                    }
                    break;

                case 0:
                    System.out.println("Finalizando o programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}