package pam.biblioteca;

public class LivroDidatico extends Livro {
    
    private String materia;
    
    public LivroDidatico(String titulo, int qtdPags, String tipoCapa, String autor, int anoPub, int qtdExemplares, String materia){
        super(titulo, qtdPags, tipoCapa, autor, anoPub, qtdExemplares, "Didático");
        this.materia = materia;
}

    public String getMateria() {
        return materia;
    }
    
    @Override
    public String toString(){
        String infopai = super.toString();
        String infofilho = infopai + "Materia: " + this.materia + "\n"+
                                     "-------------------------\n";
    return infofilho;
    }
}
