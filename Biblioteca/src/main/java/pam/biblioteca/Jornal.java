package pam.biblioteca;

import java.time.LocalDate;

public abstract class Jornal implements Acoes {
    private String titulo;
    private String editora;
    private String editorChefe;
    private String categoria;
    private LocalDate dataPublicacao;
    private int numeroEdicao;
    private int qtdPaginas;
    private int qtdExemplares;

    public Jornal() {}

    public Jornal(String titulo, String editora, String editorChefe, String categoria,
                  LocalDate dataPublicacao, int numeroEdicao, int qtdPaginas, int qtdExemplares) {
        this.titulo = titulo;
        this.editora = editora;
        this.editorChefe = editorChefe;
        this.categoria = categoria;
        this.dataPublicacao = dataPublicacao;
        this.numeroEdicao = numeroEdicao;
        this.qtdPaginas = qtdPaginas;
        this.qtdExemplares = qtdExemplares;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public String getEditorChefe() {
        return editorChefe;
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public int getQtdExemplares() {
        return qtdExemplares;
    }

    // Metodos da interface Acoes
    @Override
    public boolean disponivel() {
        return qtdExemplares > 0;
    }

    @Override
    public boolean emprestar() {
        if (disponivel()) {
            qtdExemplares--;
            System.out.println("Emprestimo do jornal '" + titulo + "' realizado com sucesso!"); // Removido 'é'
            return true;
        } else {
            System.out.println("Erro: nao ha exemplares do jornal '" + titulo + "' disponiveis."); // Removido 'ã', 'á', 'í'
            return false;
        }
    }

    @Override
    public void devolver() {
        qtdExemplares++;
        System.out.println("O jornal '" + titulo + "' foi devolvido com sucesso!");
    }

    @Override
    public void doar() {
        qtdExemplares++;
        System.out.println("Doacao recebida! O jornal '" + titulo + "' agora tem " + qtdExemplares + " exemplares disponiveis."); // Removido 'ç', 'ã', 'í'
    }

    @Override
    public String toString() {
        return "--- Informacoes do Jornal ---\n" + // Removido 'ç', 'õ'
               "Titulo: " + titulo + "\n" +
               "Editora: " + editora + "\n" +
               "Editor-chefe: " + editorChefe + "\n" + // Removido 'ê'
               "Categoria: " + categoria + "\n" +
               "Data de Publicacao: " + dataPublicacao + "\n" + // Removido 'ç', 'ã'
               "Numero da Edicao: " + numeroEdicao + "\n" + // Removido 'ú', 'ç', 'ã'
               "Paginas: " + qtdPaginas + "\n" + // Removido 'á'
               "Exemplares Disponiveis: " + qtdExemplares + "\n" + // Removido 'í'
               "-----------------------------";
    }
}