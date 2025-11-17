package pam.biblioteca;

public class RevistaCarros extends Revista {
    
    private String marcaDestaque; 

    public RevistaCarros(String titulo, int qtdPags, String editora, String periodicidade,
                         int numeroEdicao, int anoPub, int qtdExemplares, String tema, String marcaDestaque) {
        super(titulo, qtdPags, editora, periodicidade, numeroEdicao, anoPub, qtdExemplares, tema);
        this.marcaDestaque = marcaDestaque;
    }

    public String getMarcaDestaque() {
        return marcaDestaque;
    }

    public void setMarcaDestaque(String marcaDestaque) {
        this.marcaDestaque = marcaDestaque;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Marca em Destaque: " + marcaDestaque + "\n" +
               "------------------------------";
    }

    @Override
    public boolean emprestar() {
        if (getQtdExemplares() <= 0) {
            System.out.println("Erro: nao ha exemplares da revista '" + getTitulo() + "' disponiveis.");
            return false;
        }

        if (getTema().equalsIgnoreCase("Edição Especial")) {
            System.out.println("Esta revista de carros é uma edicao especial e nao pode ser emprestada.");
            return false;
        }

        return super.emprestar();
    }
}
