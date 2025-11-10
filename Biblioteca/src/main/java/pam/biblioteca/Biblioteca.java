package pam.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Biblioteca {

    private List<Acoes> acervo;
    private Scanner scanner;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        // --- CADASTRO AUTOMATICO DE EXEMPLOS ---

        LivroDidatico ld1 = new LivroDidatico("Calculo Vol. 1", 500, "Brochura", "James Stewart", 2010, 10, "Matematica");
        LivroDidatico ld2 = new LivroDidatico("Java: Como Programar", 800, "Capa Dura", "Deitel", 2018, 7, "Programacao");
        this.acervo.add(ld1);
        this.acervo.add(ld2);

        RevistaCarros r1 = new RevistaCarros("Revista AutoPower", 64, "MotorPress", "Mensal",
                58, 2025, 5, "Carros Esportivos", "Ferrari");
        this.acervo.add(r1);

        JornalDeHoje j1 = new JornalDeHoje("Diario Nacional", "Editora Brasil", "Marcos Silva",
                "Atualidades", 1024, 24, 30,
                "Novo recorde na producao de veiculos eletricos no pais");
        this.acervo.add(j1);
    }

    // ============ NOVO MÉTODO DE MENU PRINCIPAL ESCALONÁVEL ============
    public void menuPrincipal() {
        int opcaoPrincipal;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Adicionar Revista");
            System.out.println("3. Adicionar Jornal");
            System.out.println("4. Listar Itens do Acervo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcaoPrincipal = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcaoPrincipal) {
                case 1 -> menuLivros();
                case 2 -> menuRevistas();
                case 3 -> menuJornais();
                case 4 -> listarItens();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opcao invalida. Tente novamente.");
            }

        } while (opcaoPrincipal != 0);
    }

    // ================= MENU LIVROS =================
    private void menuLivros() {
        System.out.println("\n--- Menu de Livros ---");
        System.out.println("1. Livro Didatico");
        // Futuramente: 2. Livro Tecnico, 3. Livro Literario, etc.
        System.out.println("0. Voltar");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        switch (tipo) {
            case 1 -> adicionarLivroDidatico();
            case 0 -> System.out.println("Voltando ao menu principal...");
            default -> System.out.println("Tipo de livro invalido.");
        }
    }

    // ================= MENU REVISTAS =================
    private void menuRevistas() {
        System.out.println("\n--- Menu de Revistas ---");
        System.out.println("1. Revista de Carros");
        // Futuramente: 2. Revista Cientifica, 3. Revista Moda, etc.
        System.out.println("0. Voltar");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        switch (tipo) {
            case 1 -> adicionarRevistaCarros();
            case 0 -> System.out.println("Voltando ao menu principal...");
            default -> System.out.println("Tipo de revista invalido.");
        }
    }

    // ================= MENU JORNAIS =================
    private void menuJornais() {
        System.out.println("\n--- Menu de Jornais ---");
        System.out.println("1. Jornal de Hoje");
        // Futuramente: 2. Jornal Semanal, etc.
        System.out.println("0. Voltar");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        switch (tipo) {
            case 1 -> adicionarJornalDeHoje();
            case 0 -> System.out.println("Voltando ao menu principal...");
            default -> System.out.println("Tipo de jornal invalido.");
        }
    }

    // ================= SUBCLASSE: LivroDidatico =================
    private void adicionarLivroDidatico() {
        System.out.println("--- Adicionando Novo Livro Didatico ---");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Qtd de Paginas: ");
        int pags = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo de Capa: ");
        String capa = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de Publicacao: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Qtd de Exemplares: ");
        int qtd = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Materia: ");
        String materia = scanner.nextLine();

        LivroDidatico novo = new LivroDidatico(titulo, pags, capa, autor, ano, qtd, materia);
        acervo.add(novo);
        System.out.println("Livro Didatico '" + titulo + "' adicionado com sucesso!");
    }

    // ================= SUBCLASSE: RevistaCarros =================
    private void adicionarRevistaCarros() {
        System.out.println("--- Adicionando Nova Revista de Carros ---");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Qtd de Paginas: ");
        int pags = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Editora: ");
        String editora = scanner.nextLine();
        System.out.print("Periodicidade: ");
        String periodicidade = scanner.nextLine();
        System.out.print("Numero da Edicao: ");
        int numEd = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ano de Publicacao: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Qtd de Exemplares: ");
        int qtd = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tema: ");
        String tema = scanner.nextLine();
        System.out.print("Marca em Destaque: ");
        String marca = scanner.nextLine();

        RevistaCarros nova = new RevistaCarros(titulo, pags, editora, periodicidade, numEd, ano, qtd, tema, marca);
        acervo.add(nova);
        System.out.println("Revista de Carros '" + titulo + "' adicionada com sucesso!");
    }

    // ================= SUBCLASSE: JornalDeHoje =================
    private void adicionarJornalDeHoje() {
        System.out.println("--- Adicionando Novo Jornal de Hoje ---");
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Editora: ");
        String editora = scanner.nextLine();
        System.out.print("Editor-Chefe: ");
        String chefe = scanner.nextLine();
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Numero da Edicao: ");
        int numEd = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Qtd de Paginas: ");
        int pags = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Qtd de Exemplares: ");
        int qtd = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Manchete Principal: ");
        String manchete = scanner.nextLine();

        JornalDeHoje novo = new JornalDeHoje(titulo, editora, chefe, categoria, numEd, pags, qtd, manchete);
        acervo.add(novo);
        System.out.println("Jornal de Hoje '" + titulo + "' adicionado com sucesso!");
    }

    // ================= LISTAGEM =================
    private void listarItens() {
        if (acervo.isEmpty()) {
            System.out.println("A biblioteca esta vazia.");
            return;
        }
        System.out.println("\n--- Itens no Acervo ---");
        for (Acoes item : acervo) {
            System.out.println(item.toString());
            System.out.println("---------------------------");
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("Bem-vindo ao Sistema da Biblioteca!");
        biblioteca.menuPrincipal();
        biblioteca.scanner.close();
    }
}
