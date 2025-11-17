package pam.biblioteca;

import java.time.LocalDate;

public class JornalDeHoje extends Jornal {

    private String manchetePrincipal;

    public JornalDeHoje(String titulo, String editora, String editorChefe,
                        String categoria, int numeroEdicao, int qtdPaginas,
                        int qtdExemplares, String manchetePrincipal) {

        super(titulo, editora, editorChefe, categoria, LocalDate.now(),
              numeroEdicao, qtdPaginas, qtdExemplares);

        this.manchetePrincipal = manchetePrincipal;
    }

    public String getManchetePrincipal() {
        return manchetePrincipal;
    }

    public void setManchetePrincipal(String manchetePrincipal) {
        this.manchetePrincipal = manchetePrincipal;
    }

    @Override
    public boolean emprestar() {
        System.out.println("O jornal de hoje ('" + getTitulo() + "') nao pode ser emprestado. Somente consulta local.");
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Manchete Principal: " + manchetePrincipal + "\n" +
               "-----------------------------";
    }
}
