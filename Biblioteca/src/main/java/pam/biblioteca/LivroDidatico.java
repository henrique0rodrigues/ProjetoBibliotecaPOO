package pam.biblioteca;

public class LivroDidatico extends Livro {
    
    private String materia;
    
    public LivroDidatico(String titulo, int qtdPags, String tipoCapa, String autor, int anoPub, int qtdExemplares, String materia){
        super(titulo, qtdPags, tipoCapa, autor, anoPub, qtdExemplares, "Didatico");
        this.materia = materia;
}

    public String getMateria() {
        return materia;
    }
    
    @Override
    public String toString(){
        String infopai = super.toString();
        String infofilho = infopai + "\n" + // Adicionei quebra de linha para ficar melhor
                           "Materia: " + this.materia + "\n"+ // Removido 'é'
                           "-------------------------"; // Ajustei o fechamento
    return infofilho;
    }
}