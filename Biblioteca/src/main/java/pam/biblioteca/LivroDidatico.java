package pam.biblioteca;

public class LivroDidatico extends Livro {
    
    private final String materia;

    public LivroDidatico(String titulo, int qtdPags, String tipoCapa, String autor,
                         int anoPub, int qtdExemplares, String materia) {
        super(titulo, qtdPags, tipoCapa, autor, anoPub, qtdExemplares);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Matéria: " + this.materia + "\n" +
               "-------------------------";
    }
}
