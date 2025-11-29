package pam.biblioteca;

public class Filme extends ItemBiblioteca {
    private int duracaoMinutos; 
    private String diretor;

    public Filme(String id, String titulo, int duracaoMinutos, String diretor) {
        super(id, titulo); 
        this.duracaoMinutos = duracaoMinutos;
        this.diretor = diretor;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public String getDiretor() {
        return diretor;
    }

    @Override
    public String toString() {
        return super.getTitulo() + " [Filme - Dir: " + diretor + ", " + duracaoMinutos + "min]";
    }
}