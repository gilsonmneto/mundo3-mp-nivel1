
package cadastropoo;

import java.io.IOException;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;

public class CadastroPOO {

 public static void main(String[] args) {
        // Teste com PessoaFisicaRepo
        

        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

        PessoaFisica pessoaFisica1 = new PessoaFisica(1, "Ana", "111.111.111-11", 25);
        PessoaFisica pessoaFisica2 = new PessoaFisica(2, "Carlos", "222.222.222-22", 52);

        repo1.inserir(pessoaFisica1);
        repo1.inserir(pessoaFisica2);

        try {
            repo1.persistir("pessoas_fisicas.dat");
        } catch (IOException e) {
            System.out.println("erro");
            e.printStackTrace(System.out);
        }

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        try {
            repo2.recuperar("pessoas_fisicas.dat");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        System.out.println("Pessoas Físicas Recuperadas:");
        for (PessoaFisica pessoa : repo2.obterTodos()) {
            pessoa.exibir();
        }

        // Teste com PessoaJuridicaRepo
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

        PessoaJuridica pessoaJuridica1 = new PessoaJuridica(3, "XPTO Sales", "33.333.333/3333-33");
        PessoaJuridica pessoaJuridica2 = new PessoaJuridica(4, "XPTO Solutions", "44.444.444/4444-44");

        
        System.out.println("\n");
        
        repo3.inserir(pessoaJuridica1);
        repo3.inserir(pessoaJuridica2);

        try {
            repo3.persistir("pessoas_juridicas.dat");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        try {
            repo4.recuperar("pessoas_juridicas.dat");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        System.out.println("Pessoas Jurídicas Recuperadas:");
        for (PessoaJuridica pessoa : repo4.obterTodos()) {
            pessoa.exibir();
        }
    }
}
   
