package pam.biblioteca;

public class RevistaCarros extends Revista {
    
    private String marcaDestaque; // marca de carro destacada na edição

    // Construtor completo
    public RevistaCarros(String titulo, int qtdPags, String editora, String periodicidade,
                         int numeroEdicao, int anoPub, int qtdExemplares, String tema, String marcaDestaque) {
        super(titulo, qtdPags, editora, periodicidade, numeroEdicao, anoPub, qtdExemplares, tema);
        this.marcaDestaque = marcaDestaque;
    }

    // Getter
    public String getMarcaDestaque() {
        return marcaDestaque;
    }

    // Setter opcional (caso queira mudar depois)
    public void setMarcaDestaque(String marcaDestaque) {
        this.marcaDestaque = marcaDestaque;
    }

    // Sobrescrita de toString() para incluir o campo novo
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Marca em Destaque: " + marcaDestaque + "\n" +
               "------------------------------";
    }

    // Opcional: caso queira restringir empréstimos (exemplo de override útil)
    @Override
    public boolean emprestar() {
        if (getQtdExemplares() <= 0) {
            System.out.println("Erro: nao ha exemplares da revista '" + getTitulo() + "' disponiveis.");
            return false;
        }

        // Exemplo de regra específica: revistas de carros não podem ser emprestadas se forem edição especial
        if (getTema().equalsIgnoreCase("Edição Especial")) {
            System.out.println("Esta revista de carros é uma edicao especial e nao pode ser emprestada.");
            return false;
        }

        // Chama comportamento padrão
        return super.emprestar();
    }
}
