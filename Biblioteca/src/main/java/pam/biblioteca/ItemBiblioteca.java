package pam.biblioteca;
public abstract class ItemBiblioteca {
    protected String id;
    protected String titulo;
    protected boolean disponivel;

    public ItemBiblioteca(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.disponivel = true; 
    }

    public String getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    @Override public String toString() {
        return titulo;
    }
}
