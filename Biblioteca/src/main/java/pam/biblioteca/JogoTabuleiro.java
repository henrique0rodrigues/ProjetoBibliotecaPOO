package pam.biblioteca;

public class JogoTabuleiro extends ItemBiblioteca {
    private int numeroJogadores;

    public JogoTabuleiro(String id, String titulo, int numeroJogadores) {
        super(id, titulo); // Chama o construtor do pai (ItemBiblioteca)
        this.numeroJogadores = numeroJogadores;
    }

    public int getNumeroJogadores() {
        return numeroJogadores;
    }

    @Override
    public String toString() {
        return super.getTitulo() + " (Jogo para " + numeroJogadores + " pessoas)"+ " (ID: "+ id +")";
    }
}