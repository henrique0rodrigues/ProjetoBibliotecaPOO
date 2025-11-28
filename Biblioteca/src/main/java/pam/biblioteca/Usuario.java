package pam.biblioteca;

public class Usuario {
    private String id;
    private String nome;
    private boolean bloqueado;

    public Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.bloqueado = false;
    }

    public String getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public boolean isBloqueado() {
        return bloqueado;
    }
    
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    
    @Override public String toString() {
        return nome + " (ID: " + id + ")";
    }
}
