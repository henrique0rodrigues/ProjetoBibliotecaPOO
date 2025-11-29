package pam.biblioteca;

public class Equipamento extends ItemBiblioteca {
    private String marca; 

    public Equipamento(String id, String titulo, String marca) {
        super(id, titulo);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return super.getTitulo() + " [Equipamento - Marca: " + marca + "]";
    }
}