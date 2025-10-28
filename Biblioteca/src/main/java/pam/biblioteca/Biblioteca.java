package pam.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate; 
import java.time.format.DateTimeParseException; 

public class Biblioteca {

    private List<Acoes> acervo;
    private Scanner scanner;
    
    public Biblioteca(){
        this.acervo = new ArrayList<>(); 
        this.scanner = new Scanner(System.in);
        
        // --- INICIO DO CADASTRO AUTOMATICO (SEM ACENTOS) ---
        
        // 2 Livros Comuns
        Livro l1 = new Livro("O Senhor dos Aneis", 1200, "Capa Dura", "J.R.R. Tolkien", 1954, 5, "Fantasia");
        Livro l2 = new Livro("O Guia do Mochileiro das Galaxias", 208, "Brochura", "Douglas Adams", 1979, 3, "Ficcao Cientifica");
        this.acervo.add(l1);
        this.acervo.add(l2);

        // 2 Livros Didaticos
        LivroDidatico ld1 = new LivroDidatico("Calculo Vol. 1", 500, "Brochura", "James Stewart", 2010, 10, "Matematica");
        LivroDidatico ld2 = new LivroDidatico("Java: Como Programar", 800, "Capa Dura", "Deitel", 2018, 7, "Programacao");
        this.acervo.add(ld1);
        this.acervo.add(ld2);
        
        // 2 Revistas
        Revista r1 = new Revista("Superinteressante", 80, "Abril", "Mensal", 450, 2024, 20, "Ciencia e Cultura");
        Revista r2 = new Revista("National Geographic", 100, "NatGeo", "Mensal", 300, 2023, 15, "Natureza e Exploracao");
        this.acervo.add(r1);
        this.acervo.add(r2);
        
        // 2 Jornais
        Jornal j1 = new Jornal("O Globo", "Globo", "Roberto Marinho", "Noticias Gerais", LocalDate.of(2025, 10, 27), 30000, 40, 50);
        Jornal j2 = new Jornal("Folha de S.Paulo", "Folha", "Otavio Frias", "Noticias Locais", LocalDate.of(2025, 10, 26), 29999, 35, 45);
        this.acervo.add(j1);
        this.acervo.add(j2);

        // --- FIM DO CADASTRO AUTOMATICO ---
    }
    
    public void adicionarLivro(){
        System.out.println("--- Adicionando Novo Livro ---");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Quantidade de paginas: ");
        int qtdPags = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo de capa: ");
        String tipoCapa = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de Publicacao: ");
        int anoPub = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Quantidade de exemplares disponiveis: ");
        int qtdExemplares = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Genero: ");
        String genero = scanner.nextLine();
        
        Livro novoLivro = new Livro( titulo,  qtdPags,  tipoCapa,  autor,  anoPub,  qtdExemplares,  genero);
        
        this.acervo.add(novoLivro);
        
        System.out.println("Livro '"+ titulo + "' adicionado com sucesso!");
    }

    public void adicionarLivroDidatico(){
        System.out.println("--- Adicionando Novo Livro Didatico ---");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Quantidade de paginas: ");
        int qtdPags = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo de capa: ");
        String tipoCapa = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de Publicacao: ");
        int anoPub = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Quantidade de exemplares disponiveis: ");
        int qtdExemplares = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Materia: ");
        String materia = scanner.nextLine();
        
        LivroDidatico novoLivro = new LivroDidatico(titulo, qtdPags, tipoCapa, autor, anoPub, qtdExemplares, materia);
        
        this.acervo.add(novoLivro);
        
        System.out.println("Livro Didatico '"+ titulo + "' adicionado com sucesso!");
    }
    
    public void adicionarRevista(){
        System.out.println("--- Adicionando Nova Revista ---");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Editora: ");
        String editora = scanner.nextLine();
        System.out.print("Periodicidade (ex: Mensal): ");
        String periodicidade = scanner.nextLine();
        System.out.print("Tema (ex: Esportes): ");
        String tema = scanner.nextLine();
        System.out.print("Quantidade de paginas: ");
        int qtdPags = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Numero da Edicao: ");
        int numeroEdicao = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ano de Publicacao: ");
        int anoPub = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Quantidade de exemplares disponiveis: ");
        int qtdExemplares = scanner.nextInt();
        scanner.nextLine();

        Revista novaRevista = new Revista(titulo, qtdPags, editora, periodicidade, numeroEdicao, anoPub, qtdExemplares, tema);
        
        this.acervo.add(novaRevista);
        
        System.out.println("Revista '"+ titulo + "' adicionada com sucesso!");
    }
    
    public void adicionarJornal(){
        System.out.println("--- Adicionando Novo Jornal ---");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Editora: ");
        String editora = scanner.nextLine();
        System.out.print("Editor-Chefe: ");
        String editorChefe = scanner.nextLine();
        System.out.print("Categoria (ex: Noticias Locais): ");
        String categoria = scanner.nextLine();
        
        LocalDate dataPub = null;
        while (dataPub == null) {
            try {
                System.out.print("Data de Publicacao (AAAA-MM-DD): ");
                String dataStr = scanner.nextLine();
                dataPub = LocalDate.parse(dataStr); 
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data invalido. Use AAAA-MM-DD. Tente novamente.");
            }
        }
        
        System.out.print("Numero da Edicao: ");
        int numeroEdicao = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Quantidade de paginas: ");
        int qtdPaginas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Quantidade de exemplares disponiveis: ");
        int qtdExemplares = scanner.nextInt();
        scanner.nextLine();

        Jornal novoJornal = new Jornal(titulo, editora, editorChefe, categoria, dataPub, numeroEdicao, qtdPaginas, qtdExemplares);
        
        this.acervo.add(novoJornal);
        
        System.out.println("Jornal '"+ titulo + "' adicionado com sucesso!");
    }
    
    
    public void listarItens(){
        if(acervo.isEmpty()){
            System.out.println("A biblioteca esta vazia");
            return;
        }
        System.out.println("\n--- Itens na Biblioteca ---");
        
        for(Acoes item : acervo){
            System.out.println(item.toString()); 
            System.out.println("---------------------------");
        }
    }
    
    public int menu(){
        System.out.println("\n--- Menu da Biblioteca ---");
        System.out.println("1 para adicionar Livro");
        System.out.println("2 para adicionar Livro Didatico");
        System.out.println("3 para adicionar Revista");
        System.out.println("4 para adicionar Jornal");
        System.out.println("5 para listar TODOS os itens");
        System.out.println("-1 para sair.");
        System.out.print("Escolha a opcao desejada: ");
        
        int menu = scanner.nextInt();
        scanner.nextLine(); // Limpa o scanner
        return menu;
    }
    
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        int menu;
        
        System.out.println("Bem vindo ao Sistema da Biblioteca!");
        
        do{
            menu = biblioteca.menu(); 
            
            switch(menu){
                case 1 -> biblioteca.adicionarLivro();
                case 2 -> biblioteca.adicionarLivroDidatico();
                case 3 -> biblioteca.adicionarRevista();
                case 4 -> biblioteca.adicionarJornal();
                case 5 -> biblioteca.listarItens();
                case -1 -> {
                    System.out.println("Saindo do sistema...");
                }
                default -> {
                     System.out.println("Opcao invalida! Tente novamente.");
                }
            }
        } while(menu != -1);
        
        biblioteca.scanner.close();
    }
}