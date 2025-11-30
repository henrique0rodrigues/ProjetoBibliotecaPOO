package pam.biblioteca;
class Livro extends ItemBiblioteca {
    private String autor;
    public Livro(String id, String titulo, String autor) {
        super(id, titulo);
        this.autor = autor;
    }
    
    @Override
    public String toString() {
        return super.getTitulo() + " Autor: " + autor + " (ID: "+ id +")";
    }
}
