package pam.biblioteca;

public class JogoTabuleiro extends ItemBiblioteca {
    private int numeroJogadores;

    public JogoTabuleiro(String id, String titulo, int numeroJogadores) {
        super(id, titulo); // Chama o construtor do pai (ItemBiblioteca)
        this.numeroJogadores = numeroJogadores;
    }
    
    // Getter específico desta classe
    public int getNumeroJogadores() {
        return numeroJogadores;
    }

    // Opcional: Sobrescrever toString para mostrar detalhes do jogo
    @Override
    public String toString() {
        return super.getTitulo() + " (Jogo para " + numeroJogadores + " pessoas)";
    }
}