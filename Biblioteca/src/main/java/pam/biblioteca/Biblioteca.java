package pam.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private List<Acoes> acervo;
    private Scanner leitor;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
        this.leitor = new Scanner(System.in);

        LivroDidatico livro1 = new LivroDidatico("Calculo Vol. 1", 500, "Brochura", "James Stewart", 2010, 10, "Matematica");
        LivroDidatico livro2 = new LivroDidatico("Java: Como Programar", 800, "Capa Dura", "Deitel", 2018, 7, "Programacao");
        this.acervo.add(livro1);
        this.acervo.add(livro2);

        RevistaCarros revista1 = new RevistaCarros("Revista AutoPower", 64, "MotorPress", "Mensal",
                58, 2025, 5, "Carros Esportivos", "Ferrari");
        this.acervo.add(revista1);

        JornalDeHoje jornal1 = new JornalDeHoje("Diario Nacional", "Editora Brasil", "Marcos Silva",
                "Atualidades", 1024, 24, 30,
                "Novo recorde na producao de veiculos eletricos no pais");
        this.acervo.add(jornal1);
    }

    public void menuPrincipal() {
        int opcao;

        do {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Adicionar Revista");
            System.out.println("3. Adicionar Jornal");
            System.out.println("4. Listar Itens do Acervo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            
            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1 -> menuLivros();
                case 2 -> menuRevistas();
                case 3 -> menuJornais();
                case 4 -> listarItens();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opcao invalida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private void menuLivros() {
        System.out.println("\nMenu de Livros");
        System.out.println("1. Livro Didatico");
        System.out.println("0. Voltar");
        System.out.print("Escolha o tipo: ");
        
        int tipo = leitor.nextInt();
        leitor.nextLine();

        switch (tipo) {
            case 1 -> adicionarLivroDidatico();
            case 0 -> System.out.println("Voltando...");
            default -> System.out.println("Tipo invalido.");
        }
    }

    private void menuRevistas() {
        System.out.println("\nMenu de Revistas");
        System.out.println("1. Revista de Carros");
        System.out.println("0. Voltar");
        System.out.print("Escolha o tipo: ");
        
        int tipo = leitor.nextInt();
        leitor.nextLine();

        switch (tipo) {
            case 1 -> adicionarRevistaCarros();
            case 0 -> System.out.println("Voltando...");
            default -> System.out.println("Tipo invalido.");
        }
    }

    private void menuJornais() {
        System.out.println("\nMenu de Jornais");
        System.out.println("1. Jornal de Hoje");
        System.out.println("0. Voltar");
        System.out.print("Escolha o tipo: ");
        
        int tipo = leitor.nextInt();
        leitor.nextLine();

        switch (tipo) {
            case 1 -> adicionarJornalDeHoje();
            case 0 -> System.out.println("Voltando...");
            default -> System.out.println("Tipo invalido.");
        }
    }

    private void adicionarLivroDidatico() {
        System.out.println("Adicionando Novo Livro Didatico");
        System.out.print("Titulo: ");
        String titulo = leitor.nextLine();
        
        System.out.print("Qtd de Paginas: ");
        int paginas = leitor.nextInt();
        leitor.nextLine();
        
        System.out.print("Tipo de Capa: ");
        String capa = leitor.nextLine();
        
        System.out.print("Autor: ");
        String autor = leitor.nextLine();
        
        System.out.print("Ano de Publicacao: ");
        int ano = leitor.nextInt();
        leitor.nextLine();
        
        System.out.print("Qtd de Exemplares: ");
        int quantidade = leitor.nextInt();
        leitor.nextLine();
        
        System.out.print("Materia: ");
        String materia = leitor.nextLine();

        LivroDidatico novoLivro = new LivroDidatico(titulo, paginas, capa, autor, ano, quantidade, materia);
        acervo.add(novoLivro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    private void adicionarRevistaCarros() {
        System.out.println("Adicionando Nova Revista de Carros");
        System.out.print("Titulo: ");
        String titulo = leitor.nextLine();
        
        System.out.print("Qtd de Paginas: ");
        int paginas = leitor.nextInt();
        leitor.nextLine();
        
        System.out.print("Editora: ");
        String editora = leitor.nextLine();
        
        System.out.print("Periodicidade: ");
        String periodicidade = leitor.nextLine();
        
        System.out.print("Numero da Edicao: ");
        int edicao = leitor.nextInt();
        leitor.nextLine();
        
        System.out.print("Ano de Publicacao: ");
        int ano = leitor.nextInt();
        leitor.nextLine();
        
        System.out.print("Qtd de Exemplares: ");
        int quantidade = leitor.nextInt();
        leitor.nextLine();
        
        System.out.print("Tema: ");
        String tema = leitor.nextLine();
        
        System.out.print("Marca em Destaque: ");
        String marca = leitor.nextLine();

        RevistaCarros novaRevista = new RevistaCarros(titulo, paginas, editora, periodicidade, edicao, ano, quantidade, tema, marca);
        acervo.add(novaRevista);
        System.out.println("Revista cadastrada com sucesso!");
    }

    private void adicionarJornalDeHoje() {
        System.out.println("Adicionando Novo Jornal");
        System.out.print("Titulo: ");
        String titulo = leitor.nextLine();
        
        System.out.print("Editora: ");
        String editora = leitor.nextLine();
        
        System.out.print("Editor-Chefe: ");
        String editorChefe = leitor.nextLine();
        
        System.out.print("Categoria: ");
        String categoria = leitor.nextLine();
        
        System.out.print("Numero da Edicao: ");
        int edicao = leitor.nextInt();
        leitor.nextLine();
        
        System.out.print("Qtd de Paginas: ");
        int paginas = leitor.nextInt();
        leitor.nextLine();
        
        System.out.print("Qtd de Exemplares: ");
        int quantidade = leitor.nextInt();
        leitor.nextLine();
        
        System.out.print("Manchete Principal: ");
        String manchete = leitor.nextLine();

        JornalDeHoje novoJornal = new JornalDeHoje(titulo, editora, editorChefe, categoria, edicao, paginas, quantidade, manchete);
        acervo.add(novoJornal);
        System.out.println("Jornal cadastrado com sucesso!");
    }

    private void listarItens() {
        if (acervo.isEmpty()) {
            System.out.println("A biblioteca esta vazia.");
            return;
        }
        System.out.println("\nItens no Acervo:");
        for (Acoes item : acervo) {
            System.out.println(item.toString());
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("Bem-vindo ao Sistema da Biblioteca!");
        biblioteca.menuPrincipal();
        biblioteca.leitor.close();
    }
}