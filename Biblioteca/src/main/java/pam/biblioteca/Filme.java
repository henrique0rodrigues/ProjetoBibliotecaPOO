package pam.biblioteca;

public class Filme extends ItemBiblioteca {
    private int duracaoMinutos; // Ex: 120
    private String diretor;

    public Filme(String id, String titulo, int duracaoMinutos, String diretor) {
        super(id, titulo); // Passa ID e Título para a classe pai
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
        // Reaproveita a lógica do pai e adiciona os detalhes do filme
        return super.getTitulo() + " [Filme - Dir: " + diretor + ", " + duracaoMinutos + "min]";
    }
}