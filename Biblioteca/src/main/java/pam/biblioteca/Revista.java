package pam.biblioteca;

public abstract class Revista implements Acoes {
    private String titulo;
    private int qtdPags;
    private String editora;
    private String periodicidade; // semanal, mensal, etc.
    private int numeroEdicao;
    private int anoPub;
    private int qtdExemplares;
    private String tema;

    public Revista() {}

    public Revista(String titulo, int qtdPags, String editora, String periodicidade,
                   int numeroEdicao, int anoPub, int qtdExemplares, String tema) {
        this.titulo = titulo;
        this.qtdPags = qtdPags;
        this.editora = editora;
        this.periodicidade = periodicidade;
        this.numeroEdicao = numeroEdicao;
        this.anoPub = anoPub;
        this.qtdExemplares = qtdExemplares;
        this.tema = tema;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public int getAnoPub() {
        return anoPub;
    }

    public int getQtdPags() {
        return qtdPags;
    }

    public int getQtdExemplares() {
        return qtdExemplares;
    }

    public String getTema() {
        return tema;
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
            System.out.println("Emprestimo da revista '" + titulo + "' realizado com sucesso!"); // Removido 'é'
            return true;
        } else {
            System.out.println("Erro: nao ha exemplares da revista '" + titulo + "' disponiveis."); // Removido 'ã', 'á', 'í'
            return false;
        }
    }

    @Override
    public void devolver() {
        qtdExemplares++;
        System.out.println("A revista '" + titulo + "' foi devolvida com sucesso!");
    }

    @Override
    public void doar() {
        qtdExemplares++;
        System.out.println("Doacao recebida! A revista '" + titulo + "' agora tem " + qtdExemplares + " exemplares disponiveis."); // Removido 'ç', 'ã', 'í'
    }

    @Override
    public String toString() {
        return "--- Informacoes da Revista ---\n" + // Removido 'ç', 'õ'
               "Titulo: " + titulo + "\n" +
               "Tema: " + tema + "\n" +
               "Editora: " + editora + "\n" +
               "Periodicidade: " + periodicidade + "\n" +
               "Numero da Edicao: " + numeroEdicao + "\n" + // Removido 'ú', 'ç', 'ã'
               "Ano de Publicacao: " + anoPub + "\n" + // Removido 'ç', 'ã'
               "Paginas: " + qtdPags + "\n" + // Removido 'á'
               "Exemplares Disponiveis: " + qtdExemplares + "\n" + // Removido 'í'
               "------------------------------";
    }
}