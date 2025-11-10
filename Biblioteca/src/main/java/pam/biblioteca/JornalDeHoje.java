package pam.biblioteca;

import java.time.LocalDate;

public class JornalDeHoje extends Jornal {

    private String manchetePrincipal; // manchete ou título principal do jornal

    // Construtor: define automaticamente a data de publicação como a data atual
    public JornalDeHoje(String titulo, String editora, String editorChefe,
                        String categoria, int numeroEdicao, int qtdPaginas,
                        int qtdExemplares, String manchetePrincipal) {

        super(titulo, editora, editorChefe, categoria, LocalDate.now(),
              numeroEdicao, qtdPaginas, qtdExemplares);

        this.manchetePrincipal = manchetePrincipal;
    }

    // Getter
    public String getManchetePrincipal() {
        return manchetePrincipal;
    }

    // Setter (caso queira atualizar a manchete)
    public void setManchetePrincipal(String manchetePrincipal) {
        this.manchetePrincipal = manchetePrincipal;
    }

    // Sobrescreve emprestar() — jornais do dia geralmente não são emprestados
    @Override
    public boolean emprestar() {
        System.out.println("O jornal de hoje ('" + getTitulo() + "') nao pode ser emprestado. Somente consulta local.");
        return false;
    }

    // toString personalizado, incluindo a manchete
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Manchete Principal: " + manchetePrincipal + "\n" +
               "-----------------------------";
    }
}
