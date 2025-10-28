package pam.biblioteca;
public class Livro implements Acoes{
    private String titulo;
    private int qtdPags;
    private String tipoCapa;
    private String autor;
    private String genero;
    private int anoPub;
    private int qtdExemplares = 0;
    
    public Livro(){}
    
    public Livro(String titulo, int qtdPags, String tipoCapa, String autor, int anoPub, int qtdExemplares, String genero){
        this.titulo = titulo;
        this.qtdPags = qtdPags;
        this.tipoCapa = tipoCapa;
        this.autor = autor;
        this.anoPub = anoPub;
        this.qtdExemplares = qtdExemplares;
        this.genero = genero;
    }
    

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getQtdExemplares() {
        return qtdExemplares;
    }
    
    public String getGenero(){
        return genero;
    }
    
    @Override
    public boolean disponivel(){
        return (this.qtdExemplares > 0);
    }
    
    @Override
    public boolean emprestar(){
        if(this.disponivel()){
            this.qtdExemplares--;
            System.out.println("Emprestimo do livro '" + this.titulo + "' realizado com sucesso!");
            return true;
        }else {
            System.out.println("Erro. nao ha exemplares disponiveis no momento.");
            return false;
        }
    }
    
    @Override
    public void devolver(){
        this.qtdExemplares++;
        System.out.println("O livro '"+ this.titulo +"' foi devolvido com sucesso!");
    }
    
    
    @Override
    public String toString(){
        return "--- Informações do livro ---" +
               "Titulo: " + titulo + "\n" +
               "Autor: " + autor + "\n" +
               "Paginas: " + qtdPags + "\n" +
               "Ano de Publicacao: " + anoPub + "\n" +
               "Tipo de Capa: " + tipoCapa + "\n" +
               "Exemplares Disponiveis: " + qtdExemplares + "\n" +
               "---------------------------";
    }
    
    @Override
    public void doar(){
        this.qtdExemplares++;
        System.out.println("Doacao recebida! O novo exemplar de '"+ this.titulo + "' ja esta disponivel!");
    }
    
}
