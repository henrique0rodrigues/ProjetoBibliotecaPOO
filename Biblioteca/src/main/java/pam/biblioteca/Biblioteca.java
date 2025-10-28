package pam.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Biblioteca {

    private List<Livro> acervo;
    private Scanner scanner;
    
    public Biblioteca(){
        this.acervo = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public void adicionarLivro(){
        System.out.println("Adicione as informacoes do livro: ");
        System.out.println("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.println("Quantidade de paginas: ");
        int qtdPags = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Tipo de capa: ");
        String tipoCapa = scanner.nextLine();
        System.out.println("Autor: ");
        String autor = scanner.nextLine();
        System.out.println("Ano de Publicacao: ");
        int anoPub = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Quantidade de exemplares disponiveis: ");
        int qtdExemplares = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Genero: ");
        String genero = scanner.nextLine();
        Livro novoLivro = new Livro( titulo,  qtdPags,  tipoCapa,  autor,  anoPub,  qtdExemplares,  genero);
        
        this.acervo.add(novoLivro);
        
        System.out.println("Livro "+ titulo + " adicionado com sucesso!");

    }
    
    public void listarLivros(){
        if(acervo.isEmpty()){
            System.out.println("A biblioteca esta vazia");
            return;
        }
        System.out.println("Livros na biblioteca: ");
        for(Livro livro: acervo){
            System.out.println(livro.getTitulo() + ". Quantidade de exemplares: "+ livro.getQtdExemplares());
            
        }
    }
    
    public int menu(){
        System.out.println("\nEscolha a opcao desejada: ");
        System.out.println("1 para adicionar livro;");
        System.out.println("2 para listar livros da biblioteca;");
        System.out.println("-1 para sair.");
        int menu = scanner.nextInt();
        scanner.nextLine();
        return menu;
    }
    
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        int menu;
                System.out.println("Bem vindo!");
        do{
            menu = biblioteca.menu();
        switch(menu){
            case 1 -> biblioteca.adicionarLivro();
            case 2 -> biblioteca.listarLivros();
            case -1 -> {
                }
        }}while(menu != -1);

    }
}
